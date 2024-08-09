package com.evidences.cases.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Case {
    private Integer caseId;
    private String name;
    private String description;
    private Integer type;
    private Integer status;
    private Timestamp createTime;
    private Timestamp finishTime;
}
