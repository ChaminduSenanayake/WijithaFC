/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.CategoryBO;
import lk.ijse.wijithafc.dto.CategoryDTO;
import lk.ijse.wijithafc.entity.ItemCategory;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.CategoryRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class CategoryBOImpl implements CategoryBO {

    private CategoryRepository categoryRepository;

    public CategoryBOImpl() {
        categoryRepository = (CategoryRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.CATEGORY);
    }

    @Override
    public boolean add(CategoryDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            categoryRepository.setSession(openSession);
            openSession.beginTransaction();
            ItemCategory category = new ItemCategory();
            category.setCategory(dTO.getCategory());
            boolean save = categoryRepository.save(category);
            openSession.getTransaction().commit();
            return save;
        }

    }

    @Override
    public boolean update(CategoryDTO dTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(CategoryDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            categoryRepository.setSession(openSession);
            openSession.beginTransaction();
            ItemCategory category = new ItemCategory();
            category.setCatID(dTO.getCatID());
            category.setCategory(dTO.getCategory());
            categoryRepository.delete(category);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<CategoryDTO> getAll() throws Exception {
       try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            categoryRepository.setSession(openSession);
            openSession.beginTransaction();
           List<ItemCategory> findAll = categoryRepository.findAll();
           List<CategoryDTO> dtos=new ArrayList<>();
           if(findAll!=null){
               for (ItemCategory itemCategory : findAll) {
                   CategoryDTO categoryDTO=new CategoryDTO(itemCategory.getCatID(), itemCategory.getCategory());
                   dtos.add(categoryDTO);
               }
               
           }
            openSession.getTransaction().commit();
            return dtos;
        }
    }

    @Override
    public CategoryDTO Search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
