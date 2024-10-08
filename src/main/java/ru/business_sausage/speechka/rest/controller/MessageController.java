package ru.business_sausage.speechka.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.business_sausage.speechka.rest.model.Message;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("msg")
@RequiredArgsConstructor
public class MessageController {
    private static final List<Message> messages = new ArrayList<>();

    @PostMapping
    public Flux<List<Message>> postMsg(@RequestBody Message body) {
        messages.add(body);
        return Flux.just(messages);
    }

    @GetMapping
    public Flux<List<Message>> getMessages() {
        return Flux.just(messages);
    }
}
