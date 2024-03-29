package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/usecase/event"), handler::listenEmitEvent)
                .andRoute(GET("/api/usecase/notificacion"), handler::listenEmitNotification)
                .andRoute(GET("/api/usecase/command"), handler::listenSendCommand)
                .andRoute(GET("/api/usecase/req-reply"), handler::listenRequestReply)
                .andRoute(POST("/api/usecase/otherpath"), handler::listenPOSTUseCase);
    }
}
