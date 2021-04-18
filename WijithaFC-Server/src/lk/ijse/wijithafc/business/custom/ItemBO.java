/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.ItemDTO;

/**
 *
 * @author ASUS
 */
public interface ItemBO extends SuperBO{
    public boolean addItem(ItemDTO dTO)throws Exception;
    public boolean updateItem(ItemDTO dTO)throws Exception;
    public boolean deleteItem(ItemDTO dTO)throws Exception;
    public List<ItemDTO> getAll()throws Exception;
    public ItemDTO SearchItem(String id)throws Exception;
}
