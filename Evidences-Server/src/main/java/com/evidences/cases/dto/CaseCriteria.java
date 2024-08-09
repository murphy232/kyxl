package com.evidences.cases.dto;

import com.evidences.common.dto.RowBounds;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Null;

@Getter
@Setter
public class CaseCriteria {
    private String keyword;
    private Integer type;
    private Integer status;

    @Null
    private RowBounds bounds;
}
