package com.myshop.shop.order.ui;

import com.myshop.shop.order.command.application.CancelOrderService;
import com.myshop.shop.order.command.domain.Canceller;
import com.myshop.shop.order.command.domain.OrderNo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CancelOrderController {
    private CancelOrderService cancelOrderService;

    public CancelOrderController(CancelOrderService cancelOrderService) {
        this.cancelOrderService = cancelOrderService;
    }

    @RequestMapping("/my/orders/{orderNo}/cancel")
    public String orderDetail(@PathVariable("orderNo") String orderNo, ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cancelOrderService.cancel(new OrderNo(orderNo), new Canceller(user.getUsername()));
        return "/my/orderCanceled";
    }
}
