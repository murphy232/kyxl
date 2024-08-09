package com.evidences.cases.dto;

import com.evidences.common.dto.Pagination;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CaseQuery {
    @NotNull
    @Valid
    private CaseCriteria criteria;

    @NotNull
    @Valid
    private Pagination pagination;
}
