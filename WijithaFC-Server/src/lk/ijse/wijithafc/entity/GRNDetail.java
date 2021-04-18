/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ASUS
 */
@Entity
public class GRNDetail {
    private double unitCost;
    private int qty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "GRNID",referencedColumnName = "GRNID",insertable = false,updatable = false))
    private GRN grn;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumns(@JoinColumn(name = "batchID",referencedColumnName = "batchID",insertable = false,updatable = false))
    private Batch batch;
    @EmbeddedId
    private GRNDetail_pk detail_pk;

    public GRNDetail() {
    }

    public GRNDetail(double unitCost, int qty, GRN grn, Batch batch, GRNDetail_pk detail_pk) {
        this.unitCost = unitCost;
        this.qty = qty;
        this.grn = grn;
        this.batch = batch;
        this.detail_pk = detail_pk;
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
     * @return the grn
     */
    public GRN getGrn() {
        return grn;
    }

    /**
     * @param grn the grn to set
     */
    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    /**
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    /**
     * @return the detail_pk
     */
    public GRNDetail_pk getDetail_pk() {
        return detail_pk;
    }

    /**
     * @param detail_pk the detail_pk to set
     */
    public void setDetail_pk(GRNDetail_pk detail_pk) {
        this.detail_pk = detail_pk;
    }

    @Override
    public String toString() {
        return "GRNDetail{" + "UnitCost=" + unitCost + ", qty=" + qty + '}';
    }

    
    
    
}
