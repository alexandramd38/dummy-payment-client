package com.payment.client.service;

import com.payment.client.model.MakePaymentRequestType;
import com.payment.client.model.MakePaymentResponseType;

public interface PaymentService {

    /**
     * Sends make payment request to Payment server.
     *
     * @param request to be sent to the Payment server
     * @return make payment response details returned by the Payment server
     */
    MakePaymentResponseType makePayment(MakePaymentRequestType request);
}
