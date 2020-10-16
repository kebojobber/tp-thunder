package com.thunder.gateway.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lim14905
 * @create: 2020/10/14
 **/
@Component
@Slf4j
public class SqlGatewayFilterFactory extends AbstractGatewayFilterFactory<SqlGatewayFilterFactory.Config> {


    public SqlGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String userId = exchange.getAttribute("user-id");
            log.info("user-id:{}", userId);
            return chain.filter(exchange);
        };
    }


    public static class Config {

    }
}
