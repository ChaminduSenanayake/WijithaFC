/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.repository.custom;

import java.util.List;
import lk.ijse.wijithafc.entity.Batch;
import lk.ijse.wijithafc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public interface BatchRepository extends SuperRepository<Batch, String>{
    public List<Batch> searchByItemCode(String itemCode,Session session) throws Exception;
}
