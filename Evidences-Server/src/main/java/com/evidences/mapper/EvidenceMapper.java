package com.evidences.mapper;

import com.evidences.dto.EvidenceCriteria;
import com.evidences.dto.EvidenceCreate;
import com.evidences.dto.EvidenceUpdate;
import com.evidences.entity.Evidence;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvidenceMapper {
    List<Evidence> getEvidenceList(EvidenceCriteria evidenceCriteria);

    Evidence getEvidenceDetail(Integer evidenceId);

    Integer getEvidenceCount(EvidenceCriteria evidenceCriteria);

    Integer createEvidence(EvidenceCreate evidenceCreate);

    Integer updateEvidence(EvidenceUpdate evidenceUpdate);

    Integer updateEvidenceUpdateTime(Integer evidenceId);

    Integer deleteEvidence(Integer evidenceId);
}
