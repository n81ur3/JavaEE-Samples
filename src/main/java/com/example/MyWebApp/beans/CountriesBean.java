package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Country;
import com.example.MyWebApp.service.CountryService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CountriesBean implements Serializable {
    private final static long serialVersionUID = 3L;
    private String selectedCountry;
    private final String[] countryCodes = new String[]{"DE", "AT", "US"};
    private final String[] germanCountries = new String[]{"Berlin", "Hamburg", "Munich", "Colone"};
    private final String[] austrianCountries = new String[]{"Vienna", "Graz", "Salzburg", "Kapfenberg"};
    private final String[] usCountries = new String[]{"New York", "Michigan", "Washington", "Philadelphia"};
    private String selectedCountryCode = "AT";
    private String[] citySelection = austrianCountries;

    @Inject
    private CountryService countryService;

    public List<Country> getCountries() {
        return countryService.getAll();
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public String navigate() {
        return "selectionResult.xhtml?faces-redirect=true";
    }

    public String[] getCountryCodes() {
        return countryCodes;
    }

    public void setCities() {
        switch (selectedCountry) {
            case("AT"): {
                citySelection = austrianCountries;
                break;
            }
            case("DE"): {
                citySelection = germanCountries;
                break;
            }
            default: {
                citySelection = usCountries;
            }
        }

    }

    public String getSelectedCountryCode() {
        return selectedCountryCode;
    }

    public void setSelectedCountryCode(String selectedCountryCode) {
        this.selectedCountryCode = selectedCountryCode;
    }

    public String[] getCitySelection() {
        return citySelection;
    }

    public void setCitySelection(String[] citySelection) {
        this.citySelection = citySelection;
    }
}
