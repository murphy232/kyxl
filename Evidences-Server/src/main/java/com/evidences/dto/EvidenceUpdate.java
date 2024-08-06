package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class EvidenceUpdate {
    @NotNull
    @Positive
    private Integer evidenceId;
    private Integer type;
    private String name;
    private String description;
}
