package com.myshop.shop.intergration;

public interface OffsetStore {
    long get();
    void update(long nextOffset);
}
