# Payment API

## Get Payment by Merchant Sku

+ Endpoint : ``/pay/merchant/{merchantSku}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchantSku
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": 1,
        "sku": "REV_rest_0001_0001",
        "total": 50000,
        "status": "ACCEPTED",
        "orderSku": 1,
        "createdAt": "2016-11-15T22:55:40.110Z",
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "total": 100000,
        "status": "WAITING",
        "orderSku": 1,
        "createdAt": "2016-11-15T22:55:40.110Z",
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
    }, {
        "id": 3,
        "sku": "REV_rest_0001_0002",
        "total": 100000,
        "status": "CANCELLED",
        "orderSku": 1,
        "createdAt": "2016-11-15T22:55:40.110Z",
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
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
    "path": "/pay/merchant/{merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku ABC.",
    "path": "/pay/merchant/{merchantSku}"
}
```

## Get Payment by User Sku and by Status

+ Endpoint : ``/pay/user/{userSku}/status/{status}``
+ HTTP Method : `GET`
+ Path Variable :
  + userSku
  + status
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "id": 1,
        "sku": "REV_rest_0001_0001",
        "total": 50000,
        "status": "ACCEPTED",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "orderSku": 1,
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
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
    "path": "/pay/user/{userSku}/status/{status}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku ABC.",
    "path": "/pay/user/{userSku}/status/{status}"
}
```

## Get Payment by Sku

+ Endpoint : ``/pay/sku/{sku}``
+ HTTP Method : `GET`
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
    "data": {
        "id": 1,
        "sku": "REV_rest_0001_0001",
        "total": 50000,
        "status": "ACCEPTED",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "orderSku": 1,
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
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
    "path": "/pay/sku/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find payment with sku ABC.",
    "path": "/pay/sku/{sku}"
}
```

## Add Payment by User Sku

+ Endpoint : ``/pay/add/{userSku}``
+ HTTP Method : `POST`
+ Path Variable :
  + userSku
+ Request Body :

```json
{
    "total": 50000,
    "status": "WAITING",
    "merchantSku": "synt_merc_0001",
    "orderSku": 2
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
        "id": 4,
        "sku": "REV_rest_0001_0004",
        "total": 50000,
        "status": "WAITING",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "orderSku": 2,
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
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
    "path": "/pay/add/{userSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/pay/add/{userSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {userSku}.",
    "path": "/pay/add/{userSku}"
}
```

## Edit Payment by Sku

+ Endpoint : ``/pay/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "total": 50000,
    "status": "ACCEPTED",
    "orderSku": 2
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
        "id": 4,
        "sku": "REV_rest_0001_0004",
        "total": 50000,
        "status": "ACCEPTED",
        "createdAt": "2016-11-15T22:55:40.110Z",
        "orderSku": 2,
        "merchantSku": "synt_merc_0001",
        "userSku": "sima_cust_001"
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
    "path": "/pay/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/pay/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find payment with sku ABC.",
    "path": "/pay/edit/{sku}"
}
```
