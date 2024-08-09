package com.evidences.evidence.mapper;

import com.evidences.evidence.dto.EvidenceCriteria;
import com.evidences.evidence.dto.EvidenceCreate;
import com.evidences.evidence.dto.EvidenceUpdate;
import com.evidences.evidence.entity.Evidence;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvidenceMapper {
    List<Evidence> getEvidenceList(EvidenceCriteria evidenceCriteria);

    Evidence getEvidenceDetail(Integer evidenceId);

    Integer getEvidenceCount();

    Integer createEvidence(EvidenceCreate evidenceCreate);

    Integer updateEvidence(EvidenceUpdate evidenceUpdate);

    Integer updateEvidenceUpdateTime(Integer evidenceId);

    Integer deleteEvidence(Integer evidenceId);
}
