/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithaFC.controller;

import java.util.List;
import lk.ijse.animalclinic.view.Login;
import lk.ijse.wijithaFC.proxy.ProxyHandler;
import lk.ijse.wijithafc.dto.LoginDTO;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.service.ServiceFactory;
import lk.ijse.wijithafc.service.custom.LoginService;

/**
 *
 * @author ASUS
 */
public class ManageLoginController {
     public static boolean addLogin(LoginDTO dTO) throws Exception {
         LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.addLogin(dTO);
    }

    public static boolean updateLogin(LoginDTO dTO) throws Exception {
        LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.updateLogin(dTO);
    }

    public static boolean deleteLogin(LoginDTO dTO) throws Exception {
        LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.deleteLogin(dTO);
    }

    public static List<LoginDTO> getAll() throws Exception {
        LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.getAll();
    }

    public static LoginDTO searchLogin(String id) throws Exception {
          LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.SearchLogin(id);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
    }

    public static boolean reserveLogin(String id) throws Exception {
        LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.reserve(id);
    }

    public static boolean releaseLogin(String id) throws Exception {
        LoginService loginService=(LoginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        return loginService.release(id);
    }
}
