# Tour Guide API

## Get Tour Guide

+ Endpoint : ``/tour-guide``
+ HTTP Method : `GET`
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
  "code": 200,
  "status": "OK",
  "data": [{
    "id": 1,
    "sku": "TG_ANAS_0001",
    "name": "Anastasya",
    "age": 20,
    "occupation": "Tour Guide",
    "location": "Balige",
    "rating": 4.7,
    "language": ["English", "Indonesia"],
    "availableLocation": ["Parapat", "Silangit"],
    "phone": "+62812 3456 7890",
    "email": "anakayam.jago@gmail.com",
    "whatsapp": "+62812 3456 7890",
    "experience": null,
    "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me.",
    "status": "active"
  }, {
    "id": 2,
    "sku": "TG_ANAB_0002",
    "name": "Anabelle",
    "age": 25,
    "occupation": "Translator",
    "location": "Parapat",
    "rating": 4.0,
    "language": ["English", "Indonesia"],
    "availableLocation": ["Parapat", "Silangit"],
    "phone": "+62812 3456 7890",
    "email": "anakayam.jago@gmail.com",
    "whatsapp": "+62812 3456 7890",
    "experience": null,
    "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me.",
    "status": "active"
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
    "path": "/tour-guide"
}
```

## Get Tour Guide by Sku

+ Endpoint : ``/tour-guide/{sku}``
+ HTTP Method : `GET`
+ Path Variable :
  + sku
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
        "id": 1,
        "sku": "TG_ANAS_0001",
        "name": "Anastasya",
        "age": 20,
        "occupation": "Tour Guide",
        "location": "Balige",
        "rating": 4.7,
        "language": ["English", "Indonesia"],
        "availableLocation": ["Parapat", "Silangit"],
        "phone": "+62812 3456 7890",
        "email": "anakayam.jago@gmail.com",
        "whatsapp": "+62812 3456 7890",
        "experience": null,
        "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me.",
        "status": "active"
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
    "path": "/tour-guide/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find tour guide with id ABC.",
    "path": "/tour-guide/{sku}"
}
```

## Add new Tour Guide

+ Endpoint : ``/tour-guide``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Anastasya",
    "age": 20,
    "occupation": "Tour Guide",
    "location": "Balige",
    "rating": 4.7,
    "language": ["English", "Indonesia"],
    "availableLocation": ["Parapat", "Silangit"],
    "phone": "+62812 3456 7890",
    "email": "anakayam.jago@gmail.com",
    "whatsapp": "+62812 3456 7890",
    "experience": null,
    "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me."
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
        "sku": "TG_ANAS_0001",
        "name": "Anastasya",
        "age": 20,
        "occupation": "Tour Guide",
        "location": "Balige",
        "rating": 4.7,
        "language": ["English", "Indonesia"],
        "availableLocation": ["Parapat", "Silangit"],
        "phone": "+62812 3456 7890",
        "email": "anakayam.jago@gmail.com",
        "whatsapp": "+62812 3456 7890",
        "experience": null,
        "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me.",
        "status": "active"
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
    "path": "/tour-guide"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/tour-guide"
}
```

## Edit Tour Guide by Sku

+ Endpoint : ``/tour-guide/{sku}``
+ HTTP Method : `POST`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Anastasya",
    "age": 20,
    "occupation": "Tour Guide",
    "location": "Balige",
    "rating": 4.7,
    "language": ["English", "Indonesia"],
    "availableLocation": ["Parapat", "Silangit"],
    "phone": "+62812 3456 7890",
    "email": "anakayam.jago@gmail.com",
    "whatsapp": "+62812 3456 7890",
    "experience": null,
    "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me."
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
        "sku": "TG_ANAS_0001",
        "name": "Anastasya",
        "age": 20,
        "occupation": "Tour Guide",
        "location": "Balige",
        "rating": 4.7,
        "language": ["English", "Indonesia"],
        "availableLocation": ["Parapat", "Silangit"],
        "phone": "+62812 3456 7890",
        "email": "anakayam.jago@gmail.com",
        "whatsapp": "+62812 3456 7890",
        "experience": null,
        "description": "I'm a young tour guide that experienced, have served more than 50 customer and all of them are satisfied with me.",
        "status": "active"
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
    "path": "/tour-guide/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/tour-guide/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find tour guide with id ABC.",
    "path": "/tour-guide/{sku}"
}
```