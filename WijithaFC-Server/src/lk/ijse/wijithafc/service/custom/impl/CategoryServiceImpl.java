/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lk.ijse.wijithafc.business.BOFactory;
import lk.ijse.wijithafc.business.custom.CategoryBO;
import lk.ijse.wijithafc.dto.CategoryDTO;
import lk.ijse.wijithafc.service.custom.CategoryService;

/**
 *
 * @author ASUS
 */
public class CategoryServiceImpl extends  UnicastRemoteObject implements CategoryService{
    private CategoryBO bO;

   public CategoryServiceImpl()throws RemoteException{
       bO=(CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);
   }
           
    @Override
    public boolean add(CategoryDTO dTO) throws Exception {
        return bO.add(dTO);
    }

    @Override
    public boolean update(CategoryDTO dTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(CategoryDTO dTO) throws Exception {
        return bO.delete(dTO);
    }

    @Override
    public List<CategoryDTO> getAll() throws Exception {
        return bO.getAll();
    }

    @Override
    public CategoryDTO Search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
