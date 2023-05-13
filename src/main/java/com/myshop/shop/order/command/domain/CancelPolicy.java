package com.myshop.shop.order.command.domain;

public interface CancelPolicy {
    boolean hasCancellationPermission(Order order, Canceller canceller);
}
