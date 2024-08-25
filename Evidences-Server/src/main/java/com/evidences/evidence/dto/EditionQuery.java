package com.evidences.evidence.dto;

import com.evidences.common.dto.Pagination;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EditionQuery {
    @NotNull
    @Valid
    private EditionCriteria criteria;

    @NotNull
    @Valid
    private Pagination pagination;
}
