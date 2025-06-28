package mangue.config;

import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionHandler implements WebSocketHandler {
    
    private ConcurrentHashMap<WebSocketSession, String> clients = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        clients.put(session, session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message){
        System.out.println("[Handler] Mensagem recebida de: " + session.getId() + " -> " + message.getPayload());
        broadcast(message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        System.err.println("Erro de transporte: " + exception.getMessage());
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        clients.remove(session, session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    

    private void broadcast(WebSocketMessage<?> message) {
        clients.keySet().forEach(s -> {
            if (s.isOpen()) {
                try {
                    s.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
