/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.LoginBO;
import lk.ijse.wijithafc.dto.LoginDTO;
import lk.ijse.wijithafc.entity.Login;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.LoginRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class LoginBOImpl implements LoginBO {

    private LoginRepository loginRepository;

    public LoginBOImpl() {
        loginRepository = (LoginRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.LOGIN);
    }

    @Override
    public boolean addLogin(LoginDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            loginRepository.setSession(openSession);
            openSession.beginTransaction();
            Login login = new Login(dTO.getLoginID(), dTO.getLoginType(), dTO.getName(), dTO.getPassword());
            boolean save = loginRepository.save(login);
            openSession.getTransaction().commit();
            return save;
        }
    }

    @Override
    public boolean updateLogin(LoginDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            loginRepository.setSession(openSession);
            openSession.beginTransaction();
            Login login = new Login(dTO.getLoginID(), dTO.getLoginType(), dTO.getName(), dTO.getPassword());
            loginRepository.update(login);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteLogin(LoginDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            loginRepository.setSession(openSession);
            openSession.beginTransaction();
            Login login = new Login(dTO.getLoginID(), dTO.getLoginType(), dTO.getName(), dTO.getPassword());
            loginRepository.delete(login);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<LoginDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            loginRepository.setSession(openSession);
            openSession.beginTransaction();
            List<LoginDTO> loginDTOS = new ArrayList<>();
            List<Login> findAll = loginRepository.findAll();
            if (findAll != null) {
                for (Login login : findAll) {
                    LoginDTO loginDTO = new LoginDTO(login.getLoginID(), login.getLoginType(), login.getName(), login.getPassword());
                    loginDTOS.add(loginDTO);
                }
            }
            openSession.getTransaction().commit();
            return loginDTOS;
        }
    }

    @Override
    public LoginDTO SearchLogin(String id) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            loginRepository.setSession(openSession);
            openSession.beginTransaction();
            Login login = loginRepository.findById(id);
            LoginDTO loginDTO = new LoginDTO(login.getLoginID(), login.getLoginType(), login.getName(), login.getPassword());
            openSession.getTransaction().commit();
            return loginDTO;
        }
    }

}
