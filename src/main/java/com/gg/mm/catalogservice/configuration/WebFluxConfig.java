package com.gg.mm.catalogservice.configuration;

import com.gg.mm.catalogservice.constant.CatalogConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig {
    Logger log = LoggerFactory.getLogger(WebFluxConfig.class);


    @Value("${application.mulesoft.base.url}")
    private String clientBaseUrl;

    @Value("${application.mulesoft.client_id}")
    private String clientId;

    @Value("${application.mulesoft.client_secret}")
    private String clientSecret;

    @Value("${application.mulesoft.xcorrelation_id}")
    private String correlationId;

    @Bean
    public WebClient getWebClient() {

        return WebClient.builder()
                .codecs(configure -> configure
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                .baseUrl(clientBaseUrl)
                .defaultHeaders(httpHeader -> {
                    httpHeader.add(CatalogConstant.CLIENT_ID, clientId);
                    httpHeader.add(CatalogConstant.CLIENT_SECRET, clientSecret);
                    httpHeader.add(CatalogConstant.CLIENT_CORRELATION_ID, correlationId);
                })
                .build();
    }

}
