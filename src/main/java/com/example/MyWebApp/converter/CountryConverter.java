package com.example.MyWebApp.converter;

import com.example.MyWebApp.data.Country;
import com.example.MyWebApp.service.CountryService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@FacesConverter(forClass = Country.class, managed = true)
@Named
public class CountryConverter implements Converter<Country> {

    @Inject
    private CountryService countryService;

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Country country) {
        if (country == null) {
            return "";
        }

        if (country.getId() != 0) {
            return String.valueOf(country.getId());
        } else {
            throw new ConverterException(new FacesMessage("Invalid country ID"));
        }
    }

    @Override
    public Country getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        try {
            int index = Integer.parseInt(id);
            return countryService.getById(index - 1);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage("Invalid country ID"), e);
        }
    }

}
