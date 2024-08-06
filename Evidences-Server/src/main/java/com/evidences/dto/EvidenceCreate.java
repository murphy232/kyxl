package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Data
public class EvidenceCreate {
    @Null
    private Integer evidenceId;

    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private String name;
    private String description;
}
