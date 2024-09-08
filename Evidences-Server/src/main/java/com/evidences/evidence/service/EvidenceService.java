package com.evidences.evidence.service;

import com.evidences.common.constant.OperationResult;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.manager.StorageManager;
import com.evidences.common.util.PaginationUtils;
import com.evidences.common.util.TransactionUtils;

import com.evidences.evidence.dto.EvidenceCreate;
import com.evidences.evidence.dto.EvidenceQuery;
import com.evidences.evidence.dto.EvidenceUpdate;
import com.evidences.evidence.dto.EditionCreate;

import com.evidences.evidence.entity.Evidence;
import com.evidences.evidence.mapper.EvidenceMapper;
import com.evidences.evidence.mapper.EditionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvidenceService {
    private StorageManager storageManager;
    private EvidenceMapper evidenceMapper;
    private EditionMapper editionMapper;

    @Autowired
    public void setStorageManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Autowired
    public void setEvidenceMapper(EvidenceMapper evidenceMapper) {
        this.evidenceMapper = evidenceMapper;
    }

    @Autowired
    public void setImageMapper(EditionMapper editionMapper) {
        this.editionMapper = editionMapper;
    }

    @Transactional
    public PaginationResult getEvidenceList(EvidenceQuery evidenceQuery) {
        evidenceQuery.getCriteria().setBounds(PaginationUtils.rowBounds(evidenceQuery.getPagination()));

        return PaginationUtils.execute(evidenceQuery.getPagination()).results(() -> {
            return evidenceMapper.getEvidenceList(evidenceQuery.getCriteria());
        }).count(() -> {
            return evidenceMapper.getEvidenceCount();
        });
    }

    public Evidence getEvidenceDetail(Integer evidenceId) {
        return evidenceMapper.getEvidenceDetail(evidenceId);
    }

    @Transactional
    public void createEvidence(EvidenceCreate evidenceCreate, byte[] contentBytes) {
        EditionCreate editionCreate = new EditionCreate();

        TransactionUtils.executor().execute(() -> {
            return evidenceMapper.createEvidence(evidenceCreate) == OperationResult.CREATE_SUCCESS;
        }).execute(() -> {
            editionCreate.setEvidenceId(evidenceCreate.getEvidenceId());
            editionCreate.setFilename(storageManager.getRandomName());

            return editionMapper.createEdition(editionCreate) == OperationResult.CREATE_SUCCESS;
        }).execute(() -> {
            return storageManager.saveContent(contentBytes, editionCreate.getFilename());
        });
    }

    public boolean updateEvidence(EvidenceUpdate evidenceUpdate) {
        return evidenceMapper.updateEvidence(evidenceUpdate) == OperationResult.UPDATE_SUCCESS;
    }

    @Transactional
    public boolean deleteEvidence(Integer evidenceId) {
        List<String> associatedFilenames = evidenceMapper.getEvidenceAssociatedFilenames(evidenceId);

        if (evidenceMapper.deleteEvidence(evidenceId) != OperationResult.DELETE_SUCCESS) {
            return false;
        } else {
            storageManager.deleteContents(associatedFilenames);
            return true;
        }
    }
}
