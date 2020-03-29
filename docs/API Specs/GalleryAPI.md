# Gallery API

## Get Gallery Photos

+ Endpoint : ``/gallery``
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
        "sku": "PHOTO_0000_0001",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-1",
        "show": true
    }, {
        "id": 2,
        "sku": "PHOTO_0000_0002",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-2",
        "show": true
    }, {
        "id": 3,
        "sku": "PHOTO_0000_0003",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-3",
        "show": false
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Server Error: Error while getting and/or parsing the data.",
    "path": "/gallery"
}
```

## Get Gallery Photo by Sku

+ Endpoint : ``/gallery/{sku}``
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
        "sku": "PHOTO_0000_0001",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-1",
        "show": true
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find photo with id 10.",
    "path": "/gallery/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Server Error: Error while getting and/or parsing the data.",
    "path": "/gallery/{sku}"
}
```

## Add new Photo

+ Endpoint : ``/gallery``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Lake Toba Photo",
    "title": "Lake Toba Photo",
    "description": "jdfalfjkaljdkna....",
    "image": "/gallery/photo-1",
    "show": true
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
        "sku": "PHOTO_0000_0001",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-1",
        "show": true
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid request format.",
    "path": "/gallery"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/gallery"
}
```

## Edit Photo by Id

+ Endpoint : ``/gallery/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Lake Toba Photo",
    "title": "Lake Toba Photo",
    "description": "jdfalfjkaljdkna....",
    "image": "/gallery/photo-1",
    "show": true
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
        "sku": "PHOTO_0000_0001",
        "name": "Lake Toba Photo",
        "title": "Lake Toba Photo",
        "description": "jdfalfjkaljdkna....",
        "image": "/gallery/photo-1",
        "show": true
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid request format.",
    "path": "/gallery/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/gallery/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find photo with id 10.",
    "path": "/gallery/{sku}"
}
```
