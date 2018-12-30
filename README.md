# dummy-payment-client

Make payment request:
Endpoint: <code>localhost:8090/client/v1.0/makePayment</code>
```json
{
    "firstName": "Ion",
    "lastName": "Popescu",
    "cardNumber": "123456788444444",
    "id": 10
}
```

Make payment response:
```json
{
    "id": 10,
    "status": "SUCCESS"
}
```

If the paymentId is an even number, the status is SUCCESS, otherwise, it is ERROR.
HTTP status is 201