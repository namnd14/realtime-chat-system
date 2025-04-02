package chat.io.realtime.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.time.LocalTime;

public class ServerWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String request = message.getPayload();
        // logger.info("Server received: {}", request);

        String response = String.format("response from server to '%s'", HtmlUtils.htmlEscape(request));
        // logger.info("Server sends: {}", response);
        session.sendMessage(new TextMessage(response));
    }

//    @Scheduled(fixedRate = 10000)
//    void sendPeriodicMessages() throws IOException {
//        for (WebSocketSession session : sessions) {
//            if (session.isOpen()) {
//                String broadcast = "server periodic message " + LocalTime.now();
//                // logger.info("Server sends: {}", broadcast);
//                session.sendMessage(new TextMessage(broadcast));
//            }
//        }
//    }
}
