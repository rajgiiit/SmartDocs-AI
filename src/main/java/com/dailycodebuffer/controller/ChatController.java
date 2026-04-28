package com.dailycodebuffer.controller;

import com.dailycodebuffer.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ask")
    public String askAi(@RequestParam String question) {
        return chatService.ask(question);
    }
}
