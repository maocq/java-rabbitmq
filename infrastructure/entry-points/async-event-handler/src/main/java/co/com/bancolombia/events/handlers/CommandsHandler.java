package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.events.gateways.Info;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableCommandListeners
public class CommandsHandler {
    // private final SampleUseCase sampleUseCase;

    public Mono<Void> handleCommandA(Command<Info> command) {
        System.out.println("command received: " + command.getName() + " ->" + command.getData());
        // return sampleUseCase.doSomething(command.getData());
        return Mono.empty();
    }
}
