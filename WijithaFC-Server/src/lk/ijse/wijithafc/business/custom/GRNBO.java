/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.GRNDTO;

/**
 *
 * @author ASUS
 */
public interface GRNBO extends SuperBO{
    public boolean addGRN(GRNDTO dTO) throws Exception;

    public boolean updateGRN(GRNDTO dTO) throws Exception;

    public boolean deleteGRN(GRNDTO dTO) throws Exception;

    public List<GRNDTO> getAll() throws Exception;

    public GRNDTO SearchGRN(String id) throws Exception;
}
