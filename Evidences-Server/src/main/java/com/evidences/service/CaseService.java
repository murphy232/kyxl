package com.evidences.service;

import com.evidences.common.PaginationHelper;
import com.evidences.constant.OperationResult;

import com.evidences.dto.CaseCreate;
import com.evidences.dto.CaseQuery;
import com.evidences.dto.CaseUpdate;
import com.evidences.dto.PaginationResult;

import com.evidences.entity.Case;
import com.evidences.mapper.CaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {
    private CaseMapper caseMapper;

    @Autowired
    public void setCaseMapper(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    public PaginationResult getCaseList(CaseQuery caseQuery) {
        caseQuery.getCriteria().setBounds(PaginationHelper.rowBounds(caseQuery.getPagination()));

        return PaginationHelper.execute(caseQuery.getPagination()).results(() -> {
            return caseMapper.getCaseList(caseQuery.getCriteria());
        }).count(() -> {
            return caseMapper.getCaseCount(caseQuery.getCriteria());
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

    public boolean deleteCase(Integer caseId) {
        return caseMapper.deleteCase(caseId) == OperationResult.DELETE_SUCCESS;
    }
}
