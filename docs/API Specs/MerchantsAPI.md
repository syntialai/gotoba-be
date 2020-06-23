# Merchants API

## Get All Merchants

+ Endpoint : ``/merchant/``
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
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "password" : "joshua",
        "role" : "Merchant",
        "status" : "active"
    }, {
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "password" : "joshua",
        "role" : "Merchant",
        "status" : "active"
    }, {
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "password" : "joshua",
        "role" : "Merchant",
        "status" : "active"
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

## Get Merchants by Sku

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
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "password" : "joshua",
        "role" : "Merchant",
        "status" : "active"
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

