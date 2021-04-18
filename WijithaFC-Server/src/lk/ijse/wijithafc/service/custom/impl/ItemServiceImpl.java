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
import lk.ijse.wijithafc.business.custom.ItemBO;
import lk.ijse.wijithafc.dto.ItemDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.SuperService;
import lk.ijse.wijithafc.service.custom.ItemService;

/**
 *
 * @author ASUS
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService, Subject {

    private ItemBO itemBO;
    private static ReservationImpl<ItemService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();

    public ItemServiceImpl() throws RemoteException {
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getItemCode(), this, true)) {
            result = itemBO.addItem(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getItemCode())) {
                release(dTO.getItemCode());
            }
        }
        return result;
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
    public boolean updateItem(ItemDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getItemCode(), this, true)) {
            result = itemBO.updateItem(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getItemCode())) {
                release(dTO.getItemCode());
            }
        }
        return result;
    }

    @Override
    public boolean deleteItem(ItemDTO dTO) throws Exception {
        boolean result = false;
        if (reservationImpl.reserve(dTO.getItemCode(), this, true)) {
            result = itemBO.deleteItem(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getItemCode())) {
                release(dTO.getItemCode());
            }
        }
        return result;

    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        return itemBO.getAll();
    }

    @Override
    public ItemDTO SearchItem(String id) throws Exception {
        return itemBO.SearchItem(id);
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
                    Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
