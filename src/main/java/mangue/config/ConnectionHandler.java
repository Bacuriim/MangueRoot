package mangue.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class ConnectionHandler extends TextWebSocketHandler {
    
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        session.sendMessage(new TextMessage("Recebido: " + message.getPayload()));
        System.out.println(message.getPayload());
    }
    
    public void onOpen(WebSocketSession session) throws IOException {
        WebSocketMessage<String> webSocketMessage = new TextMessage("Oi");
        session.sendMessage(webSocketMessage);
    }
}
