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
public class GRNDetailDTO extends SuperDTO{
    private String BatchID;
    private double unitCost;
    private int qty;
   

    public GRNDetailDTO() {
    }

    public GRNDetailDTO(String BatchID, double unitCost, int qty) {
        this.BatchID = BatchID;
        this.unitCost = unitCost;
        this.qty = qty;
    }

    
    /**
     * @return the costPrice
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     * @param costPrice the costPrice to set
     */
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
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
     * @return the BatchID
     */
    public String getBatchID() {
        return BatchID;
    }

    /**
     * @param BatchID the BatchID to set
     */
    public void setBatchID(String BatchID) {
        this.BatchID = BatchID;
    }

    @Override
    public String toString() {
        return "GRNDetailDTO{" + "BatchID=" + BatchID + ", unitCost=" + unitCost + ", qty=" + qty + '}';
    }


    
}
