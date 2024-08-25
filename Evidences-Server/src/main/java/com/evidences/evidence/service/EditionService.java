package com.evidences.evidence.service;

import com.evidences.common.constant.OperationResult;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.helper.PaginationHelper;
import com.evidences.common.helper.TransactionHelper;
import com.evidences.common.manager.StorageManager;

import com.evidences.evidence.dto.EditionCreate;
import com.evidences.evidence.dto.EditionDetail;
import com.evidences.evidence.dto.EditionQuery;
import com.evidences.evidence.dto.EditionUpdate;
import com.evidences.evidence.mapper.EditionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditionService {
    private EditionMapper editionMapper;
    private StorageManager storageManager;

    @Autowired
    public void setImageMapper(EditionMapper editionMapper) {
        this.editionMapper = editionMapper;
    }

    @Autowired
    public void setStorageManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Transactional
    public PaginationResult getEditionList(EditionQuery editionQuery) {
        editionQuery.getCriteria().setBounds(PaginationHelper.rowBounds(editionQuery.getPagination()));

        return PaginationHelper.execute(editionQuery.getPagination()).results(() -> {
            return editionMapper.getEditionList(editionQuery.getCriteria());
        }).count(() -> {
            return editionMapper.getEditionCount();
        });
    }

    public EditionDetail getEditionDetail(Integer editionId) {
        return editionMapper.getEditionDetail(editionId);
    }

    @Transactional
    public byte[] getEditionImageBytes(String filename) {
        return storageManager.getImageBytes(filename);
    }

    @Transactional
    public void createEdition(EditionCreate editionCreate, byte[] imageBytes) {
        editionCreate.setFilename(storageManager.getRandomName());

        TransactionHelper.executor().execute(() -> {
            return editionMapper.createEdition(editionCreate) == OperationResult.CREATE_SUCCESS;
        }).execute(() -> {
            return storageManager.saveImage(imageBytes, editionCreate.getFilename());
        });
    }

    public boolean updateEdition(EditionUpdate editionUpdate) {
        return editionMapper.updateEdition(editionUpdate) == OperationResult.UPDATE_SUCCESS;
    }

    @Transactional
    public void deleteEdition(Integer editionId) {
        EditionDetail editionDetail = editionMapper.getEditionDetail(editionId);

        TransactionHelper.executor().execute(() -> {
            return editionMapper.deleteEdition(editionId) == OperationResult.DELETE_SUCCESS;
        }).execute(() -> {
            return storageManager.deleteImage(editionDetail.getFilename());
        });
    }
}