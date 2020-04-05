# Merchants API

## Get Merchants

+ Endpoint : ``/merchant``
+ HTTP Method : `GET`
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
        "sku": "synt_merc_0001",
        "name": "Syntia",
        "email": "syntiaaa00@gmail.com",
        "username": "syntialai",
        "status": 1
    }, {
        "id": 2,
        "sku": "synt_merc_0002",
        "name": "Syntia",
        "email": "syntiaaa00@gmail.com",
        "username": "syntialai",
        "status": 1
    }, {
        "id": 3,
        "sku": "synt_merc_0003",
        "name": "Syntia",
        "email": "syntiaaa00@gmail.com",
        "username": "syntialai",
        "status": 0
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
    "path": "/merchant"
}
```

## Get Merchants (by Sku)

+ Endpoint : ``/merchant/{sku}``
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
        "id": 3,
        "sku": "synt_merc_0003",
        "name": "Syntia",
        "email": "syntiaaa00@gmail.com",
        "username": "syntialai",
        "status": 1
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
    "path": "/merchant/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with id ABC.",
    "path": "/merchant/{sku}"
}
```

## Edit Merchant by Sku

+ Endpoint : ``/merchant/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Syntia",
    "username": "syntialaii407",
    "email": "syntialaii407@gmail.com"
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
        "sku": "synt_merc_0004",
        "name": "Syntia",
        "email": "syntialaii407@gmail.com",
        "username": "syntialaii407",
        "status": 1
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
    "path": "/merchant/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: Invalid merchant authentication or Unauthorized.",
    "path": "/merchant/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with id ABC.",
    "path": "/merchant/{sku}"
}
```
