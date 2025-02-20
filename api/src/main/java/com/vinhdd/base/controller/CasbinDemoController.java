package com.vinhdd.base.controller;

import com.vinhdd.base.dto.TestDtoIn;
import com.vinhdd.base.dto.in.AddFolderDto;
import com.vinhdd.base.dto.in.EvaluationDto;
import com.vinhdd.base.service.CasbinDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CasbinDemoController {
    private final CasbinDemoService casbinDemoService;

    @PostMapping("/evaluation")
    public ResponseEntity<Boolean> evaluation(@RequestBody EvaluationDto dto) {
        return ResponseEntity.ok(casbinDemoService.evaluation(dto.getSub(), dto.getObj(), dto.getAct()));
    }

    @PostMapping("/policy")
    public ResponseEntity<Boolean> addPolicy(@RequestBody EvaluationDto dto) {
        return ResponseEntity.ok(casbinDemoService.addPolicy(dto.getSub(), dto.getObj(), dto.getAct()));
    }

    @PostMapping("/folder")
    public ResponseEntity<Boolean> addFolder(@RequestBody AddFolderDto dto) {
        return ResponseEntity.ok(casbinDemoService.addFolder(dto.getName(), dto.getParent()));
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody TestDtoIn testDtoIn) {
        return ResponseEntity.ok("Test");
    }
}
