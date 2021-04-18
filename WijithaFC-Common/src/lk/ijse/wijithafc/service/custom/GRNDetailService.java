/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.util.List;
import lk.ijse.wijithafc.dto.GRNDetailDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface GRNDetailService extends SuperService{
     public boolean addGRNDetail(GRNDetailDTO dTO) throws Exception;

    public boolean updateGRNDetail(GRNDetailDTO dTO) throws Exception;

    public boolean deleteGRNDetail(GRNDetailDTO dTO) throws Exception;

    public List<GRNDetailDTO> getAll() throws Exception;

    public GRNDetailDTO SearchGRNDetail(String id) throws Exception;
}
