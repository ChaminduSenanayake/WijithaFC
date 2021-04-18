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
public class BatchDTO extends SuperDTO{
    private String batchID;
    private String itemCode;
    private int qty;
    private double cost;
    private String expireDate;

    public BatchDTO() {
    }

    public BatchDTO(String batchID, String itemCode, int qty, double cost, String expireDate) {
        this.batchID = batchID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.cost = cost;
        this.expireDate = expireDate;
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    @Override
    public String toString() {
        return "BatchDTO{" + "batchID=" + batchID + ", itemCode=" + itemCode + ", qty=" + qty + ", cost=" + cost + ", expireDate=" + expireDate + '}';
    }

   
    
}
