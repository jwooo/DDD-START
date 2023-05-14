package com.myshop.shop.admin.ui;

import com.myshop.shop.order.command.application.StartShippingRequest;
import com.myshop.shop.order.command.application.StartShippingService;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminOrderController {

    private StartShippingService startShippingService;

    public AdminOrderController(StartShippingService startShippingService) {
        this.startShippingService = startShippingService;
    }

    @RequestMapping(value = "/admin/orders/{orderNo}/shipping", method = RequestMethod.POST)
    public String startShippingOrder(@PathVariable("orderNo") String orderNo,
                                     @RequestParam("version") long version) {
        try {
            startShippingService.startShipping(new StartShippingRequest(orderNo, version));
            return "admin/adminOrderShipped";
        } catch (OptimisticLockingFailureException e) {
            return "admin/adminOrderLockFail";
        }
    }
}
