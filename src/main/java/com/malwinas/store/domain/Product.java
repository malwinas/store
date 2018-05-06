package com.malwinas.store.domain;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Product {

    @PrimaryKey
    private UUID id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Date expiry;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
