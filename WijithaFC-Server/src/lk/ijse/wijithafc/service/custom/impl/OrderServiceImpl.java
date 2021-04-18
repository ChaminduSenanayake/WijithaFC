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
import lk.ijse.wijithafc.business.custom.OrderBO;
import lk.ijse.wijithafc.dto.OrderDTO;
import lk.ijse.wijithafc.observer.Observer;
import lk.ijse.wijithafc.observer.Subject;
import lk.ijse.wijithafc.reservation.impl.ReservationImpl;
import lk.ijse.wijithafc.service.custom.OrderService;

/**
 *
 * @author ASUS
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService, Subject {

    private static ReservationImpl<OrderService> reservationImpl = new ReservationImpl<>();
    private static ArrayList<Observer> observers = new ArrayList<>();
    private OrderBO orderBO;

    public OrderServiceImpl() throws RemoteException {
        orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    }

    @Override
    public boolean addOrder(OrderDTO dTO) throws Exception {
       boolean result = false;
        if (reservationImpl.reserve(dTO.getOrderID(), this, true)) {
            
            result = orderBO.addOrder(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getOrderID())) {
                release(dTO.getOrderID());
            }
        }
        return result;
    }

    @Override
    public boolean updateOrder(OrderDTO dTO) throws Exception {
       boolean result = false;
        if (reservationImpl.reserve(dTO.getOrderID(), this, true)) {
            result = orderBO.updateOrder(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getOrderID())) {
                release(dTO.getOrderID());
            }
        }
        return result;
    }

    @Override
    public boolean deleteOrder(OrderDTO dTO) throws Exception {
       boolean result = false;
        if (reservationImpl.reserve(dTO.getOrderID(), this, true)) {
            result = orderBO.deleteOrder(dTO);
            notifyObservers();
            if (reservationImpl.isInternalReservation(dTO.getOrderID())) {
                release(dTO.getOrderID());
            }
        }
        return result;
    }

    @Override
    public List<OrderDTO> getAll() throws Exception {
        return orderBO.getAll();
    }

    @Override
    public OrderDTO SearchOrder(String id) throws Exception {
        return orderBO.SearchOrder(id);
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
        new Thread(() ->{
        for (Observer observer : observers) {
            try {
                observer.updateObservers();
            } catch (Exception ex) {
                Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }).start();
    }

}
