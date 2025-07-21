package com.example.selfstudyroom.controller;

import com.example.selfstudyroom.service.WebhookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/door")
public class DoorController {
    private final WebhookService webhookService;

    public DoorController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/enter")
    public String enter(@RequestParam String userId, @RequestParam String location) {
        webhookService.sendEntryNotification(userId, location);
        return "Entry recorded";
    }
}
