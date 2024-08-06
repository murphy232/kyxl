package com.evidences.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Evidence {
    private Integer evidenceId;

    private Integer caseId;

    private String name;

    private String description;

    private Integer type;

    private Timestamp createTime;

    private Timestamp updateTime;
}
