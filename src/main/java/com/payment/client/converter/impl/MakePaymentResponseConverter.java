package com.payment.client.converter.impl;

import org.springframework.stereotype.Component;

import com.payment.client.converter.ResponseConverter;
import com.payment.client.model.MakePaymentResponseType;
import com.payment.client.model.PaymentResponse;

@Component
public class MakePaymentResponseConverter implements ResponseConverter<MakePaymentResponseType, PaymentResponse> {

    @Override
    public PaymentResponse convertResponse(MakePaymentResponseType response) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setId(response.getPaymentId());
        paymentResponse.setStatus(response.getStatus());
        return paymentResponse;
    }
}
