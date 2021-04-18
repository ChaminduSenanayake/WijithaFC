/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS
 */
@Entity
public class OrderDetail {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "orderID",referencedColumnName = "orderID",insertable = false,updatable = false))
    private Orders order;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns(@JoinColumn(name = "itemCode",referencedColumnName = "itemCode",insertable = false,updatable = false))
    private Item item;
    private double unitPrice;
    private int qty;
    private double discount;
    @EmbeddedId
    private OrderDetail_pk orderDetail_pk;
    

    public OrderDetail() {
    }

    public OrderDetail(Orders order, Item item, double unitPrice, int qty, double discount, OrderDetail_pk orderDetail_pk) {
        this.order = order;
        this.item = item;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.discount = discount;
        this.orderDetail_pk = orderDetail_pk;
    }

   

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the order
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the orderDetail_pk
     */
    public OrderDetail_pk getOrderDetail_pk() {
        return orderDetail_pk;
    }

    /**
     * @param orderDetail_pk the orderDetail_pk to set
     */
    public void setOrderDetail_pk(OrderDetail_pk orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order=" + order + ", item=" + item + ", unitPrice=" + unitPrice + ", qty=" + qty + ", discount=" + discount + '}';
    }

    
}
