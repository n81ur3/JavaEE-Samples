package com.example.MyWebApp.validation;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@PeriodConstraint
public class Period implements Serializable {
    private final static long serialVersionUID = 1L;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
