package com.evidences.dto;

import lombok.Data;

@Data
public class PaginationResult {
    private Object results;
    private Integer totalCount;
    private Integer pageCount;
}
