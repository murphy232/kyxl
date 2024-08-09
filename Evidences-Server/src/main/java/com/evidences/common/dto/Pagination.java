package com.evidences.common.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class Pagination {
    @NotNull
    @Positive
    private Integer pageNum;

    @NotNull
    @Positive
    private Integer pageSize;
}
