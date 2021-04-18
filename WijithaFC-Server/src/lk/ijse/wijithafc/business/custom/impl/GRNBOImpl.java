/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.wijithafc.business.custom.GRNBO;
import lk.ijse.wijithafc.dto.GRNDTO;
import lk.ijse.wijithafc.dto.GRNDetailDTO;
import lk.ijse.wijithafc.entity.Batch;
import lk.ijse.wijithafc.entity.GRN;
import lk.ijse.wijithafc.entity.GRNDetail;
import lk.ijse.wijithafc.entity.GRNDetail_pk;
import lk.ijse.wijithafc.entity.Item;
import lk.ijse.wijithafc.entity.Supplier;
import lk.ijse.wijithafc.repository.RepositoryFactory;
import lk.ijse.wijithafc.repository.custom.BatchRepository;
import lk.ijse.wijithafc.repository.custom.GRNRepository;
import lk.ijse.wijithafc.repository.custom.ItemRepository;
import lk.ijse.wijithafc.repository.custom.SupplierRepository;
import lk.ijse.wijithafc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class GRNBOImpl implements GRNBO {

    private GRNRepository grnRepository;
    private BatchRepository batchRepository;
    private SupplierRepository supplierRepository;
    private ItemRepository itemRepository;

    public GRNBOImpl() {
        grnRepository = (GRNRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.GRN);
        batchRepository = (BatchRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.BATCH);
        supplierRepository = (SupplierRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.SUPPLIER);
        itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.repositoryType.ITEM);
    }

    @Override
    public boolean addGRN(GRNDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            grnRepository.setSession(openSession);
            batchRepository.setSession(openSession);
            supplierRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Supplier supplier = supplierRepository.findById(dTO.getSupplierID());
            GRN grn = new GRN();
            grn.setGRNID(dTO.getGRNID());
            grn.setDate(dTO.getDate());
            grn.setSupplier(supplier);

            List<GRNDetail> list = new ArrayList<>();
            for (GRNDetailDTO detailDTO : dTO.getDetailList()) {
                GRNDetail_pk detail_pk = new GRNDetail_pk(dTO.getGRNID(), detailDTO.getBatchID());
                Batch batch = batchRepository.findById(detailDTO.getBatchID());

                Item item = batch.getItem();
                int newQty = detailDTO.getQty() + item.getQtyOnHand();
                item.setQtyOnHand(newQty);
                itemRepository.update(item);

                batch.setQty(detailDTO.getQty() + batch.getQty());
                batchRepository.update(batch);
                GRNDetail detail = new GRNDetail(detailDTO.getUnitCost(), detailDTO.getQty(), grn, batch, detail_pk);
                list.add(detail);
            }
            grn.setDetailList(list);
            boolean save = grnRepository.save(grn);

            openSession.getTransaction().commit();
            return save;
        }
    }

    @Override
    public boolean updateGRN(GRNDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            grnRepository.setSession(openSession);
            grnRepository.setSession(openSession);
            batchRepository.setSession(openSession);
            supplierRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            Supplier supplier = supplierRepository.findById(dTO.getSupplierID());

            GRN grn = new GRN();
            grn.setGRNID(dTO.getGRNID());
            grn.setDate(dTO.getDate());
            grn.setSupplier(supplier);

            List<GRNDetail> list = new ArrayList<>();
            for (GRNDetailDTO detailDTO : dTO.getDetailList()) {
                GRNDetail_pk detail_pk = new GRNDetail_pk(dTO.getGRNID(), detailDTO.getBatchID());
                Batch batch = batchRepository.findById(detailDTO.getBatchID());
                Item item = batch.getItem();
                int newQty = detailDTO.getQty() + item.getQtyOnHand();
                item.setQtyOnHand(newQty);
                itemRepository.update(item);

                batch.setQty(detailDTO.getQty() + batch.getQty());
                batchRepository.update(batch);
                GRNDetail detail = new GRNDetail(detailDTO.getUnitCost(), detailDTO.getQty(), grn, batch, detail_pk);
                list.add(detail);
            }
            grn.setDetailList(list);

            grnRepository.update(grn);
            openSession.getTransaction().commit();
            return true;

        }
    }

    @Override
    public boolean deleteGRN(GRNDTO dTO) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            grnRepository.setSession(openSession);
            batchRepository.setSession(openSession);
            itemRepository.setSession(openSession);
            openSession.beginTransaction();
            GRN grn = grnRepository.findById(dTO.getGRNID());
            for (GRNDetail gRNDetail : grn.getDetailList()) {
                Batch batch = gRNDetail.getBatch();
                batch.setQty(batch.getQty() - gRNDetail.getQty());
                Item item = gRNDetail.getBatch().getItem();
                item.setQtyOnHand(item.getQtyOnHand() - gRNDetail.getQty());

                itemRepository.update(item);
                batchRepository.update(batch);
            }
            grnRepository.delete(grn);

            openSession.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<GRNDTO> getAll() throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            grnRepository.setSession(openSession);
            openSession.beginTransaction();
            List<GRN> findAll = grnRepository.findAll();
            List<GRNDTO> dtos = new ArrayList<>();
            if (findAll != null) {
                for (GRN grn : findAll) {
                    List<GRNDetailDTO> detailDTOs = new ArrayList<>();
                    for (GRNDetail dto : grn.getDetailList()) {
                        GRNDetailDTO detailDTO = new GRNDetailDTO(dto.getBatch().getBatchID(), dto.getUnitCost(), dto.getQty());
                        detailDTOs.add(detailDTO);
                    }
                    GRNDTO grndto = new GRNDTO(grn.getGRNID(), grn.getDate(), grn.getSupplier().getSupplierID(), detailDTOs);
                    dtos.add(grndto);
                }
            }
            openSession.getTransaction().commit();
            return dtos;
        }
    }

    @Override
    public GRNDTO SearchGRN(String id) throws Exception {
        try (Session openSession = HibernateUtil.getSessionFactory().openSession();) {
            grnRepository.setSession(openSession);
            openSession.beginTransaction();
            GRN grn = grnRepository.findById(id);
            List<GRNDetailDTO> detailDTOs = new ArrayList<>();
            for (GRNDetail gRNDetail : grn.getDetailList()) {
                GRNDetailDTO detailDTO = new GRNDetailDTO(gRNDetail.getBatch().getBatchID(), gRNDetail.getUnitCost(), gRNDetail.getQty());
                detailDTOs.add(detailDTO);
            }
            GRNDTO grndto = new GRNDTO(grn.getGRNID(), grn.getDate(), grn.getSupplier().getSupplierID(), detailDTOs);
            openSession.getTransaction().commit();
            return grndto;
        }
    }

}
