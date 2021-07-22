package com.example.MyWebApp.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Named
@ViewScoped
public class NumbersBean implements Serializable {
    private final static long serialVersionUID = 1L;
    private List<Integer> numbers;
    private BigDecimal price = new BigDecimal("83.48");

    @PostConstruct
    public void init() {
        numbers = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt() % 100);
        }
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal newPrice) {
        price = newPrice;
    }
}
