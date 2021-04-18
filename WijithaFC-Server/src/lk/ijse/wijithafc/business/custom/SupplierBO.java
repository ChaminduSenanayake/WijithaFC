/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.SupplierDTO;

/**
 *
 * @author ASUS
 */
public interface SupplierBO extends SuperBO {

    public boolean addSupplier(SupplierDTO dTO) throws Exception;

    public boolean updateSupplier(SupplierDTO dTO) throws Exception;

    public boolean deleteSupplier(SupplierDTO dTO) throws Exception;

    public List<SupplierDTO> getAll() throws Exception;

    public SupplierDTO SearchSupplier(String id) throws Exception;

    public SupplierDTO SearchSupplierByName(String name) throws Exception;
}
