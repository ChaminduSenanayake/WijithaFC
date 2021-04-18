/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS
 */
@Entity
public class Batch {
    @Id
    private String batchID;
    private int qty;
    private double cost;
    private String expireDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    public Batch() {
    }

    public Batch(String batchID, int qty, double cost, String expireDate, Item item) {
        this.batchID = batchID;
        this.qty = qty;
        this.cost = cost;
        this.expireDate = expireDate;
        this.item = item;
    }


    /**
     * @return the batchID
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * @param batchID the batchID to set
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
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
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the expireDate
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
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

    @Override
    public String toString() {
        return "Batch{" + "batchID=" + batchID + ", qty=" + qty + ", cost=" + cost + ", expireDate=" + expireDate + '}';
    }
    
}
