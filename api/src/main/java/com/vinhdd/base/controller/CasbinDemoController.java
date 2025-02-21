package com.vinhdd.base.controller;

import com.vinhdd.base.dto.in.AddResourceDto;
import com.vinhdd.base.dto.in.EvaluationDto;
import com.vinhdd.base.dto.in.GetDataIn;
import com.vinhdd.base.service.CasbinDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/resource")
    public ResponseEntity<Boolean> addResource(@RequestBody AddResourceDto dto) {
        return ResponseEntity.ok(casbinDemoService.addResource(dto.getName(), dto.getParent()));
    }

    @PostMapping("/user-group")
    public ResponseEntity<Boolean> addUserToGroup(@RequestBody AddResourceDto dto) {
        return ResponseEntity.ok(casbinDemoService.addUserToGroup(dto.getName(), dto.getParent()));
    }

    @PostMapping("/permission-role")
    public ResponseEntity<Boolean> addPermissionToRole(@RequestBody AddResourceDto dto) {
        return ResponseEntity.ok(casbinDemoService.addPermissionToRole(dto.getName(), dto.getParent()));
    }

    @GetMapping("/children")
    public ResponseEntity<?> getAllChildrenOfParent(GetDataIn dto) {
        return ResponseEntity.ok(casbinDemoService.getAllChildrenOfParent(dto.getPtype(), dto.getName()));
    }

    @GetMapping("/parent")
    public ResponseEntity<?> getAllParentOfChild(GetDataIn dto) {
        return ResponseEntity.ok(casbinDemoService.getAllParentOfChild(dto.getPtype(), dto.getName()));
    }

    @GetMapping("/tree")
    public ResponseEntity<?> getTree(GetDataIn dto) {
        return ResponseEntity.ok(casbinDemoService.getTree(dto.getPtype(), dto.getName()));
    }
}
