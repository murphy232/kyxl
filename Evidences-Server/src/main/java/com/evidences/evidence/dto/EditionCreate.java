package com.evidences.evidence.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EditionCreate {
    @NotNull
    @Positive
    private Integer evidenceId;

    @JsonIgnore
    private Integer editionId;

    @JsonIgnore
    private String filename;
    private String userId;
    private String tag;
    private String description;
}
