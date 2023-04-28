package com.myshop.shop.catalog.command.domain.product;

import com.myshop.shop.common.jpa.MoneyConverter;
import com.myshop.shop.common.model.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money money;

    private String detail;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    protected Product() {}

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
