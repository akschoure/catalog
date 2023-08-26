package com.gg.mm.catalogservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {

    @Value("${application.service.name}")
    private String serviceName;

    @Value("${application.service.description}")
    private String serviceDescription;

    @Value("${application.service.currentVersion}")
    private String serviceCurrentVersion;

    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    /**
     * to get the current API version of this service
     *
     * @return currentVersion
     */
    @Operation(summary = "Get the current version of this API")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get the Version",
                    content = {@Content(mediaType = "application/json")}
            )
    }
    )
    @GetMapping("/getApiVersion")
    public ResponseEntity<Map<String, String>> getApiVersion() {

        Map<String, String> metaData = new HashMap<>();
        metaData.put("serviceName", serviceName);
        metaData.put("serviceDescription", serviceDescription);
        metaData.put("serviceCurrentVersion", serviceCurrentVersion);

        log.info("getApiVersion");

        return new ResponseEntity<>(metaData, HttpStatus.OK);
    }

}
