package com.myshop.shop.eventstore.api;

import java.util.List;

public interface EventStore {
    void save(Object event);

    List<EventEntry> get(long offset, long limit);
}
