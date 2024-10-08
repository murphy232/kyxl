package com.evidences.cases.dto;

import com.evidences.common.dto.RowBounds;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class CaseCriteria {
    @JsonIgnore
    private RowBounds bounds;
    private String keyword;
    private Integer type;
    private Integer status;
}
