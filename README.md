# dummy-payment-client

Make payment request:
<code>
{
    "firstName": "Ion",
    "lastName": "Popescu",
    "cardNumber": "123456788444444",
    "id": 10
}
</code>

Make payment response:
<code>
{
    "id": 10,
    "status": "SUCCESS"
}
</code>

If the paymentId is an even number, the status is SUCCESS, otherwise, it is ERROR.
HTTP status is 201