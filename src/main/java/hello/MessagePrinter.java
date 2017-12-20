package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Component
public class MessagePrinter {
    final private MessageService service;
    private static Logger log = LoggerFactory.getLogger(MessagePrinter.class);

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service= service;
    }

    public void printMessage() {
       log.info(this.service.getMessage());
    }


}
