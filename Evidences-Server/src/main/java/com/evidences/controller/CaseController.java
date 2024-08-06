package com.evidences.controller;

import com.evidences.dto.CaseCreate;
import com.evidences.dto.CaseQuery;
import com.evidences.dto.CaseUpdate;
import com.evidences.service.CaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/api/case")
public class CaseController {
    private CaseService caseService;

    @Autowired
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }

    @RequestMapping("/list")
    public ResponseEntity<?> getCaseList(@Validated @RequestBody CaseQuery caseQuery) {
        return ResponseEntity.ok(caseService.getCaseList(caseQuery));
    }

    @RequestMapping("/detail")
    public ResponseEntity<?> getCaseDetail(@NotNull @Positive Integer caseId) {
        return ResponseEntity.ok(caseService.getCaseDetail(caseId));
    }

    @RequestMapping("/create")
    public ResponseEntity<?> createCase(@Validated @RequestBody CaseCreate caseCreate) {
        if (caseService.createCase(caseCreate)) {
            return ResponseEntity.ok(caseCreate.getCaseId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/update")
    public ResponseEntity<?> updateCase(@Validated @RequestBody CaseUpdate caseUpdate) {
        if (caseService.updateCase(caseUpdate)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> deleteCase(@NotNull @Positive Integer caseId) {
        if (caseService.deleteCase(caseId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
