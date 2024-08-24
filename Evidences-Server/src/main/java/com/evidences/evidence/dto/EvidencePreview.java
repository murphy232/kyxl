package com.evidences.evidence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvidencePreview {
    private Integer evidenceId;
    private Integer type;
    private String name;
    private String preview;
}
