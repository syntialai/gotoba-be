# Payment API

## Get Payment by Merchant Sku

+ Endpoint : ``/pay?m={merchant-sku}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchant-sku
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
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "WAITING",
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 3,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "CANCELLED",
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
    "path": "/pay?m={merchant-sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku {merchant-sku}.",
    "path": "/pay?m={merchant-sku}"
}
```

## Get Payment by Merchant Sku and by Category

+ Endpoint : ``/pay?m={merchant-sku}&category={category-name}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchant-sku
  + category-name
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
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "WAITING",
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 3,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "total": 100000,
        "status": "CANCELLED",
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
    "path": "/pay?m={merchant-sku}&category={category-name}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find category with category-name {category-name}.",
    "path": "/pay?m={merchant-sku}&category={category-name}"
}
```

## Get Payment by User Sku and by Status

+ Endpoint : ``/pay?u={user-sku}&status={status}``
+ HTTP Method : `GET`
+ Path Variable :
  + user-sku
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
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
    "path": "/pay?u={user-sku}&status={status}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {user-sku}.",
    "path": "/pay?u={user-sku}&status={status}"
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
        "order-id": 1,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
    "message": "Invalid Request: Cannot find user with sku {user-sku}.",
    "path": "/pay/{sku}"
}
```

## Add Payment

+ Endpoint : ``/pay?u={user-sku}&m={merchant-sku}``
+ HTTP Method : `POST`
+ Path Variable :
  + user-sku
  + merchant-sku
+ Request Body :

```json
{
    "total": 50000,
    "status": "WAITING",
    "order-id": 2
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
        "order-id": 2,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
    "path": "/pay?u={user-sku}&m={merchant-sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/pay?u={user-sku}&m={merchant-sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {user-sku}.",
    "path": "/pay?u={user-sku}&m={merchant-sku}"
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
    "order-id": 2
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
        "order-id": 2,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
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
