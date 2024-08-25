package com.evidences.evidence.controller;

import com.evidences.evidence.dto.EditionCreate;
import com.evidences.evidence.dto.EditionDetail;
import com.evidences.evidence.dto.EditionQuery;
import com.evidences.evidence.dto.EditionUpdate;
import com.evidences.evidence.service.EditionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/api/evidence/edition")
public class EditionController {
    private EditionService editionService;

    @Autowired
    public void setEditionService(EditionService editionService) {
        this.editionService = editionService;
    }

    @RequestMapping("/list")
    public ResponseEntity<?> getEditionList(@RequestBody @Validated EditionQuery editionQuery) {
        return ResponseEntity.ok(editionService.getEditionList(editionQuery));
    }

    @RequestMapping("/detail")
    public ResponseEntity<?> getEditionDetails(@NotNull @Positive Integer editionId) {
        EditionDetail editionDetail = editionService.getEditionDetail(editionId);

        if (editionDetail == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(editionDetail);
        }
    }

    @RequestMapping("/image")
    public ResponseEntity<?> getEditionImage(@NotBlank String filename) {
        byte[] imageBytes = editionService.getEditionImageBytes(filename);

        if (imageBytes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        }
    }

    @RequestMapping("/create")
    public ResponseEntity<?> createEdition(@Validated EditionCreate editionCreate, MultipartFile image) {
        try {
            editionService.createEdition(editionCreate, image.getBytes());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editionCreate.getEditionId());
    }

    @RequestMapping("/update")
    public ResponseEntity<?> updateEdition(@RequestBody @Validated EditionUpdate editionUpdate) {
        if (editionService.updateEdition(editionUpdate)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> deleteEdition(@NotNull @Positive Integer editionId) {
        try {
            editionService.deleteEdition(editionId);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
