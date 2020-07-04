# Order Detail API

## Get Order Detail by Sku

+ Endpoint : ``/order/{sku}``
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
        "sku": "ORD_0001_0001_0001",
        "ticket": [{
            "ticketSku": "TICK_REST_0001_0001",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }, {
            "ticketSku": "TICK_JOUR_0001_0002",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }],
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
    "path": "/order/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find order with sku ABC.",
    "path": "/order/{sku}"
}
```

## Get Order Detail by Merchant Sku

+ Endpoint : ``/order/merchant/{merchantSku}``
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
        "sku": "ORD_0001_0001_0001",
        "ticket": [{
            "ticketSku": "TICK_REST_0001_0001",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }, {
            "ticketSku": "TICK_JOUR_0001_0002",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }],
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
    "path": "/order/merchant/{merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku abc.",
    "path": "/order/merchant/{merchantSku}"
}
```

## Get Order Detail by User Sku

+ Endpoint : ``/order/user/{userSku}``
+ HTTP Method : `GET`
+ Path Variable :
  + userSku
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
        "sku": "ORD_0001_0001_0001",
        "ticket": [{
            "ticketSku": "TICK_REST_0001_0001",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }, {
            "ticketSku": "TICK_JOUR_0001_0002",
            "quantity": 1,
            "price": 100000,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }],
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
    "path": "/order/user/{userSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku {sku}.",
    "path": "/order/user/{userSku}"
}
```

## Add Order Detail by User Sku

+ Endpoint : ``/order/user/{userSku}/add``
+ HTTP Method : `POST`
+ Path Variable :
  + userSku
+ Request Body :

```json
{
    "ticket": [{
        "ticketSku": "TICK_JOUR_0001_0002",
        "quantity": 1,
        "price": 100000,
        "discount": 0,
        "merchantSku": "synt_merc_0001",
        "category": "wisata",
        "wisataSku" : "WAH_BAL_0003"
    }],
    "userSku": "sima_cust_001"
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
    "data": [{
        "id": 1,
        "sku": "ORD_0001_0001_0001",
        "ticket": [{
            "ticketSku": "TICK_REST_0001_0001",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }, {
            "ticketSku": "TICK_JOUR_0001_0002",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }],
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
    "path": "/order/user/{userSku}/add"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find user with sku BAC.",
    "path": "/order/user/{userSku}/add"
}
```

## Edit Order Detail by Sku

+ Endpoint : ``/order/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "ticket": [{
        "ticketSku": "TICK_JOUR_0001_0002",
        "quantity": 1,
        "price": 100000,
        "discount": 0,
        "merchantSku": "synt_merc_0001",
        "category": "wisata",
        "wisataSku" : "WAH_BAL_0003"
    }],
    "userSku": "sima_cust_001"
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
    "data": [{
        "id": 1,
        "sku": "ORD_0001_0001_0001",
        "ticket": [{
            "ticketSku": "TICK_JOUR_0001_0002",
            "quantity": 1,
            "price": 100000,
            "discount": 0,
            "merchantSku": "synt_merc_0001",
            "category": "wisata",
            "wisataSku" : "WAH_BAL_0003"
        }],
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
    "path": "/order/edit/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find order with sku ABC.",
    "path": "/order/edit/{sku}"
}
```

## Delete Order by Sku

+ Endpoint : ``/order/delete/{sku}``
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
    "message" : "Delete success!"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/order/delete/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find order with sku ABC.",
    "path": "/order/delete/{sku}"
}
```
