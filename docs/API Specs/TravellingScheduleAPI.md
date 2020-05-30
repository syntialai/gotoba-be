# Wisata API

## Get All My Schedule (By SKU)

+ Endpoint : ``/shcedule/{sku}``
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
    "data": [{
        "id": 1,
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date" : "12-Mar-2020",
        "vacationDestination" : "hend-para-batu-001",
        "skuCustomer" : "Josh-Cust-001"
    },{
        "id": 2,
        "title": "Libur musim dingin",
        "description": "Liburan musim dingin di daerah danau toba",
        "date" : "12-Mar-2020",
        "vacationDestination" : "beny-lumb-pant-002",
        "skuCustomer" : "Josh-Cust-001"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Data not found",
    "message": "Message: There is no schedule found in that sku"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access."
}
```

## Get detail schedule (By schedule Id)

+ Endpoint : ``/shcedule/detail/{scheduleId}``
+ HTTP Method : `GET`
+ Path Variable :
  + scheduleId
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
          "date" : "12-Mar-2020",
          "vacationDestination" : "hend-para-batu-001",
          "skuCustomer" : "Josh-Cust-001"
      }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id."
}
```

## Update schedule (By schedule Id)

+ Endpoint : ``/shcedule/update/{scheduleId}``
+ HTTP Method : `PUT`
+ Path Variable :
  + scheduleId
+ Request Body :

```json
{
     "title": "Libur musim panas",
     "description": "Liburan musim panas di daerah danau toba",
     "date" : "13-Mar-2020",
     "endDate" : "14-Mar-2020",
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
      "message": "Update Success"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id."
}
```
