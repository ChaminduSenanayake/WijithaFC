/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ASUS
 */
@Entity
public class Payment {

    @Id
    private String payID;
    @Column(nullable = true)
    private double amountPaid;
    @Column(nullable = true)
    private double totalDiscount;
    @Column(nullable = true)
    private double paidByCus;
    @Column(nullable = true)
    private double changePaid;

    public Payment() {
    }

    public Payment(String payID, double amountPaid, double totalDiscount, double paidByCus, double changePaid) {
        this.payID = payID;
        this.amountPaid = amountPaid;
        this.totalDiscount = totalDiscount;
        this.paidByCus = paidByCus;
        this.changePaid = changePaid;
    }

    /**
     * @return the payID
     */
    public String getPayID() {
        return payID;
    }

    /**
     * @param payID the payID to set
     */
    public void setPayID(String payID) {
        this.payID = payID;
    }

    /**
     * @return the amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the totalDiscount
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * @param totalDiscount the totalDiscount to set
     */
    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return the paidByCus
     */
    public double getPaidByCus() {
        return paidByCus;
    }

    /**
     * @param paidByCus the paidByCus to set
     */
    public void setPaidByCus(double paidByCus) {
        this.paidByCus = paidByCus;
    }

    /**
     * @return the changePaid
     */
    public double getChangePaid() {
        return changePaid;
    }

    /**
     * @param changePaid the changePaid to set
     */
    public void setChangePaid(double changePaid) {
        this.changePaid = changePaid;
    }

   

}
