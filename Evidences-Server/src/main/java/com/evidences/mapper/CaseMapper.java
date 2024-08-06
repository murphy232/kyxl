package com.evidences.mapper;

import com.evidences.dto.CaseCreate;
import com.evidences.dto.CaseCriteria;
import com.evidences.dto.CaseUpdate;
import com.evidences.entity.Case;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaseMapper {
    List<Case> getCaseList(CaseCriteria caseCriteria);

    Case getCaseDetail(Integer caseId);

    Integer getCaseCount(CaseCriteria caseCriteria);

    Integer createCase(CaseCreate caseCreate);

    Integer updateCase(CaseUpdate caseUpdate);

    Integer deleteCase(Integer caseId);
}
