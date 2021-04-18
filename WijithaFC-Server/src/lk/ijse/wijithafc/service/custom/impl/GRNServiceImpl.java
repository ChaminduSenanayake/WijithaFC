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
import lk.ijse.wijithafc.business.custom.GRNBO;
import lk.ijse.wijithafc.dto.GRNDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.custom.GRNService;

/**
 *
 * @author ASUS
 */
public class GRNServiceImpl extends UnicastRemoteObject implements GRNService, Subject {

    private GRNBO grnbo;
    private static ReservationImpl<GRNService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();

    public GRNServiceImpl() throws RemoteException {
        grnbo = (GRNBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN);
    }

    @Override
    public boolean addGRN(GRNDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getGRNID(), this, true)) {
            result = grnbo.addGRN(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getGRNID())) {
                release(dTO.getGRNID());
            }
        }
        return result;
    }

    @Override
    public boolean deleteGRN(GRNDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getGRNID(), this, true)) {
            result = grnbo.deleteGRN(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getGRNID())) {
                release(dTO.getGRNID());
            }
        }
        return result;
    }

    @Override
    public List<GRNDTO> getAll() throws Exception {
        return grnbo.getAll();
    }

    @Override
    public GRNDTO SearchGRN(String id) throws Exception {
        return grnbo.SearchGRN(id);
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
                    Logger.getLogger(GRNServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean updateGRN(GRNDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getGRNID(), this, true)) {
            result = grnbo.updateGRN(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getGRNID())) {
                release(dTO.getGRNID());
            }
        }
        return result;
    }
}
