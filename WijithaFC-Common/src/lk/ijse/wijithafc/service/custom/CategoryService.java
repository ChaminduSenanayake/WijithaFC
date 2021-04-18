/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.util.List;
import lk.ijse.wijithafc.dto.CategoryDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface CategoryService extends SuperService{
    public boolean add(CategoryDTO dTO) throws Exception;

    public boolean update(CategoryDTO dTO) throws Exception;

    public boolean delete(CategoryDTO dTO) throws Exception;

    public List<CategoryDTO> getAll() throws Exception;

    public CategoryDTO Search(String id) throws Exception;
}
