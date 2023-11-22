package co.com.bancolombia.events;
import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.events.handlers.QueriesHandler;
import co.com.bancolombia.model.events.gateways.Info;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events, QueriesHandler queries) {
        return HandlerRegistry.register()
                //.listenNotificationEvent("some.broadcast.event.name", events::handleEventA, Info.class)
                .listenEvent("some.event.name", events::handleEventA, Info.class)
                .handleCommand("some.command.name", commands::handleCommandA, Info.class)
                .serveQuery("some.query.name", queries::handleQueryA, Info.class);
    }
}
