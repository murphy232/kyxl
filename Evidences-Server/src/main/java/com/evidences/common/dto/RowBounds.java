package com.evidences.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RowBounds {
    private Integer limit;
    private Integer offset;
}
