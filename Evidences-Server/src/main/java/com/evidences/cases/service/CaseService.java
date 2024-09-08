package com.evidences.cases.service;

import com.evidences.cases.dto.CaseCreate;
import com.evidences.cases.dto.CaseQuery;
import com.evidences.cases.dto.CaseUpdate;
import com.evidences.cases.entity.Case;
import com.evidences.cases.mapper.CaseMapper;

import com.evidences.common.constant.OperationResult;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.manager.StorageManager;
import com.evidences.common.util.PaginationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaseService {
    private CaseMapper caseMapper;
    private StorageManager storageManager;

    @Autowired
    public void setCaseMapper(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    @Autowired
    public void setStorageManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Transactional
    public PaginationResult getCaseList(CaseQuery caseQuery) {
        caseQuery.getCriteria().setBounds(PaginationUtils.rowBounds(caseQuery.getPagination()));

        return PaginationUtils.execute(caseQuery.getPagination()).results(() -> {
            return caseMapper.getCaseList(caseQuery.getCriteria());
        }).count(() -> {
            return caseMapper.getCaseCount();
        });
    }

    public Case getCaseDetail(Integer caseId) {
        return caseMapper.getCaseDetail(caseId);
    }

    public boolean createCase(CaseCreate caseCreate) {
        return caseMapper.createCase(caseCreate) == OperationResult.CREATE_SUCCESS;
    }

    public boolean updateCase(CaseUpdate caseUpdate) {
        return caseMapper.updateCase(caseUpdate) == OperationResult.UPDATE_SUCCESS;
    }

    @Transactional
    public boolean deleteCase(Integer caseId) {
        List<String> associatedFilenames = caseMapper.getCaseAssociatedFilenames(caseId);

        if (caseMapper.deleteCase(caseId) != OperationResult.DELETE_SUCCESS) {
            return false;
        } else {
            storageManager.deleteContents(associatedFilenames);
            return true;
        }
    }
}
