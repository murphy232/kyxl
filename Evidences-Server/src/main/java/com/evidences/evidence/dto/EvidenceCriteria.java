package com.evidences.evidence.dto;

import com.evidences.common.dto.RowBounds;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EvidenceCriteria {
    @JsonIgnore
    private RowBounds bounds;

    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private String keyword;
}
