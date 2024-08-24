package com.evidences.cases.mapper;

import com.evidences.cases.dto.CaseCreate;
import com.evidences.cases.dto.CaseCriteria;
import com.evidences.cases.dto.CaseUpdate;
import com.evidences.cases.entity.Case;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaseMapper {
    List<Case> getCaseList(CaseCriteria caseCriteria);

    Case getCaseDetail(Integer caseId);

    List<String> getCaseAssociatedFilenames(Integer caseId);

    Integer getCaseCount();

    Integer createCase(CaseCreate caseCreate);

    Integer updateCase(CaseUpdate caseUpdate);

    Integer deleteCase(Integer caseId);
}
