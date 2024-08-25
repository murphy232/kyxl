package com.evidences.evidence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evidence {
    private Integer evidenceId;
    private Integer caseId;
    private Integer type;
    private String name;
    private String description;
}
