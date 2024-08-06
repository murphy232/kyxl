package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CaseUpdate {
    @NotNull
    @Positive
    private Integer caseId;
    private String name;
    private String description;
    private Integer type;
    private Integer status;
}
