package com.evidences.cases.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CaseCreate {
    @Null
    private Integer caseId;

    @Positive
    private Integer type;

    @NotBlank
    private String name;
    private String description;
}
