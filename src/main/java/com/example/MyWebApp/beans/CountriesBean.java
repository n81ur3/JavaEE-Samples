package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Country;
import com.example.MyWebApp.service.CountryService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Arrays;
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
    private String newId;
    private String newCode;
    private String newName;
    private Country selectedForDeletion;
    private List<String> properties;

    @Inject
    private CountryService countryService;

    @PostConstruct
    private void init() {
        properties = Arrays.asList("id", "code", "name");
    }

    public List<Country> getCountries() {
        return countryService.getAll();
    }

    public List<Country> getRandomCountries() {
        return countryService.getRandomCountries(50);
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

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void save() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("country_form:save", new FacesMessage("Countries persisted to DB"));
        context.addMessage(null, new FacesMessage("Saved successfully"));
    }

    public void addCountry() {
        countryService.addCountry(new Country(Integer.parseInt(newId), Integer.parseInt(newCode), newName));
        newId = "";
        newCode = "";
        newName = "";
    }

    public void delete() {
        countryService.delete(selectedForDeletion);
    }

    public Country getSelectedForDeletion() {
        return selectedForDeletion;
    }

    public void setSelectedForDeletion(Country selectedForDeletion) {
        this.selectedForDeletion = selectedForDeletion;
    }

    public List<String> getProperties() {
        return properties;
    }
}
