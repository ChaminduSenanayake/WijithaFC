/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.wijithafc.business.BOFactory;
import lk.ijse.wijithafc.business.custom.LoginBO;
import lk.ijse.wijithafc.dto.LoginDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.custom.LoginService;

/**
 *
 * @author ASUS
 */
public class LoginServiceImpl extends UnicastRemoteObject implements LoginService, Subject {

    private static ReservationImpl<LoginService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();
    private LoginBO loginBO;

    public LoginServiceImpl() throws RemoteException {
        loginBO = (LoginBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);
    }

    @Override
    public boolean addLogin(LoginDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getLoginID(), this, true)) {
            result = loginBO.addLogin(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getLoginID())) {
                release(dTO.getLoginID());
            }
        }
        return result;
    }

    @Override
    public boolean updateLogin(LoginDTO dTO) throws Exception {
       boolean result = false;
        if (reservationImpl.reserve(dTO.getLoginID(), this, true)) {
            result = loginBO.updateLogin(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getLoginID())) {
                release(dTO.getLoginID());
            }
        }
        return result;
    }

    @Override
    public boolean deleteLogin(LoginDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getLoginID(), this, true)) {
            result = loginBO.deleteLogin(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getLoginID())) {
                release(dTO.getLoginID());
            }
        }
        return result;
    }

    @Override
    public List<LoginDTO> getAll() throws Exception {
        return loginBO.getAll();
    }

    @Override
    public LoginDTO SearchLogin(String id) throws Exception {
        return loginBO.SearchLogin(id);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return reservationImpl.reserve(id, this, true);
        
    }

    @Override
    public boolean release(Object id) throws Exception {
       return reservationImpl.release(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : observers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

}
