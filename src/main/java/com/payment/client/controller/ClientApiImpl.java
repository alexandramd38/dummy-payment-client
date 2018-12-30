package com.payment.client.controller;

import static org.springframework.http.HttpStatus.CREATED;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.client.api.ClientApi;
import com.payment.client.converter.impl.MakePaymentRequestConverter;
import com.payment.client.converter.impl.MakePaymentResponseConverter;
import com.payment.client.model.MakePaymentRequestType;
import com.payment.client.model.MakePaymentResponseType;
import com.payment.client.model.PaymentRequest;
import com.payment.client.model.PaymentResponse;
import com.payment.client.service.impl.PaymentServiceImpl;

import io.swagger.annotations.ApiParam;

@RestController
public class ClientApiImpl implements ClientApi {

    private Logger LOG = LoggerFactory.getLogger(ClientApiImpl.class);

    private final PaymentServiceImpl httpClient;
    private final MakePaymentRequestConverter requestConverter;
    private final MakePaymentResponseConverter responseConverter;

    @Autowired
    public ClientApiImpl(PaymentServiceImpl httpClient,
                         MakePaymentResponseConverter responseConverter,
                         MakePaymentRequestConverter requestConverter) {
        this.httpClient = httpClient;
        this.responseConverter = responseConverter;
        this.requestConverter = requestConverter;
    }

    @Override
    public ResponseEntity<PaymentResponse> makePayment(@ApiParam(value = "API version", required = true) @PathVariable("version") String version,
                                                       @ApiParam(value = "", required = true) @Valid @RequestBody PaymentRequest body) {

        LOG.info("Request details: firstName: {}, lastName: {}, paymentId: {}", body.getFirstName(), body.getLastName(), body.getId());
        MakePaymentRequestType requestType = requestConverter.convertRequest(body);
        MakePaymentResponseType responseType = httpClient.makePayment(requestType);

        LOG.info("Response details: paymentId: {}, status: {}", responseType.getPaymentId(), responseType.getStatus());
        return new ResponseEntity<>(responseConverter.convertResponse(responseType), CREATED);
    }
}
