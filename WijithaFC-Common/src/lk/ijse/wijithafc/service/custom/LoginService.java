/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom;

import java.util.List;
import lk.ijse.wijithafc.dto.LoginDTO;
import lk.ijse.wijithafc.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface LoginService extends SuperService{
    
    public boolean addLogin(LoginDTO dTO) throws Exception;

    public boolean updateLogin(LoginDTO dTO) throws Exception;

    public boolean deleteLogin(LoginDTO dTO) throws Exception;

    public List<LoginDTO> getAll() throws Exception;

    public LoginDTO SearchLogin(String id) throws Exception;
}
