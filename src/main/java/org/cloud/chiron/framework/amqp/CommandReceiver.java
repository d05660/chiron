package org.cloud.chiron.framework.amqp;

import java.io.IOException;

import org.cloud.chiron.common.util.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

@Component
public class CommandReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${command.queue.receiver}", containerFactory = "singleListenerContainer")
    public void processMessage(Message message, Channel channel) {
        try {
            CommandLine commandLine = objectMapper.readValue(message.getBody(), CommandLine.class);
            logger.info(commandLine.toString());
            logger.info("Receiving Message: IP address: {}, Time is: {}", commandLine.getCommand(),
                    commandLine.getDate());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
