package com.myshop.shop.order.ui;


import com.myshop.shop.order.command.application.OrderProduct;
import com.myshop.shop.order.command.application.OrderRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderRequestValidator4Spring implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderRequest orderRequest = (OrderRequest) target;
        if (orderRequest.getOrderProducts() == null || orderRequest.getOrderProducts().isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderProducts", "required");
        } else {
            for (int i = 0; i < orderRequest.getOrderProducts().size(); i++) {
                OrderProduct orderProduct = orderRequest.getOrderProducts().get(i);
                if (orderProduct.getProductId() == null || orderProduct.getProductId().trim().isEmpty()) {
                    errors.rejectValue("orderProducts[" + i + "].productId", "required");
                }
                if (orderProduct.getQuantity() <= 0) {
                    errors.rejectValue("orderProducts[" + i + "].quantity", "nonPositive");
                }
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingInfo.receiver.name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingInfo.receiver.phone", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingInfo.address.zipCode", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingInfo.address.address1", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shippingInfo.address.address2", "required");
    }
}
