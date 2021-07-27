package com.example.MyWebApp.converter;

import com.example.MyWebApp.beans.UserSettingsBean;
import com.example.MyWebApp.data.Theme;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ThemeConverter implements Serializable, Converter {

    @Inject
    private UserSettingsBean userSettingsBean;

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Theme> themes = userSettingsBean.getAvailableThemes();
        for (Theme theme : themes) {
            if (theme.getName().equals(value)) {
                return theme;
            }
        }

        return null;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Theme) value).getName();
    }
}
