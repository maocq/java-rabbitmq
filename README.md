# Java RabbitMQ

```shell
docker run --rm -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
```

http://localhost:15672/#/

exchange: domainEvents
```json
{"name":"some.event.name","eventId":"c09b...","data":{"name":"Foo"}}
```
