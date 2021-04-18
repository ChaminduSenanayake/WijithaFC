/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.repository;

import lk.ijse.wijithafc.repository.custom.impl.BatchRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.CategoryRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.GRNRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.ItemRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.LoginRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.OrderRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.impl.SupplierRepositoryImpl;

/**
 *
 * @author ASUS
 */
public class RepositoryFactory {

    public enum repositoryType {
        ITEM, SUPPLIER, BATCH, GRN, ORDER, LOGIN, CATEGORY
    }
    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(repositoryType type) {
        switch (type) {
            case ITEM:
                return new ItemRepositoryImpl();
            case SUPPLIER:
                return new SupplierRepositoryImpl();
            case BATCH:
                return new BatchRepositoryImpl();
            case GRN:
                return new GRNRepositoryImpl();
            case ORDER:
                return new OrderRepositoryImpl();
            case LOGIN:
                return new LoginRepositoryImpl();
            case CATEGORY:
                return new CategoryRepositoryImpl();
            default:
                return null;
        }
    }

}
