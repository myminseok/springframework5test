package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class ReactiveTest {
    private static Logger log = LoggerFactory.getLogger(ReactiveTest.class);

    public void fluxTest(){
        Flux.just("red", "white", "blue")
                .log()
                .flatMap(value ->
                                Mono.just(value.toUpperCase())
                                        .subscribeOn(Schedulers.parallel()),
                        2)
                .subscribe(value -> {
                    log.info("Consumed: " + value);
                });

    }
}
