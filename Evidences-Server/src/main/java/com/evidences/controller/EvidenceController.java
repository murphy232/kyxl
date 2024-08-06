package com.evidences.controller;

import com.evidences.dto.EvidenceQuery;
import com.evidences.dto.EvidenceCreate;
import com.evidences.dto.EvidenceUpdate;
import com.evidences.service.EvidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        return ResponseEntity.ok(evidenceService.getEvidenceDetail(evidenceId));
    }

    @RequestMapping("/image")
    public ResponseEntity<?> getEvidenceImage(@NotNull @Positive Integer evidenceId) {
        byte[] imageBytes = evidenceService.getEvidenceImage(evidenceId);

        if (imageBytes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        }
    }

    @RequestMapping("/upload")
    public ResponseEntity<?> uploadEvidence(@Validated EvidenceCreate evidenceCreate, MultipartFile image) {
        try {
            evidenceService.uploadEvidence(evidenceCreate, image.getBytes());
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

    @RequestMapping("/edit")
    public ResponseEntity<?> editEvidence(@NotNull @Positive Integer evidenceId, MultipartFile image) {
        try {
            evidenceService.editEvidence(evidenceId, image.getBytes());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> deleteEvidence(@NotNull @Positive Integer evidenceId) {
        try {
            evidenceService.deleteEvidence(evidenceId);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
