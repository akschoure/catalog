package com.gg.mm.catalogservice.systeminterface;

import com.gg.mm.catalogservice.models.discount.DiscountMatrixRootObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Component
public class DiscountMatrixClient {

    private static final Logger log = LoggerFactory.getLogger(DiscountMatrixClient.class);

    @Autowired
    private WebClient webClient;

    @Value("${application.mulesoft.base.simoDiscountMatrix}")
    private String discountMatrixBatchNumber;


    public DiscountMatrixRootObject[] getDiscountMatrixResult() {
        log.info("CatalogClient:getPricingMatrixResultWithBatchNumber - started");
        DiscountMatrixRootObject[] discountMatrixRootObjects = webClient.get()
                .uri(discountMatrixBatchNumber)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DiscountMatrixRootObject[].class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(3)))
                .block();
        log.info("CatalogClient:getPricingMatrixResultWithBatchNumber - ended");
        return discountMatrixRootObjects;
    }


}
