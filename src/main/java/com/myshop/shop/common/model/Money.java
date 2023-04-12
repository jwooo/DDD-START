package com.myshop.shop.common.model;

import java.util.Objects;

public class Money {

    private int value;

    protected Money() {}

    public Money(int value) {
        this.value = value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.getValue());
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj ==null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return value == money.value;
    }
}
