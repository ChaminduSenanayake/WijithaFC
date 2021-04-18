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
import lk.ijse.wijithafc.business.custom.SupplierBO;
import lk.ijse.wijithafc.dto.SupplierDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.custom.SupplierService;

/**
 *
 * @author ASUS
 */
public class SupplierServiceImpl extends UnicastRemoteObject implements SupplierService, Subject {

    private SupplierBO supplierBO;
    private static ReservationImpl<SupplierService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();

    public SupplierServiceImpl() throws RemoteException {
        supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
         boolean result = false;
        if (reservationImpl.reserve(supplier.getSupplierID(), this, true)) {
            result = supplierBO.addSupplier(supplier);
            notifyObservers();
            if (reservationImpl.isInternalReservation(supplier.getSupplierID())) {
                release(supplier.getSupplierID());
            }
        }
        return result;
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(supplier.getSupplierID(), this, true)) {
            result = supplierBO.updateSupplier(supplier);
            notifyObservers();
            if (reservationImpl.isInternalReservation(supplier.getSupplierID())) {
                release(supplier.getSupplierID());
            }
        }
        return result;
    }

    @Override
    public boolean deleteSupplier(SupplierDTO supplier) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(supplier.getSupplierID(), this, true)) {
            result = supplierBO.deleteSupplier(supplier);
            notifyObservers();
            if (reservationImpl.isInternalReservation(supplier.getSupplierID())) {
                release(supplier.getSupplierID());
            }
        }
        return result;
    }

    @Override
    public List<SupplierDTO> getAll() throws Exception {
        return supplierBO.getAll();
    }

    @Override
    public SupplierDTO SearchSupplierByName(String name) throws Exception {
        return supplierBO.SearchSupplierByName(name);
    }

    @Override
    public SupplierDTO SearchSupplier(String id) throws Exception {
        return supplierBO.SearchSupplier(id);
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
                    Logger.getLogger(SupplierService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        boolean reserve = reservationImpl.reserve(id, this, true);
        return  reserve;
    }

    @Override
    public boolean release(Object id) throws Exception {
      return reservationImpl.release(id);
    }

}
