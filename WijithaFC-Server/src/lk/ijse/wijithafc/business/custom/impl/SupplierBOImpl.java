/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.SupplierBO;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.entity.Supplier;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.SupplierRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class SupplierBOImpl implements SupplierBO {

    private SupplierRepository repository;

    public SupplierBOImpl() {
        repository = (SupplierRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            openSession.beginTransaction();
            repository.setSession(openSession);
            Supplier supplier = new Supplier(dTO.getSupplierID(), dTO.getCompanyName(), dTO.getAddress(), dTO.getContactNo());
            boolean save = repository.save(supplier);
            openSession.getTransaction().commit();
            return save;
        }
    }

    @Override
    public boolean updateSupplier(SupplierDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            openSession.beginTransaction();
            repository.setSession(openSession);
            Supplier supplier = new Supplier(dTO.getSupplierID(), dTO.getCompanyName(), dTO.getAddress(), dTO.getContactNo());
            repository.update(supplier);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteSupplier(SupplierDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            openSession.beginTransaction();
            repository.setSession(openSession);
            Supplier supplier = new Supplier(dTO.getSupplierID(), dTO.getCompanyName(), dTO.getAddress(), dTO.getContactNo());
            repository.delete(supplier);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<SupplierDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            repository.setSession(openSession);
            openSession.beginTransaction();
            List<Supplier> findAll = repository.findAll();
            List<SupplierDTO> dTOs = new ArrayList<>();
            if (findAll != null) {
                for (Supplier supplier : findAll) {
                    SupplierDTO supplierDTO = new SupplierDTO(supplier.getSupplierID(), supplier.getCompanyName(), supplier.getAddress(), supplier.getContactNo());
                    dTOs.add(supplierDTO);
                }
            } else {
                return null;

            }

            openSession.getTransaction().commit();
            return dTOs;
        }
    }

    @Override
    public SupplierDTO SearchSupplier(String id) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            repository.setSession(openSession);
            openSession.beginTransaction();
            Supplier supplier = repository.findById(id);
            SupplierDTO supplierDTO = new SupplierDTO(supplier.getSupplierID(), supplier.getCompanyName(), supplier.getAddress(), supplier.getContactNo());
            openSession.getTransaction().commit();
            return supplierDTO;
        }
    }

    @Override
    public SupplierDTO SearchSupplierByName(String name) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            openSession.beginTransaction();
            Supplier supplier = repository.searchByName(name, openSession);
            SupplierDTO supplierDTO = new SupplierDTO(supplier.getSupplierID(), supplier.getCompanyName(), supplier.getAddress(), supplier.getContactNo());
            openSession.getTransaction().commit();
            return supplierDTO;
        }
    }

}
