package org.cloud.chiron.framework.amqp;

import java.io.IOException;

import org.cloud.chiron.common.util.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class IPMessageReceiver {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${ip.queue.sender}", containerFactory = "singleListenerContainer")
    public void processMessage(@Payload byte[] message) {
        
        try {
            CommandLine commandLine = objectMapper.readValue(message, CommandLine.class);
            logger.info("Receiving Message: -----[%s]----- .", commandLine.getCommandString());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
