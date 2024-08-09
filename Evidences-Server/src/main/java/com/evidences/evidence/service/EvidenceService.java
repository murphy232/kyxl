package com.evidences.evidence.service;

import com.evidences.common.constant.OperationResult;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.helper.PaginationHelper;
import com.evidences.common.helper.TransactionHelper;
import com.evidences.common.manager.StorageManager;

import com.evidences.evidence.dto.EvidenceCreate;
import com.evidences.evidence.dto.EvidenceQuery;
import com.evidences.evidence.dto.EvidenceUpdate;
import com.evidences.evidence.entity.Evidence;
import com.evidences.evidence.mapper.EvidenceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvidenceService {
    private EvidenceMapper evidenceMapper;
    private StorageManager storageManager;

    @Autowired
    public void setEvidenceMapper(EvidenceMapper evidenceMapper) {
        this.evidenceMapper = evidenceMapper;
    }

    @Autowired
    public void setStorageManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Transactional
    public PaginationResult getEvidenceList(EvidenceQuery evidenceQuery) {
        evidenceQuery.getCriteria().setBounds(PaginationHelper.rowBounds(evidenceQuery.getPagination()));

        return PaginationHelper.execute(evidenceQuery.getPagination()).results(() -> {
            return evidenceMapper.getEvidenceList(evidenceQuery.getCriteria());
        }).count(() -> {
            return evidenceMapper.getEvidenceCount();
        });
    }

    public Evidence getEvidenceDetail(Integer evidenceId) {
        return evidenceMapper.getEvidenceDetail(evidenceId);
    }

    public byte[] getEvidenceImage(Integer evidenceId) {
        return storageManager.getImageBytes(evidenceId.toString());
    }

    @Transactional
    public void uploadEvidence(EvidenceCreate evidenceCreate, byte[] imageBytes) {
        TransactionHelper.executor().execute(() -> {
            return evidenceMapper.createEvidence(evidenceCreate) == OperationResult.CREATE_SUCCESS;
        }).execute(() -> {
            return storageManager.saveImage(imageBytes, evidenceCreate.getEvidenceId().toString());
        });
    }

    public boolean updateEvidence(EvidenceUpdate evidenceUpdate) {
        return evidenceMapper.updateEvidence(evidenceUpdate) == OperationResult.UPDATE_SUCCESS;
    }

    @Transactional
    public void editEvidence(Integer evidenceId, byte[] imageBytes) {
        TransactionHelper.executor().execute(() -> {
            return evidenceMapper.updateEvidenceUpdateTime(evidenceId) == OperationResult.UPDATE_SUCCESS;
        }).execute(() -> {
            return storageManager.saveImage(imageBytes, evidenceId.toString());
        });
    }

    @Transactional
    public void deleteEvidence(Integer evidenceId) {
        TransactionHelper.executor().execute(() -> {
            return evidenceMapper.deleteEvidence(evidenceId) == OperationResult.DELETE_SUCCESS;
        }).execute(() -> {
            return storageManager.deleteImage(evidenceId.toString());
        });
    }
}
