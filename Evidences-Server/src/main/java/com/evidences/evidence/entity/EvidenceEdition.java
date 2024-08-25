package com.evidences.evidence.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class EvidenceEdition {
    private Integer editionId;
    private Integer evidenceId;
    private String filename;
    private String userId;
    private String tag;
    private String description;
    private Timestamp time;
}
