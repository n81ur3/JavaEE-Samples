package com.example.MyWebApp.beans;

import com.example.MyWebApp.validation.Period;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PeriodBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Period period = new Period();

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }
}
