package com.myshop.shop.order.command.domain;

import java.util.List;

/**
 * 요구사항
 * - 최소 한 종류 이상의 상품을 주문해야 한다. => Order와 OrderLine과의 관계를 알려준다.
 * - 한 상품을 한 개 이상 주문할 수 있다. => 주문 항목이 어떤 데이터로 구성되는지 알 수 있다.
 * - 총 주문 금액은 각 상품의 구매 가격 합을 모든 더한 금액이다. => Order와 OrderLine의 관계를 알려준다.
 * - 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다. => 주문 항목이 어떤 데이터로 구성되는지 알 수 있다.
 * - 주문할 때 배송지 정보를 반드시 지정해야 한다.
 * - 배송지 정보는 정보를 반드시 지정해야 한다.
 * - 배송지 정보는 받는 사람, 이름, 전화번호, 주소로 구성된다.
 * - 출고를 하면 배송지를 변경할 수 없다. => 출고 상태가 되기 전과 후의 제약사항을 기술 (출고 상태를 표현할 수 있어야 한다.)
 * - 출고 전에 주문을 취소할 수 있다. => 출고 상태가 되기 전과 후의 제약사항을 기술 (출고 상태를 표현할 수 있어야 한다.)
 * - 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다. => 출고 상태를 표현할 수 있어야 한다.
 *
 * 이 요구사항에서 알 수 있는 것
 * 출고 상태로 변경하기, 배송지 정보 변경하기, 주문 취소하기, 결제 완료하기
 *
 */
public class Order {
    private OrderNo number;
    private List<OrderLine> orderLines;
    private Orderer orderer;
    private ShippingInfo shippingInfo;
    private OrderState state;
    private Money totalAmounts;

    public Order(Orderer orderer,
                 List<OrderLine> orderLines,
                 ShippingInfo shippingInfo,
                 OrderState state) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
    }

    private void setOrderer(Orderer orderer) {
       if (orderer == null) throw new IllegalArgumentException("no orderer");
       this.orderer = orderer;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        setShippingInfo(newShippingInfo);
    }

    private void setShippingInfo(ShippingInfo newShippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = newShippingInfo;
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLines");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(orderLine -> orderLine.getAmounts().getValue())
                .sum());
    }

    public void changeShipped() {

    }

    public void changeShippedInfo(ShippingInfo newShipping) {
        verifyNotYetShipped();
        setShippingInfo(newShipping);
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    public void completePayment() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != Order.class) return false;
        Order other = (Order) o;
        if (this.number == null) return false;
        return this.number.equals(other.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalArgumentException("already shipped");
    }
}
