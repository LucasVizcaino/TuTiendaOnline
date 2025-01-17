package com.tutiendaonline.order.service;


import com.tutiendaonline.order.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.products-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody){
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<List<PurchaseResponse>>(){};
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                POST,
                requestEntity,
                responseType
        );
        if (responseEntity.getStatusCode().isError()){
            throw new BusinessException("Error occured while: " + responseEntity.getStatusCode());
        };
        return responseEntity.getBody();
    }
}