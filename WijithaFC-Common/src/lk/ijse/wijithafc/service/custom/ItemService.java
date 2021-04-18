/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.util.List;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface ItemService extends SuperService{
    
    public boolean addItem(ItemDTO item) throws Exception;

    public boolean updateItem(ItemDTO dTO) throws Exception;

    public boolean deleteItem(ItemDTO dTO) throws Exception;

    public List<ItemDTO> getAll() throws Exception;

    public ItemDTO SearchItem(String id) throws Exception;
}
