package com.evidences.evidence.dto;

import com.evidences.common.dto.RowBounds;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class EditionCriteria {
    @JsonIgnore
    private RowBounds bounds;
    private String userId;
    private Integer evidenceId;
}
