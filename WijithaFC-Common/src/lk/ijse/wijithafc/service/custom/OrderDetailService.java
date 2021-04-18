/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.util.List;
import lk.ijse.wijithafc.dto.OrderDetailDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface OrderDetailService extends SuperService{
    public boolean addOrderDetail(OrderDetailDTO dTO) throws Exception;

    public boolean updateOrderDetail(OrderDetailDTO dTO) throws Exception;

    public boolean deleteOrderDetail(OrderDetailDTO dTO) throws Exception;

    public List<OrderDetailDTO> getAll() throws Exception;
}
