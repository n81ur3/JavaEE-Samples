package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Theme;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Named
@SessionScoped
public class UserSettingsBean implements Serializable {

    private Map<String, String> themes; // for stateless theme switcher
    private List<Theme> availableThemes; // for stateful theme switcher
    private Theme theme; // selected theme

    public Map<String, String> getThemes() {
        return themes;
    }

    public List<Theme> getAvailableThemes() {
        return availableThemes;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @PostConstruct
    public void init() {
        themes = new TreeMap<String, String>();
        themes.put("Midnight", "midnight");
        themes.put("Vader", "vader");

        availableThemes = new ArrayList<Theme>();
        for (Map.Entry<String, String> theme : themes.entrySet()) {
            availableThemes.add(new Theme(theme.getKey(), theme.getValue()));
        }

        // set "Home" theme as default
        theme = availableThemes.get(0);
    }
}

