/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business;

import lk.ijse.wijithafc.business.custom.impl.BatchBOImpl;
import lk.ijse.wijithafc.business.custom.impl.CategoryBOImpl;
import lk.ijse.wijithafc.business.custom.impl.GRNBOImpl;
import lk.ijse.wijithafc.business.custom.impl.ItemBOImpl;
import lk.ijse.wijithafc.business.custom.impl.LoginBOImpl;
import lk.ijse.wijithafc.business.custom.impl.OrderBOImpl;
import lk.ijse.wijithafc.business.custom.impl.ReportBOImpl;
import lk.ijse.wijithafc.business.custom.impl.SupplierBOImpl;
import lk.ijse.wijithafc.entity.GRNDetail;

/**
 *
 * @author ASUS
 */
public class BOFactory {

    public enum BOTypes {
        ITEM, SUPPLIER, BATCH, GRN, ORDER, LOGIN, REPORT, CATEGORY
    }

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case ITEM:
                return new ItemBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case BATCH:
                return new BatchBOImpl();
            case GRN:
                return new GRNBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case REPORT:
                return new ReportBOImpl();
            case CATEGORY:
                return new CategoryBOImpl();
            default:
                return null;
        }
    }
}
