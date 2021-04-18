/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.BatchDTO;

/**
 *
 * @author ASUS
 */
public interface BatchBO extends SuperBO {

    public boolean addBatch(BatchDTO dTO) throws Exception;

    public boolean updateBatch(BatchDTO dTO) throws Exception;

    public boolean deleteBatch(BatchDTO dTO) throws Exception;

    public List<BatchDTO> getAll() throws Exception;

    public BatchDTO SearchBatch(String id) throws Exception;
    
    public List<BatchDTO> SearchByItemCode(String itemCode) throws Exception;
}
