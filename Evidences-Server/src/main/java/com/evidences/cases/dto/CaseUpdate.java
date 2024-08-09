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
    private String name;
    private String description;

    @Positive
    private Integer type;

    @Positive
    private Integer status;
}
