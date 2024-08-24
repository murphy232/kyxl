package com.evidences.evidence.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EditionUpdate {
    @NotNull
    @Positive
    private Integer editionId;
    private String tag;
    private String description;
}
