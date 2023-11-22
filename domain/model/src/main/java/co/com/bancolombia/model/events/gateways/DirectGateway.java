package co.com.bancolombia.model.events.gateways;

import reactor.core.publisher.Mono;

public interface DirectGateway {

    Mono<Void> sendCommand(Object command);
    Mono<Info> requestReply(Info command);
}
