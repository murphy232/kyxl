package com.evidences.evidence.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EvidenceCreate {
    @Null
    private Integer evidenceId;

    @NotNull
    @Positive
    private Integer caseId;

    @Positive
    private Integer type;
    private String name;
    private String description;
}
