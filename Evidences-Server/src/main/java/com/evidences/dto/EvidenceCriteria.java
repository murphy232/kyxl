package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Data
public class EvidenceCriteria {
    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private String keyword;

    @Null
    private RowBounds bounds;
}
