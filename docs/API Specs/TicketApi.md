# Ticket API


## Get Ticket by Merchant Sku

+ Endpoint : ``/ticket/``
+ HTTP Method : `GET`
+ Path Variable :
  + merchantSku
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }, {
        "id": 2,
        "sku": "TICK_JOUR_0001_0002",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "journey",
        "price": 100000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }, {
        "id": 3,
        "sku": "TICK_JOUR_0001_0002",
        "category": "journey",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/merchant/{merchantSku}"
}
```


## Get Ticket by Merchant Sku

+ Endpoint : ``/ticket/merchant/{merchantSku}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchantSku
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }, {
        "id": 2,
        "sku": "TICK_JOUR_0001_0002",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "journey",
        "price": 100000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }, {
        "id": 3,
        "sku": "TICK_JOUR_0001_0002",
        "category": "journey",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/merchant/{merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku ABC.",
    "path": "/ticket/merchant/{merchantSku}"
}
```

## Get Ticket by Category

+ Endpoint : ``/ticket/category/{category}``
+ HTTP Method : `GET`
+ Path Variable :
  + category
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "wisataSku": "asd_132",
        "status": "active",
        "orderSku": "ORD_USE_0001_0001"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/category/{category}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find ticket with category 123.",
    "path": "/ticket/category/{category}"
}
```

## Get Ticket by Sku

+ Endpoint : ``/ticket/{sku}``
+ HTTP Method : `GET`
+ Path Variable :
  + sku
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "status": "active",
        "wisataSku": "asd_132",
        "orderSku": "ORD_0001_0001_0001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find ticket with sku ABC.",
    "path": "/ticket/{sku}"
}
```

## Add Ticket by Merchant Sku

+ Endpoint : ``/ticket/merchant/{merchantSku}/add``
+ HTTP Method : `POST`
+ Path Variable :
  + merchantSku
+ Request Body :

```json
{
    "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
    "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
    "category": "restaurant",
    "price": 50000,
        "discount": 0,
    "expiredDate": "2020-09-03",
    "merchantSku": "synt_merc_0001",
    "wisataSku": "WAT_0001",
    "orderSku": "ORD_USE_0001_0001"
}
```

+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 201,
    "status": "Created",
    "data": {
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
        "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "status": "active",
        "wisataSku": "asd_132",
        "orderSku": "ORD_USE_0001_0001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid request format.",
    "path": "/ticket/merchant/{merchantSku}/add"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/merchant/{merchantSku}/add"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku ABC.",
    "path": "/ticket/merchant/{merchantSku}/add"
}
```

## Edit Ticket by Sku

+ Endpoint : ``/ticket/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "title": "Diskon 50% untuk Tiket Masuk Danau Toba!",
    "description": "Nikmati diskon 50% setiap pembelian tiket masuk Danau ...",
    "category": "restaurant",
    "price": 50000,
    "discount": 0,
    "expiredDate": "2020-09-03",
    "merchantSku": "synt_merc_0001",
    "wisataSku": "asd_132",
    "orderSku": "ORD_USE_0001_0001"
}
```

+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "id": 1,
        "sku": "TICK_REST_0001_0001",
        "category": "restaurant",
        "price": 50000,
        "discount": 0,
        "expiredDate": "2020-09-03",
        "merchantSku": "synt_merc_0001",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "status": "active",
        "wisataSku": "asd_132",
        "orderSku": "ORD_USE_0001_0001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid request format.",
    "path": "/ticket/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find ticket with sku ABC.",
    "path": "/ticket/edit/{sku}"
}
```

## Delete Ticket by Sku

+ Endpoint : ``/ticket/delete/{sku}``
+ HTTP Method : `DELETE`
+ Path Variable :
  + sku
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "message": "Successfully delete ticket with sku TICK_REST_0001_0001"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid request format.",
    "path": "/ticket/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/delete/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find ticket with sku ABC.",
    "path": "/ticket/delete/{sku}"
}
```
