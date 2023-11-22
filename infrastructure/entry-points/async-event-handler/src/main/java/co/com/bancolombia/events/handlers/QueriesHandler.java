package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.events.gateways.Info;
import lombok.AllArgsConstructor;
import org.reactivecommons.async.impl.config.annotations.EnableQueryListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableQueryListeners
public class QueriesHandler {
    // private final SampleUseCase sampleUseCase;

    public Mono<Info> handleQueryA(Info info) {
        System.out.println("query received ->" + info);
        // return sampleUseCase.doSomethingReturningNoMonoVoid(query);
        return Mono.just(Info.builder().name("Query Response").build());
    }
}
