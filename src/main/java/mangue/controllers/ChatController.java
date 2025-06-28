package mangue.controllers;

import mangue.entities.MessageEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class ChatController {

    @MessageMapping("/chat") // Recebe mensagem do cliente: /app/chat
    @SendTo("/topic/messages") // Envia para todos que estão no /topic/messages
    public MessageEntity send(MessageEntity message) {
        message.setSentAt(LocalDate.now());
        return message;
    }
}
