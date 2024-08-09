package com.evidences.evidence.dto;

import com.evidences.common.dto.RowBounds;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EvidenceCriteria {
    @NotNull
    @Positive
    private Integer caseId;
    private Integer type;
    private String keyword;

    @Null
    private RowBounds bounds;
}
