/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 *
 * @author ASUS
 */
@Embeddable
public class OrderDetail_pk implements Serializable{
    private String orderID;
    private String itemCode;

    public OrderDetail_pk() {
    }

    public OrderDetail_pk(String orderID, String itemCode) {
        this.orderID = orderID;
        this.itemCode = itemCode;
    }
    
}
