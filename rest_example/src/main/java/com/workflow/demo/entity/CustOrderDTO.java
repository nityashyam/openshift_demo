package com.workflow.demo.entity;

public class CustOrderDTO {
    private String firstName;
    private Long orderId;

    public CustOrderDTO(String firstName, Long orderId) {
        this.firstName = firstName;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "CustOrderDTO{" +
                "firstName='" + firstName + '\'' +
                ", orderId=" + orderId +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
