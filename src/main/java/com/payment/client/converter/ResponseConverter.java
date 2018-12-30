package com.payment.client.converter;

public interface ResponseConverter<T, S> {

    /**
     * Converts the response received from the Payment server in the client response.
     *
     * @param response received from the Payment Server
     * @return client response
     */
    S convertResponse(T response);
}
