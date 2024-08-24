package com.evidences.cases.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaseCreate {
    @JsonIgnore
    private Integer caseId;
    private Integer type;
    private String name;
    private String description;
}
