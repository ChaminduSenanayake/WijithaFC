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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lk.ijse.wijithafc.dto.GRNDetailDTO;

/**
 *
 * @author ASUS
 */
@Entity
public class GRN {

    @Id
    private String GRNID;
    private String date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Supplier supplier;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GRNDetail> detailList;

    public GRN() {
    }

    public GRN(String GRNID, String date, Supplier supplier, List<GRNDetail> detailList) {
        this.GRNID = GRNID;
        this.date = date;
        this.supplier = supplier;
        this.detailList = detailList;
    }

    /**
     * @return the GRNID
     */
    public String getGRNID() {
        return GRNID;
    }

    /**
     * @param GRNID the GRNID to set
     */
    public void setGRNID(String GRNID) {
        this.GRNID = GRNID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the detailList
     */
    public List<GRNDetail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<GRNDetail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "GRN{" + "GRNID=" + getGRNID() + ", date=" + getDate() + '}';
    }

}
