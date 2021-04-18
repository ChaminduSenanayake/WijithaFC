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
import lk.ijse.wijithafc.business.custom.BatchBO;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.custom.BatchService;

/**
 *
 * @author ASUS
 */
public class BatchServiceImpl extends UnicastRemoteObject implements BatchService, Subject {

    private BatchBO bO;
    private static ReservationImpl<BatchService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();

    public BatchServiceImpl() throws RemoteException {
        bO = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BATCH);
    }

    @Override
    public boolean addBatch(BatchDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getBatchID(), this, true)) {
            result = bO.addBatch(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getBatchID())) {
                release(dTO.getBatchID());
            }
        }
        return result;
    }

    @Override
    public boolean updateBatch(BatchDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getBatchID(), this, true)) {
            result = bO.updateBatch(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getBatchID())) {
                release(dTO.getBatchID());
            }
        }
        return result;

    }

    @Override
    public boolean deleteBatch(BatchDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getBatchID(), this, true)) {
            result = bO.updateBatch(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getBatchID())) {
                release(dTO.getBatchID());
            }
        }
        return result;
    }

    @Override
    public List<BatchDTO> getAll() throws Exception {
        return bO.getAll();
    }

    @Override
    public BatchDTO SearchBatch(String id) throws Exception {
        return bO.SearchBatch(id);
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
                    Logger.getLogger(BatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public List<BatchDTO> SearchByItemCode(String itemCode) throws Exception {
        return bO.SearchByItemCode(itemCode);
    }

}
