package co.com.bancolombia.api;

import co.com.bancolombia.model.events.gateways.DirectGateway;
import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.events.gateways.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final EventsGateway eventsGateway;
    private final DirectGateway directGateway;

    public Mono<ServerResponse> listenEmitEvent(ServerRequest serverRequest) {
        return eventsGateway.emit(Info.builder().name("Foo").build())
                .then(Mono.just("OK"))
                .flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> listenEmitNotification(ServerRequest serverRequest) {
        return eventsGateway.notify(Info.builder().name("Bar").build())
                .then(Mono.just("OK"))
                .flatMap(ServerResponse.ok()::bodyValue);
    }


    public Mono<ServerResponse> listenSendCommand(ServerRequest serverRequest) {
        return directGateway.sendCommand(Info.builder().name("Foo").build())
                .then(Mono.just("OK"))
                .flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> listenRequestReply(ServerRequest serverRequest) {
        return directGateway.requestReply(Info.builder().name("Foo").build())
                .then(Mono.just("OK"))
                .flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(InfoRequest.class)
                .doOnError(ServerWebInputException.class, error -> System.out.println(error.getMessage()))
                .flatMap(infoRequest -> ServerResponse.ok().bodyValue(infoRequest));
    }

    record InfoRequest(String name, int value) {
        InfoRequest {
            if (name == null || name.isBlank())
                throw new IllegalArgumentException("Name is required");
        }
    }
}
