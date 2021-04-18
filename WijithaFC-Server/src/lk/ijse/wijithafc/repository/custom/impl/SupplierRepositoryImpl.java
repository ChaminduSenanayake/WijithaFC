/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.repository.custom.impl;

import java.io.Serializable;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.entity.Supplier;
import lk.ijse.wijithafc.repository.SuperRepository;
import lk.ijse.wijithafc.repository.SuperRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.ItemRepository;
import lk.ijse.wijithafc.repository.custom.SupplierRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author ASUS
 */
public class SupplierRepositoryImpl extends SuperRepositoryImpl<Supplier, String> implements SupplierRepository {

   
    @Override
    public Supplier searchByName(String s,Session session) throws Exception {
        Supplier supplier = (Supplier) session.createCriteria(Supplier.class).add(Restrictions.eq("companyName", s)).list().get(0);
        return supplier;
    }



}
