package com.evidences.evidence.controller;

import com.evidences.evidence.dto.EvidenceQuery;
import com.evidences.evidence.dto.EvidenceCreate;
import com.evidences.evidence.dto.EvidenceUpdate;
import com.evidences.evidence.entity.Evidence;
import com.evidences.evidence.service.EvidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/api/evidence")
public class EvidenceController {
    private EvidenceService evidenceService;

    @Autowired
    public void setEvidenceService(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @RequestMapping("/list")
    public ResponseEntity<?> getEvidenceList(@Validated @RequestBody EvidenceQuery evidenceQuery) {
        return ResponseEntity.ok(evidenceService.getEvidenceList(evidenceQuery));
    }

    @RequestMapping("/detail")
    public ResponseEntity<?> getEvidenceDetail(@NotNull @Positive Integer evidenceId) {
        Evidence evidenceDetail = evidenceService.getEvidenceDetail(evidenceId);

        if (evidenceDetail == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(evidenceDetail);
        }
    }

    @RequestMapping("/create")
    public ResponseEntity<?> createEvidence(@Validated EvidenceCreate evidenceCreate, MultipartFile image) {
        try {
            evidenceService.createEvidence(evidenceCreate, image.getBytes());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(evidenceCreate.getEvidenceId());
    }

    @RequestMapping("/update")
    public ResponseEntity<?> updateEvidence(@Validated @RequestBody EvidenceUpdate evidenceUpdate) {
        if (evidenceService.updateEvidence(evidenceUpdate)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> deleteEvidence(@NotNull @Positive Integer evidenceId) {
        if (evidenceService.deleteEvidence(evidenceId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
