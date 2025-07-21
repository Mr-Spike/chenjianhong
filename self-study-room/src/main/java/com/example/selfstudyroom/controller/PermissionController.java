package com.example.selfstudyroom.controller;

import com.example.selfstudyroom.model.AccessPermission;
import com.example.selfstudyroom.service.PermissionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PermissionController {
    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @GetMapping("/permissions/new")
    public String newPermissionForm() {
        return "permission_form";
    }

    @PostMapping("/permissions")
    public String addPermission(@RequestParam String userId,
                                @RequestParam String location,
                                @RequestParam String serviceType,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
                                Model model) {
        AccessPermission permission = new AccessPermission(userId, location, serviceType, startTime, endTime);
        service.addPermission(permission);
        model.addAttribute("message", "Permission added for user " + userId);
        return "permission_form";
    }

    @GetMapping("/permissions/{userId}")
    @ResponseBody
    public List<AccessPermission> listPermissions(@PathVariable String userId) {
        return service.getPermissionsForUser(userId);
    }
}
