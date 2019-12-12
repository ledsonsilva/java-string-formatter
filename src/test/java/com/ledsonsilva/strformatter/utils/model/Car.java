package com.ledsonsilva.strformatter.utils.model;

import com.ledsonsilva.strformatter.annotation.PositionalFormatter;
import com.ledsonsilva.strformatter.enums.PaddingDirectionEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Car {

    @PositionalFormatter(size = 3, padding = '0', paddingDirection = PaddingDirectionEnum.LEFT)
    private Long id;

    @PositionalFormatter(size = 10)
    private String brand;

    @PositionalFormatter(size = 20)
    private String name;

    @PositionalFormatter(size = 15, dateFormat = "dd/MM/YYYY")
    private LocalDate dtFabrication;

    @PositionalFormatter(size = 6)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDtFabrication() {
        return dtFabrication;
    }

    public void setDtFabrication(LocalDate dtFabrication) {
        this.dtFabrication = dtFabrication;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
