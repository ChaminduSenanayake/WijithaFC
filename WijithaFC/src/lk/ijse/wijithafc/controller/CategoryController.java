/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.controller;

import java.util.List;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.CategoryDTO;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.CategoryService;

/**
 *
 * @author ASUS
 */
public class CategoryController {

    public static boolean addCat(CategoryDTO dto) throws Exception {
        CategoryService categoryService = (CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGOTY);
        return categoryService.add(dto);
    }

    public static boolean deleteCat(CategoryDTO dto) throws Exception {
        CategoryService categoryService = (CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGOTY);
        return categoryService.delete(dto);
    }

    public static List<CategoryDTO> getAll() throws Exception {
        CategoryService categoryService = (CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGOTY);
        return categoryService.getAll();
    }
}
