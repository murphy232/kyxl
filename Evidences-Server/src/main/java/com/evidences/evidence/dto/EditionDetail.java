package com.evidences.evidence.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class EditionDetail {
    private Integer editionId;
    private Integer evidenceId;
    private String filename;
    private String tag;
    private String description;
    private String userId;
    private String username;
    private String telephone;
    private Timestamp time;
}
