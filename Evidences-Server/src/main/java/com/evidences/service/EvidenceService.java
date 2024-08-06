package com.evidences.service;

import com.evidences.common.PaginationHelper;
import com.evidences.common.ResourceManager;
import com.evidences.common.TransactionHelper;
import com.evidences.constant.OperationResult;

import com.evidences.dto.EvidenceQuery;
import com.evidences.dto.EvidenceCreate;
import com.evidences.dto.EvidenceUpdate;
import com.evidences.dto.PaginationResult;

import com.evidences.entity.Evidence;
import com.evidences.mapper.EvidenceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvidenceService {
    private EvidenceMapper evidenceMapper;
    private ResourceManager resourceManager;

    @Autowired
    public void setEvidenceMapper(EvidenceMapper evidenceMapper) {
        this.evidenceMapper = evidenceMapper;
    }

    @Autowired
    public void setResourcesManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public PaginationResult getEvidenceList(EvidenceQuery evidenceQuery) {
        evidenceQuery.getCriteria().setBounds(PaginationHelper.rowBounds(evidenceQuery.getPagination()));

        return PaginationHelper.execute(evidenceQuery.getPagination()).results(() -> {
            return evidenceMapper.getEvidenceList(evidenceQuery.getCriteria());
        }).count(() -> {
            return evidenceMapper.getEvidenceCount(evidenceQuery.getCriteria());
        });
    }

    public Evidence getEvidenceDetail(Integer evidenceId) {
        return evidenceMapper.getEvidenceDetail(evidenceId);
    }

    public byte[] getEvidenceImage(Integer evidenceId) {
        return resourceManager.getImageBytes(evidenceId.toString());
    }

    @Transactional
    public void uploadEvidence(EvidenceCreate evidenceCreate, byte[] imageBytes) {
        TransactionHelper.executor().execute(() -> {
            return evidenceMapper.createEvidence(evidenceCreate) == OperationResult.CREATE_SUCCESS;
        }).execute(() -> {
            return resourceManager.saveImage(imageBytes, evidenceCreate.getEvidenceId().toString());
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
            return resourceManager.saveImage(imageBytes, evidenceId.toString());
        });
    }

    @Transactional
    public void deleteEvidence(Integer evidenceId) {
        TransactionHelper.executor().execute(() -> {
            return evidenceMapper.deleteEvidence(evidenceId) == OperationResult.DELETE_SUCCESS;
        }).execute(() -> {
            return resourceManager.deleteImage(evidenceId.toString());
        });
    }
}
