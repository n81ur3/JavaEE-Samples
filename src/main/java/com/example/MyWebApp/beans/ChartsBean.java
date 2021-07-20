package com.example.MyWebApp.beans;

import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Random;

@Named
@RequestScoped
public class ChartsBean {
    private LineChartModel lineModel1;

    @PostConstruct
    public void init() {
        createLineModel();
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    private void createLineModel() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Sample Chart");
        lineModel1.setLegendPosition("ne");
        lineModel1.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        lineModel1.setAnimate(true);
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(120);

        Axis xAxis = lineModel1.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(100);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        Random random = new Random();

        LineChartSeries series = new LineChartSeries();
        series.setLabel("Price Development");

        for (int x = 0; x < 100; x++) {
            series.set(x, (random.nextInt() % 90) + 10);
        }

        model.addSeries(series);
        model.setSeriesColors("1CA5FF");
        model.setExtender("chart");
        return model;
    }
}
