package com.payment.client.converter;

public interface RequestConverter<T, S> {
    /**
     * Converts the request received from client in the request for Payment server.
     *
     * @param request from client
     * @return Payment server request
     */
    S convertRequest(T request);
}
