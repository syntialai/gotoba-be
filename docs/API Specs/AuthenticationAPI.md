# API for Authentication

## Register

+ Endpoint : ``/auth/signup``
+ HTTP Method : ``POST``
+ Request Body :

```json
{
    "nickname" : "hendra",
    "username" : "hendra",
    "email" : "hendra@gmail.com",
    "password" : "hendra77",
    "confirmPassword" : "hendra77",
    "role" : "ROLE_MERCHANT",
    "image" : "base64,/9j/2wCEAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDIBCQkJDAsMGA0NGDIhHCEyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMv/AABEIAcwBzAMBIgACEQEDEQH/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/APXxSGilNUZDaOlLSUAjzb4l+C4buzl1zT4SLuP5p0jH+sXu2PUfyqD4YeM2nRdE1GcM4H+jO3Uj+6T6ivT+Oh714z8R/CD6NfjXNKiZLRzul8oY8mTPXjoD+hoKPaTRXH+AvGMPiLTltp3C6hAoEinq4/vCuwoEAoPSikzSAKKDSZoAKaaU0UANB5xS0nQ5pcUDAim0+mHrQIKTNLSUAJ3pc03ml6UDFzRSA5pOaAFzQTSUGgAzSZoNJQAUGiikA0ikp1IaAI3HegHNOPIqMH"
}
```

+ Request Header :
  + Accept : ``application/json``
+ Response Body (Success) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 200,
    "status": "OK",
    "message": "User registered successfully",
    "path": "/auth/signup"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Email Address already in use!",
    "path": "/auth/signup"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Username already in use!",
    "path": "/auth/signup"
}
```

## Login

+ Endpoint : ``/auth/login``
+ HTTP Method : ``POST``
+ Request Body :

```json
{
    "username": "hendra",
    "password": "hendra"
}
```

+ Request Header :
  + Accept : ``application/json``
+ Response Body (Success) :

```json
{
    "name" : "hendra",
    "role" : "ROLE_USER",
    "sku_user" : "hend-cust-001",
    "token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 400,
    "status": "Bad Request",
    "message": "Invalid Request: Invalid user authentication or invalid request format",
    "path": "/auth/login"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 401,
    "status": "Unauthorized",
    "message": "username or password is wrong",
    "path": "/auth/login"
}
```
