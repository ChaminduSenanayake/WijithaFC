/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.BatchBO;
import lk.ijse.wijithafc.dto.BatchDTO;
import lk.ijse.wijithafc.entity.Batch;
import lk.ijse.wijithafc.entity.Item;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.BatchRepository;
import lk.ijse.wijithafc.repository.custom.ItemRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class BatchBOImpl implements BatchBO {

    private BatchRepository batchRepository;
    private ItemRepository itemRepository;

    public BatchBOImpl() {
        batchRepository = (BatchRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.BATCH);
        itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.ITEM);
    }

    @Override
    public boolean addBatch(BatchDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = itemRepository.findById(dTO.getItemCode());
            Batch batch = new Batch(dTO.getBatchID(), dTO.getQty(), dTO.getCost(), dTO.getExpireDate(), item);
            batchRepository.save(batch);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean updateBatch(BatchDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = itemRepository.findById(dTO.getItemCode());
            Batch batch = new Batch(dTO.getBatchID(), dTO.getQty(), dTO.getCost(), dTO.getExpireDate(), item);
            batchRepository.update(batch);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteBatch(BatchDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            openSession.beginTransaction();
            Item item = itemRepository.findById(dTO.getItemCode());
            Batch batch = new Batch(dTO.getBatchID(), dTO.getQty(), dTO.getCost(), dTO.getExpireDate(), item);
            batchRepository.delete(batch);
            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<BatchDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            openSession.beginTransaction();
            List<Batch> findAll = batchRepository.findAll();
            List<BatchDTO> batchDTOs = new ArrayList<>();
            if (findAll != null) {
                for (Batch batch : findAll) {
                    BatchDTO batchDTO = new BatchDTO(batch.getBatchID(), batch.getItem().getItemCode(), batch.getQty(), batch.getCost(), batch.getExpireDate());
                    batchDTOs.add(batchDTO);
                }
            }
            openSession.getTransaction().commit();
            return batchDTOs;
        }
    }

    @Override
    public BatchDTO SearchBatch(String id) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            openSession.beginTransaction();
            Batch batch = batchRepository.findById(id);
            String itemCode = batch.getItem().getItemCode();
            BatchDTO batchDTO = new BatchDTO(batch.getBatchID(), itemCode, batch.getQty(), batch.getCost(), batch.getExpireDate());
            openSession.getTransaction().commit();
            return batchDTO;
        }
    }

    @Override
    public List<BatchDTO> SearchByItemCode(String itemCode) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            batchRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            List<Batch> batchList = batchRepository.findAll();
            List<BatchDTO> batchDTOs = new ArrayList<>();
            if (batchList != null) {
                for (Batch batch : batchList) {
                    if (itemCode.equals(batch.getItem().getItemCode())) {
                        BatchDTO batchDTO = new BatchDTO(batch.getBatchID(), itemCode, batch.getQty(), batch.getCost(), batch.getExpireDate());
                        batchDTOs.add(batchDTO);
                    }
                }
            }
            openSession.getTransaction().commit();
            return batchDTOs;
        }
    }

}
