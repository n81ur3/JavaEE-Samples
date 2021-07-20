package com.example.MyWebApp.beans;

import org.primefaces.component.colorpicker.ColorPicker;

import javax.el.MethodExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ColorBean implements Serializable {
    private final static long serialVersionUID = 1L;

    private String colorInline = "#888888";
    private String colorPopup;
    private String text1;

    public void setColorInline(String color) {
        colorInline = color;
    }

    public void setColorPopup(String color) {
        colorPopup = color;
    }

    public String getColorInline() {
        return colorInline;
    }

    public void onColorInlineChange(AjaxBehaviorEvent e) {
        ColorPicker picker = (ColorPicker) e.getComponent();
        colorInline = picker.getValue().toString();
    }

    public String getColorPopup() {
        return colorPopup;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text) {
        text1 = text;
    }

    public String action() {
        return "";
    }
}
