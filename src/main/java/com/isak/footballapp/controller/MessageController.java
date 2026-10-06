package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Message;
import com.isak.footballapp.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }

    @GetMapping
    public List<Message> findAll(){
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> findById(@PathVariable Long id){
        return messageService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        messageService.deleteById(id);
    }
}