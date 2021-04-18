/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ASUS
 */
@Embeddable
public class GRNDetail_pk implements Serializable{
    private String GRNID;
    private String batchID;

    public GRNDetail_pk() {
    }

    public GRNDetail_pk(String GRNID, String batchID) {
        this.GRNID = GRNID;
        this.batchID = batchID;
    }

    
}
