package com.evidences.cases.service;

import com.evidences.cases.dto.CaseCreate;
import com.evidences.cases.dto.CaseQuery;
import com.evidences.cases.dto.CaseUpdate;
import com.evidences.cases.entity.Case;
import com.evidences.cases.mapper.CaseMapper;

import com.evidences.common.constant.OperationResult;
import com.evidences.common.dto.PaginationResult;
import com.evidences.common.helper.PaginationHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaseService {
    private CaseMapper caseMapper;

    @Autowired
    public void setCaseMapper(CaseMapper caseMapper) {
        this.caseMapper = caseMapper;
    }

    @Transactional
    public PaginationResult getCaseList(CaseQuery caseQuery) {
        caseQuery.getCriteria().setBounds(PaginationHelper.rowBounds(caseQuery.getPagination()));

        return PaginationHelper.execute(caseQuery.getPagination()).results(() -> {
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

    public boolean deleteCase(Integer caseId) {
        return caseMapper.deleteCase(caseId) == OperationResult.DELETE_SUCCESS;
    }
}
