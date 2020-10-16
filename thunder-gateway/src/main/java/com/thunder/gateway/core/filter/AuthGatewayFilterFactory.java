package com.thunder.gateway.core.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lim14905
 * @create: 2020/10/14
 **/
@Slf4j
@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange);
        };
    }

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    @Data
    public static class Config {

        private boolean includeQueryParams = true;

        private boolean includeBody = true;
    }
}
