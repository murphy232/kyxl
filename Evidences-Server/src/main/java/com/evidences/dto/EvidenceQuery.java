package com.evidences.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class EvidenceQuery {
    @NotNull
    @Valid
    private EvidenceCriteria criteria;

    @NotNull
    @Valid
    private Pagination pagination;
}
