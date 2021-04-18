/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ASUS
 */
@Entity
public class Orders {

    @Id
    private String orderID;
    private String userID;
    private String orderDate;
    private String orderTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> detailList;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    public Orders() {
    }

    public Orders(String orderID, String userID, String orderDate, String orderTime) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public Orders(String orderID, String userID, String orderDate, String orderTime, List<OrderDetail> detailList, Payment payment) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.detailList = detailList;
        this.payment = payment;
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

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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
     * @return the detailList
     */
    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", userID=" + userID + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", payment=" + payment + '}';
    }

}
