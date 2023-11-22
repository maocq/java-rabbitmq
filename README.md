# Java RabbitMQ

```shell
docker run --rm -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
docker exec -it rabbitmq sh
```

http://localhost:15672/#/

### Events
Exchange (domainEvents) -> Queue (JavaRabbitMq.subsEvents)
```shell
rabbitmqadmin publish exchange=domainEvents routing_key="some.event.name" payload='{"name":"some.event.name","eventId":"c09b0955-a25f-41f6-962b-1587f1f88302","data":{"name":"Foo"}}'
```

### Commands
Exchange (directMessages) -> Queue (JavaRabbitMq)
```shell
rabbitmqadmin publish exchange=directMessages routing_key="JavaRabbitMq" payload='{"name":"some.command.name","eventId":"c09b0955-a25f-41f6-962b-1587f1f88302","data":{"name":"Bar"}}'
```

### Req-reply
Exchange (directMessages) -> Queue (JavaRabbitMq.query)

