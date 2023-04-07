package com.myshop.shop.order.command.domain;

import lombok.Getter;

@Getter
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Receiver)) return false;
        Receiver that = (Receiver) o;
        return this.name.equals(that.name) && this.phoneNumber.equals(that.phoneNumber);
    }
}
