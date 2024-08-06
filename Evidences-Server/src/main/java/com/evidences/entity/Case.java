package com.evidences.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Case {
    private Integer caseId;

    private String name;

    private String description;

    private Integer type;

    private Integer status;

    private Timestamp createTime;

    private Timestamp finishTime;
}
