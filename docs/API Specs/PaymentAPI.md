# Payment API

## Get Payment by Merchant Sku

+ Endpoint : ``/pay?m={merchantSku}``
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
        "category": "rest",
        "total": 50000,
        "status": "ACCEPTED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
        "userSku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "WAITING",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
        "userSku": "sima_cust_001"
    }, {
        "id": 3,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "CANCELLED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay?m={merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku {merchantSku}.",
    "path": "/pay?m={merchantSku}"
}
```

## Get Payment by Merchant Sku and by Category

+ Endpoint : ``/pay?m={merchantSku}&category={categoryName}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchantSku
  + categoryName
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
        "category": "rest",
        "total": 50000,
        "status": "ACCEPTED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
        "userSku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "WAITING",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
        "userSku": "sima_cust_001"
    }, {
        "id": 3,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "CANCELLED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay?m={merchantSku}&category={categoryName}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find category with categoryName {categoryName}.",
    "path": "/pay?m={merchantSku}&category={categoryName}"
}
```

## Get Payment by User Sku and by Status

+ Endpoint : ``/pay?u={userSku}&status={status}``
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
        "category": "rest",
        "total": 50000,
        "status": "ACCEPTED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay?u={userSku}&status={status}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {userSku}.",
    "path": "/pay?u={userSku}&status={status}"
}
```

## Get Payment by Sku

+ Endpoint : ``/pay/{sku}``
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
        "category": "rest",
        "total": 50000,
        "status": "ACCEPTED",
        "orderId": 1,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {userSku}.",
    "path": "/pay/{sku}"
}
```

## Add Payment

+ Endpoint : ``/pay?u={userSku}&m={merchantSku}``
+ HTTP Method : `POST`
+ Path Variable :
  + userSku
  + merchantSku
+ Request Body :

```json
{
    "total": 50000,
    "status": "WAITING",
    "orderId": 2
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
        "category": "rest",
        "total": 50000,
        "status": "WAITING",
        "orderId": 2,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay?u={userSku}&m={merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/pay?u={userSku}&m={merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {userSku}.",
    "path": "/pay?u={userSku}&m={merchantSku}"
}
```

## Edit Payment by Sku

+ Endpoint : ``/pay/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "total": 50000,
    "status": "ACCEPTED",
    "orderId": 2
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
        "category": "rest",
        "total": 50000,
        "status": "ACCEPTED",
        "orderId": 2,
        "merchantId": 1,
        "merchantSku": "synt_merc_0001",
        "userId": 1,
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
    "path": "/pay/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/pay/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find payment with sku {sku}.",
    "path": "/pay/{sku}"
}
```
