package com.evidences.dto;

import lombok.Data;
import javax.validation.constraints.Null;

@Data
public class CaseCriteria {
    private String keyword;
    private Integer type;
    private Integer status;

    @Null
    private RowBounds bounds;
}
