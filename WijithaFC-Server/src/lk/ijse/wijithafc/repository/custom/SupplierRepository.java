/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.repository.custom;

import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.entity.Supplier;
import lk.ijse.wijithafc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public interface SupplierRepository extends SuperRepository<Supplier, String> {

    public Supplier searchByName(String s,Session session) throws Exception;
}
