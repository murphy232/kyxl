package com.evidences.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class CaseQuery {
    @NotNull
    @Valid
    private CaseCriteria criteria;

    @NotNull
    @Valid
    private Pagination pagination;
}
