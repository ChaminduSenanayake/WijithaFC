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
public class GRNDTO extends SuperDTO{
    private String GRNID;
    private String date;
    private String supplierID;
    private List<GRNDetailDTO> detailList;

    public GRNDTO() {
    }

    public GRNDTO(String GRNID, String date, String supplierID, List<GRNDetailDTO> detailList) {
        this.GRNID = GRNID;
        this.date = date;
        this.supplierID = supplierID;
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
     * @return the supplierID
     */
    public String getSupplierID() {
        return supplierID;
    }

    /**
     * @param supplierID the supplierID to set
     */
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    /**
     * @return the detailList
     */
    public List<GRNDetailDTO> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<GRNDetailDTO> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "GRNDTO{" + "GRNID=" + GRNID + ", date=" + date + ", supplierID=" + supplierID + '}';
    }

   
}
