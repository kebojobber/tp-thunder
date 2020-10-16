package com.thunder.gateway.core.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @description: 黑白名单filter
 * @author: lim14905
 * @create: 2020/10/16
 **/
@Slf4j
@Component
public class RBLGatewayFilterFactory extends AbstractGatewayFilterFactory<RBLGatewayFilterFactory.Config> {

    public RBLGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("=======invoke RBL filter=======");
                String path = exchange.getRequest().getURI().getPath();
                if (config.matchBlackList(path)) {
                    log.info("black path:{}", path);
                    throw new RuntimeException();
                }
                if (config.matchWhiteList(path)) {
                    log.info("white path:{}", path);
                }
            }));
        };
    }

    @Data
    public static class Config {

        private String blackListUrl;

        private String whiteListUrl;

        private List<Pattern> blacklistUrlPattern = new ArrayList<>();

        private List<Pattern> whitelistUrlPattern = new ArrayList<>();

        public boolean matchBlackList(String url) {
            return !blacklistUrlPattern.isEmpty() && blacklistUrlPattern.stream().anyMatch(p -> p.matcher(url).find());
        }

        public boolean matchWhiteList(String url) {
            return !whitelistUrlPattern.isEmpty() && whitelistUrlPattern.stream().anyMatch(p -> p.matcher(url).find());
        }

    }
}
