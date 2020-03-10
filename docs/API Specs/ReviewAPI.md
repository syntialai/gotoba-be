# Review API

## Get Review By Category

+ Endpoint : ``/review?category={category-name}``
+ HTTP Method : `GET`
+ Path Variable :
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
        "rating": 5.0,
        "comment": null,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "rating": 4.7,
        "comment": null,
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
    "path": "/review?category={category-name}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find category with category-name {category-name}.",
    "path": "/review?category={category-name}"
}
```

## Get Review by Category and by Rating

+ Endpoint : ``/review?category={category-name}&rate={rating}``
+ HTTP Method : `GET`
+ Path Variable :
  + category-name
  + rating
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
        "rating": 5.0,
        "comment": null,
        "merchant-id": 1,
        "merchant-sku": "synt_merc_0001",
        "user-id": 1,
        "user-sku": "sima_cust_001"
    }, {
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "rating": 5.0,
        "comment": null,
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
    "path": "/review?category={category-name}&rate={rating}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find category with category-name {category-name}.",
    "path": "/review?category={category-name}&rate={rating}"
}
```

## Get Review by Sku

+ Endpoint : ``/review/{sku}``
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
        "id": 2,
        "sku": "REV_rest_0001_0002",
        "category": "rest",
        "rating": 5.0,
        "comment": null,
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
    "path": "/review/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find review with sku {sku}.",
    "path": "/review/{sku}"
}
```

## Add Review by Category

+ Endpoint : ``/review?category={category-name}``
+ HTTP Method : `GET`
+ Path Variable :
  + category-name
+ Request Body :

```json
{
    "rating": 5.0,
    "comment": "OK"
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
        "sku": "REV_rest_0001_0001",
        "category": "rest",
        "rating": 5.0,
        "comment": "OK",
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
    "path": "/review?category={category-name}"
}

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/review?category={category-name}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find category with category-name {category-name}.",
    "path": "/review?category={category-name}"
}
```
