package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.events.gateways.Info;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
    // private final SampleUseCase sampleUseCase;

    public Mono<Void> handleEventA(DomainEvent<Info> event) {
        System.out.println("event received: " + event.getName() + " ->" + event.getData());
        // return sampleUseCase.doSomething(event.getData());
        return Mono.empty();
    }
}
