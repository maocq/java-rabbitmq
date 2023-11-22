package co.com.bancolombia.events;

import co.com.bancolombia.model.events.gateways.DirectGateway;
import co.com.bancolombia.model.events.gateways.Info;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@EnableDirectAsyncGateway
public class ReactiveDirectAsyncGateway implements DirectGateway {
    public static final String TARGET_NAME = "JavaRabbitMq";  // spring.application.name de la app que recibe el mensaje
    public static final String COMMAND_NAME = "some.command.name";
    public static final String SOME_QUERY_NAME = "some.query.name";

    private final DirectAsyncGateway gateway;

    @Override
    public Mono<Void> sendCommand(Object command) {
        log.log(Level.INFO, "Sending command: {0}: {1}", new String[]{COMMAND_NAME, command.toString()});
        return gateway.sendCommand(new Command<>(COMMAND_NAME, UUID.randomUUID().toString(), command), TARGET_NAME);
    }

    @Override
    public Mono<Info> requestReply(Info query) {
        log.log(Level.INFO, "Sending query request: {0}: {1}", new String[]{SOME_QUERY_NAME, query.toString()});
        return gateway.requestReply(new AsyncQuery<>(SOME_QUERY_NAME, query), TARGET_NAME, Info.class);
    }
}
