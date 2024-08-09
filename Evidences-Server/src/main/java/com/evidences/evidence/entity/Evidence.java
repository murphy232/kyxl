package com.evidences.evidence.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Evidence {
    private Integer evidenceId;
    private Integer caseId;
    private String name;
    private String description;
    private Integer type;
    private Timestamp createTime;
    private Timestamp updateTime;
}
