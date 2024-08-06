package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class CaseCreate {
    @Null
    private Integer caseId;

    @NotBlank
    private String name;
    private String description;
    private Integer type;
}
