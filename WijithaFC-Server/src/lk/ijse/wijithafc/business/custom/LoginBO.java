/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom;

import java.util.List;
import lk.ijse.wijithafc.business.SuperBO;
import lk.ijse.wijithafc.dto.LoginDTO;

/**
 *
 * @author ASUS
 */
public interface LoginBO extends SuperBO {

    public boolean addLogin(LoginDTO dTO) throws Exception;

    public boolean updateLogin(LoginDTO dTO) throws Exception;

    public boolean deleteLogin(LoginDTO dTO) throws Exception;

    public List<LoginDTO> getAll() throws Exception;

    public LoginDTO SearchLogin(String id) throws Exception;
}
