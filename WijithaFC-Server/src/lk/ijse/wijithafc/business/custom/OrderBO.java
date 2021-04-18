/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.OrderDTO;
import lk.ijse.wijithafc.entity.Orders;

/**
 *
 * @author ASUS
 */
public interface OrderBO extends SuperBO{
    public boolean addOrder(OrderDTO dTO) throws Exception;

    public boolean updateOrder(OrderDTO dTO) throws Exception;

    public boolean deleteOrder(OrderDTO dTO) throws Exception;

    public List<OrderDTO> getAll() throws Exception;

    public OrderDTO SearchOrder(String id) throws Exception;
}
