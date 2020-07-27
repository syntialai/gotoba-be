# Travelling Schedule API

## Get All My Schedule by User Sku

+ Endpoint : ``/schedule/{userSku}``
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
        "sku": "TRAV_SYNT_0001_0001",
        "date": "2015-11-13",
        "schedule": [{
            "destination": "Danau Toba",
            "time": "12:12:12"
        }, {
            "destination": "Danau Toba",
            "time": "12:15:20"
        }],
        "userSku" : "HEND_0001",
        "status" : "active"
    }, {
        "id": 2,
        "sku": "TRAV_SYNT_0001_0002",
        "date": "2015-11-13",
        "schedule": [{
            "destination": "Danau Toba",
            "time": "12:12:12"
        }, {
            "destination": "Danau Toba",
            "time": "12:15:20"
        }],
        "userSku" : "HEND_0001",
        "status" : "active"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Data not found",
    "message": "Message: There is no schedule found in that user sku",
    "path": "/schedule/{userSku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/schedule/{userSku}"
}
```

## Add Schedule by Sku

+ Endpoint : ``/schedule/{userSku}/add``
+ HTTP Method : `POST`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "date": "2015-11-13",
    "schedule": [{
        "destination": "Danau Toba",
        "time": "12:12:12"
    }, {
        "destination": "Danau Toba",
        "time": "12:15:20"
    }]
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
    "message": "Tambah schedule sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/{userSku}/add"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that sku.",
    "path": "/schedule/{userSku}/add"
}
```

## Get Schedule by Sku

+ Endpoint : ``/schedule/detail/{sku}``
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
        "date": "2015-11-13",
        "schedule": [{
            "destination": "Danau Toba",
            "time": "12:12:12"
        }, {
            "destination": "Danau Toba",
            "time": "12:15:20"
        }],
        "userSku" : "HEND_0001",
        "status" : "active"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/detail/{sku}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/detail/{sku}"
}
```

## Edit Schedule by Sku

+ Endpoint : ``/schedule/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "date": "2015-11-13",
    "schedule": [{
        "destination": "Danau Toba",
        "time": "12:12:12"
    }, {
        "destination": "Danau Toba",
        "time": "12:15:20"
    }]
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
        "sku": "TRAV_SYNT_0001_0001",
        "date": "2015-11-13",
        "schedule": [{
            "destination": "Danau Toba",
            "time": "12:12:12"
        }, {
            "destination": "Danau Toba",
            "time": "12:15:20"
        }],
        "userSku" : "HEND_0001",
        "status" : "active"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/edit/{sku}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that sku.",
    "path": "/schedule/edit/{sku}"
}
```

## Delete Schedule by Id

+ Endpoint : ``/schedule/delete/{sku}``
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
      "message": "Schedule deleted with sku 1."
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/delete/{sku}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that sku.",
    "path": "/schedule/delete/{sku}"
}
```
