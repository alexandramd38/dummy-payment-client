package com.payment.client.service.impl;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.payment.client.converter.ResponseConverter;
import com.payment.client.model.MakePaymentRequestType;
import com.payment.client.model.MakePaymentResponseType;
import com.payment.client.model.ObjectFactory;
import com.payment.client.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private static final String URI = "http://localhost:8080/ws";

    private final WebServiceTemplate webServiceTemplate;


    @Autowired
    public PaymentServiceImpl(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;

    }

    @Override
    public MakePaymentResponseType makePayment(MakePaymentRequestType request) {
        JAXBElement<MakePaymentRequestType> requestElement = new ObjectFactory().createMakePaymentRequest(request);

        try {
            JAXBElement<MakePaymentResponseType> response = (JAXBElement<MakePaymentResponseType>) webServiceTemplate.marshalSendAndReceive(URI,
                    requestElement);
            MakePaymentResponseType responseElement = response.getValue();
            return responseElement;
        } catch (SoapFaultClientException e) {
            LOG.warn("SOAP client exception thrown when communicating with the payment server");
            //TODO - handle SoapFaultClientException accordingly
            throw e;
        }
    }
}
