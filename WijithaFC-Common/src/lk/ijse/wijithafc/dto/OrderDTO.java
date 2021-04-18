/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.dto;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class OrderDTO extends SuperDTO {

    private String orderID;
    private String userID;
    private String OrderDate;
    private String orderTime;
    private List<OrderDetailDTO> detailList;
    private PaymentDTO paymentDTO;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, String OrderDate, String orderTime, List<OrderDetailDTO> detailList, PaymentDTO paymentDTO) {
        this.orderID = orderID;
        this.userID = userID;
        this.OrderDate = OrderDate;
        this.orderTime = orderTime;
        this.detailList = detailList;
        this.paymentDTO = paymentDTO;
    }


    

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the OrderDate
     */
    public String getOrderDate() {
        return OrderDate;
    }

    /**
     * @param OrderDate the OrderDate to set
     */
    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    /**
     * @return the detailList
     */
    public List<OrderDetailDTO> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<OrderDetailDTO> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + getOrderID() + ", OrderDate=" + getOrderDate() + '}';
    }

    /**
     * @return the orderTime
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime the orderTime to set
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @return the paymentDTO
     */
    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    /**
     * @param paymentDTO the paymentDTO to set
     */
    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

}
