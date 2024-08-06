package com.evidences.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class Pagination {
    @NotNull
    @Positive
    private Integer pageNum;

    @NotNull
    @Positive
    private Integer pageSize;
}
