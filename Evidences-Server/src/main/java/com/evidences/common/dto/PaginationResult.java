package com.evidences.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationResult {
    private Object results;
    private Integer totalCount;
    private Integer pageCount;
}
