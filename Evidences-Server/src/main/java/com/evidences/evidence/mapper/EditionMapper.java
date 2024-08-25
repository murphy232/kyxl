package com.evidences.evidence.mapper;

import com.evidences.evidence.dto.EditionCreate;
import com.evidences.evidence.dto.EditionCriteria;
import com.evidences.evidence.dto.EditionDetail;
import com.evidences.evidence.dto.EditionUpdate;
import com.evidences.evidence.entity.EvidenceEdition;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EditionMapper {
    List<EvidenceEdition> getEditionList(EditionCriteria editionCriteria);

    EditionDetail getEditionDetail(Integer editionId);

    Integer getEditionCount();

    Integer createEdition(EditionCreate editionCreate);

    Integer updateEdition(EditionUpdate editionUpdate);

    Integer deleteEdition(Integer editionId);
}
