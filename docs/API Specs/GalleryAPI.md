# Gallery API

## Get Gallery Photos

+ Endpoint : ``/gallery/``
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
    "path": "/gallery/"
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
    "message": "Invalid Request: Cannot find photo with sku 10.",
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

+ Endpoint : ``/gallery/add``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Lake Toba Photo",
    "title": "Lake Toba Photo",
    "description": "jdfalfjkaljdkna....",
    "image": "base64,/9j/2wCEAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDIBCQkJDAsMGA0NGDIhHCEyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMv/AABEIAcwBzAMBIgACEQEDEQH/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/APXxSGilNUZDaOlLSUAjzb4l+C4buzl1zT4SLuP5p0jH+sXu2PUfyqD4YeM2nRdE1GcM4H+jO3Uj+6T6ivT+Oh714z8R/CD6NfjXNKiZLRzul8oY8mTPXjoD+hoKPaTRXH+AvGMPiLTltp3C6hAoEinq4/vCuwoEAoPSikzSAKKDSZoAKaaU0UANB5xS0nQ5pcUDAim0+mHrQIKTNLSUAJ3pc03ml6UDFzRSA5pOaAFzQTSUGgAzSZoNJQAUGiikA0ikp1IaAI3HegHNOPIqMH",
    "show": true
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
    "path": "/gallery/add"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/gallery/add"
}
```

## Edit Photo by Sku

+ Endpoint : ``/gallery/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Lake Toba Photo",
    "title": "Lake Toba Photo",
    "description": "jdfalfjkaljdkna....",
    "image": "base64,/9j/2wCEAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDIBCQkJDAsMGA0NGDIhHCEyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMv/AABEIAcwBzAMBIgACEQEDEQH/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/APXxSGilNUZDaOlLSUAjzb4l+C4buzl1zT4SLuP5p0jH+sXu2PUfyqD4YeM2nRdE1GcM4H+jO3Uj+6T6ivT+Oh714z8R/CD6NfjXNKiZLRzul8oY8mTPXjoD+hoKPaTRXH+AvGMPiLTltp3C6hAoEinq4/vCuwoEAoPSikzSAKKDSZoAKaaU0UANB5xS0nQ5pcUDAim0+mHrQIKTNLSUAJ3pc03ml6UDFzRSA5pOaAFzQTSUGgAzSZoNJQAUGiikA0ikp1IaAI3HegHNOPIqMH",
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
    "path": "/gallery/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/gallery/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find photo with sku 10.",
    "path": "/gallery/edit/{sku}"
}
```

## Delete Photo by Sku

+ Endpoint : ``/gallery/delete/{sku}``
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
    "path": "/gallery/delete/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find photo with sku ABC.",
    "path": "/gallery/delete/{sku}"
}
```
