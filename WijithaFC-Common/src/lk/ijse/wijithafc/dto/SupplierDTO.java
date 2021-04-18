/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.dto;

import com.sun.xml.internal.ws.api.message.SuppressAutomaticWSARequestHeadersFeature;

/**
 *
 * @author ASUS
 */
public class SupplierDTO extends SuperDTO{
    private String supplierID;
    private String companyName;
    private String address;
    private String contactNo;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierID, String companyName, String address, String contactNo) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.address = address;
        this.contactNo = contactNo;
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
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" + "supplierID=" + supplierID + ", companyName=" + companyName + ", address=" + address + ", contactNo=" + contactNo + '}';
    }
    
}
