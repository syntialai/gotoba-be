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
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "hend-para-batu-001",
        "userSku": "Josh-Cust-001"
    }, {
        "id": 2,
        "title": "Libur musim dingin",
        "description": "Liburan musim dingin di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "beny-lumb-pant-002",
        "userSku": "Josh-Cust-001"
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
    "title": "Libur musim panas",
    "description": "Liburan musim panas di daerah danau toba",
    "date" : "2015-11-13 13:30:21",
    "endDate" : "2015-11-14 13:30:21",
    "vacationDestination" : "hend-para-batu-001"
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

## Get Schedule by Id

+ Endpoint : ``/schedule/detail/{id}``
+ HTTP Method : `GET`
+ Path Variable :
  + id
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
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "hend-para-batu-001",
        "userSku": "Josh-Cust-001"
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
    "path": "/schedule/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/{id}"
}
```

## Edit Schedule by Id

+ Endpoint : ``/schedule/edit/{id}``
+ HTTP Method : `PUT`
+ Path Variable :
  + id
+ Request Body :

```json
{
    "title": "Libur musim panas",
    "description": "Liburan musim panas di daerah danau toba",
    "date" : "2015-11-13 13:30:21",
    "endDate" : "2015-11-14 13:30:21",
    "vacationDestination" : "hend-para-batu-001"
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
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "hend-para-batu-001",
        "userSku": "Josh-Cust-001"
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
    "path": "/schedule/edit/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/edit/{id}"
}
```

## Delete Schedule by Id

+ Endpoint : ``/schedule/delete/{id}``
+ HTTP Method : `DELETE`
+ Path Variable :
  + id
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
      "code": 200,
      "status": "OK",
      "message": "Schedule deleted with id 1."
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/delete/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/delete/{id}"
}
```
