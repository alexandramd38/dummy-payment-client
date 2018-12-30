package com.payment.client.converter.impl;

import org.springframework.stereotype.Component;

import com.payment.client.converter.RequestConverter;
import com.payment.client.model.MakePaymentRequestType;
import com.payment.client.model.PaymentRequest;

@Component
public class MakePaymentRequestConverter implements RequestConverter<PaymentRequest, MakePaymentRequestType> {
    @Override
    public MakePaymentRequestType convertRequest(PaymentRequest request) {
        MakePaymentRequestType requestType = new MakePaymentRequestType();
        requestType.setFirstName(request.getFirstName());
        requestType.setLastName(request.getLastName());
        requestType.setPaymentId(request.getId());
        requestType.setCardNumber(request.getCardNumber());
        return requestType;
    }
}
