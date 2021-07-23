package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Country;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("editCountry")
@ViewScoped
public class EditCountryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
