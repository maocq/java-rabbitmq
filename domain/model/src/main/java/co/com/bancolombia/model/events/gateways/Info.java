package co.com.bancolombia.model.events.gateways;

import lombok.Builder;

@Builder(toBuilder = true)
public record Info(String name) { }
