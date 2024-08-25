package com.evidences.cases.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CaseUpdate {
    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private Integer status;
    private String name;
    private String description;
}
