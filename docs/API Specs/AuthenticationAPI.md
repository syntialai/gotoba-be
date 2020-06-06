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
    "role" : "Merchant"
}
```

+ Request Header :
  + Accept : ``application/json``
+ Response Body (Success) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code" : 200,
    "status" : "OK",
    "message" : "User registered successfully"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Email Address already in use!"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Username already in use!"
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
    "message": "Invalid Request: Invalid user authentication or invalid request format"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "code": 401,
    "status": "Unauthorized",
    "message": "username or password is wrong"
}
```
