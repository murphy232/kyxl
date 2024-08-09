package com.evidences.evidence.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EvidenceUpdate {
    @NotNull
    @Positive
    private Integer evidenceId;

    @Positive
    private Integer type;
    private String name;
    private String description;
}
