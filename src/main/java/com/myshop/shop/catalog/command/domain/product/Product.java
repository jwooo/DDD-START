package com.myshop.shop.catalog.command.domain.product;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    private ProductId id;

    protected Product() {}
}
