package com.myshop.shop.catalog.command.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image {

    protected InternalImage() {}

    public InternalImage(String path) {
        super(path);
    }

    @Override
    public String getURL() {
        return "/images/original/" + getPath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailURL() {
        return "/images/thumnail/" + getPath();
    }
}
