package com.example.MyWebApp.service;

import com.example.MyWebApp.data.Country;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Stateless
public class CountryService implements Serializable {
    private final static long serialVersionUID = 1L;
    private List<Country> countries;

    @PostConstruct
    public void init() {
        countries = new ArrayList<>();
        countries.add(new Country(1, 43, "Austria"));
        countries.add(new Country(2, 49, "Germany"));
        countries.add(new Country(3, 420, "Czech Republic"));
        countries.add(new Country(4, 36, "Hungary"));
        countries.add(new Country(5, 53, "Romania"));
    }

    public List<Country> getAll() {
        return countries;
    }

    public Country getById(Integer id) {
        return countries.get(id);
    }

    public List<Country> getRandomCountries(int count) {
        List<Country> result = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            result.add(new Country(i, random.nextInt() % 100, "Country" + random.nextInt() % 100));
        }
        return result;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void delete(Country country) {
        countries.remove(country);
    }
}
