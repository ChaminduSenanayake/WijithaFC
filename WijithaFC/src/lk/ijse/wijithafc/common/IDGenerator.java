/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.common;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import lk.ijse.wijithaFC.controller.ManageItemsController;
import lk.ijse.wijithaFC.controller.ManageSupplierController;
import static lk.ijse.wijithafc.common.IDGenerator.IdType.GRN;
import static lk.ijse.wijithafc.common.IDGenerator.IdType.ITEM;
import static lk.ijse.wijithafc.common.IDGenerator.IdType.ORDER;
import static lk.ijse.wijithafc.common.IDGenerator.IdType.SUPPLIER;
import lk.ijse.wijithafc.controller.ManageBatchController;
import lk.ijse.wijithafc.controller.ManageGRNController;
import lk.ijse.wijithafc.controller.manageOrderController;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.dto.GRNDTO;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.dto.OrderDTO;

import lk.ijse.wijithafc.dto.SuperDTO;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author chamindu
 */
public class IDGenerator {

    public static enum IdType {
        ITEM,SUPPLIER,GRN,ORDER
    }

    public static String getLastID(IdType type) throws Exception {
        if (type == ITEM) {
            List<ItemDTO> list = ManageItemsController.getAll();
            if (list != null) {
                int maxID=0;
                for (ItemDTO dto : list) {
                   int dtoID=Integer.parseInt(dto.getItemCode().split("I")[1]);
                   if(dtoID>maxID){ maxID=dtoID;}
                }
                maxID++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(3);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(maxID);
                return "I" + newID;
            }else{
                return "I"+"001";
            }
        }
        
        if (type == SUPPLIER) {
            List<SupplierDTO> list = ManageSupplierController.getAll();
            if (list != null) {
                int maxID=0;
                for (SupplierDTO dto : list) {
                   int dtoID=Integer.parseInt(dto.getSupplierID().split("S")[1]);
                   if(dtoID>maxID){ maxID=dtoID;}
                }
                maxID++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(3);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(maxID);
                return "S" + newID;
            }else{
                return "S"+"001";
            }
        }
        
        
        
        if (type ==GRN) {
            List<GRNDTO> all = ManageGRNController.getAll();
            if (all != null) {
                int maxID=0;
                for (GRNDTO dto : all) {
                   int dtoID=Integer.parseInt(dto.getGRNID().split("G")[1]);
                   if(dtoID>maxID){ maxID=dtoID;}
                }
                maxID++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(3);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(maxID);
                return "G" + newID;
            }else{
                return "G"+"001";
            }
        }
        if (type ==ORDER) {
            List<OrderDTO> all = manageOrderController.getAll();
            if (all != null) {
                int maxID=0;
                for (OrderDTO dto : all) {
                   int dtoID=Integer.parseInt(dto.getOrderID().split("O")[1]);
                   if(dtoID>maxID){ maxID=dtoID;}
                }
                maxID++;
                NumberFormat numberFormat = NumberFormat.getIntegerInstance();
                numberFormat.setMinimumIntegerDigits(3);
                numberFormat.setGroupingUsed(false);
                String newID = numberFormat.format(maxID);
                return "O" + newID;
            }else{
                return "O"+"001";
            }
        }
        
        return null;
    }

}
