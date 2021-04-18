/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.repository.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.ijse.wijithafc.entity.Batch;
import lk.ijse.wijithafc.repository.SuperRepositoryImpl;
import lk.ijse.wijithafc.repository.custom.BatchRepository;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ASUS
 */
public class BatchRepositoryImpl extends SuperRepositoryImpl<Batch, String> implements BatchRepository{

    @Override
    public List<Batch> searchByItemCode(String itemCode, Session session) throws Exception {
        //
        return null;
    }
    
}
