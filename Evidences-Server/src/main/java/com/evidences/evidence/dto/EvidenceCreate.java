package com.evidences.evidence.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EvidenceCreate {
    @JsonIgnore
    private Integer evidenceId;

    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private String name;
    private String description;
}
