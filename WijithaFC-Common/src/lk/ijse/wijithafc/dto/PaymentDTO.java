/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.dto;

/**
 *
 * @author ASUS
 */
public class PaymentDTO extends SuperDTO{
    private double amount;
    private double totalDiscount;
    private double paidByCus;
    private double change;

    public PaymentDTO()  {
    }

    public PaymentDTO(double amount, double totalDiscount, double paidByCus, double change) {
        this.amount = amount;
        this.totalDiscount = totalDiscount;
        this.paidByCus = paidByCus;
        this.change = change;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
     * @return the change
     */
    public double getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(double change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "amount=" + amount + ", totalDiscount=" + totalDiscount + ", paidByCus=" + paidByCus + ", change=" + change + '}';
    }
    
}
