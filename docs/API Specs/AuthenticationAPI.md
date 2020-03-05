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
    "role" : "Merchant",
    "status" : "active"
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

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: Invalid user authentication or Unauthorized",
    "path": "/users"
}
```
