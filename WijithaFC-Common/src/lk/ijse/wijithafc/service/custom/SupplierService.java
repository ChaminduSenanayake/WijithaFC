/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.rmi.Remote;
import java.util.List;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.reservation.Reservation;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface SupplierService extends SuperService{

    public boolean addSupplier(SupplierDTO supplier) throws Exception;

    public boolean updateSupplier(SupplierDTO supplier) throws Exception;

    public boolean deleteSupplier(SupplierDTO supplier) throws Exception;

    public List<SupplierDTO> getAll() throws Exception;

    public SupplierDTO SearchSupplierByName(String name) throws Exception;

    public SupplierDTO SearchSupplier(String id) throws Exception;
}
