package com.myshop.shop.eventstore.ui;

import com.myshop.shop.eventstore.api.EventEntry;
import com.myshop.shop.eventstore.api.EventStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventApi {
    private EventStore eventStore;

    public EventApi(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @GetMapping("/api/events")
    public List<EventEntry> list(@RequestParam("offset") Long offset,
                                 @RequestParam("limit") Long limit) {
        return eventStore.get(offset, limit);
    }
}
