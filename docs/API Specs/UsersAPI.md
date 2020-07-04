# Users API (For Customers)

## Get All Users

+ Endpoint : ``/user/``
+ HTTP Method : `GET`
+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "sku" : "hend_merc_001",
        "nickname" : "hendra",
        "username" : "hendra",
        "email" : "hendra@gmail.com",
        "image": "",
        "role" : "Merchant",
        "status" : "active"
    },
    {
        "sku" : "sima_cust_001",
        "nickname" : "simangunsong",
        "username" : "simangunsong",
        "email" : "simangunsong@gmail.com",
        "image": "",
        "role" : "Customer",
        "status" : "active"
    },
    {
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "image": "",
        "role" : "Merchant",
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
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/"
}
```

## Get User by Sku

+ Endpoint : ``/user/{sku}``
+ HTTP Method : `GET`
+ Path Variable :
  + sku
+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer xkzndDiskwDkLSksLIlOQWJYsNkskdHXkjsLwJiwdncxKnsdWyTDidkjBCykjsbYcjuLsjcnqpsiLxmzjcJsiskdczmJkskwoTwGiqUScsdaJsOksCjskIwkLkskdjICksmlCKskwQpeikzSkoeiPlsqoIdukNClskeiKCjrjvnMCaoziee`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
         "sku" : "josh_merc_001",
         "nickname" : "joshua",
         "username" : "joshua",
         "email" : "joshua@gmail.com",
         "password" : "joshua",
         "image": "",
         "role" : "Merchant",
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
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/{sku}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that sku.",
    "path": "/user/{sku}"
}
```

## Get Users Active by Status

+ Endpoint : ``/user/active``
+ HTTP Method : `GET`
+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer xkzndDiskwDkLSksLIlOQWJYsNkskdHXkjsLwJiwdncxKnsdWyTDidkjBCykjsbYcjuLsjcnqpsiLxmzjcJsiskdczmJkskwoTwGiqUScsdaJsOksCjskIwkLkskdjICksmlCKskwQpeikzSkoeiPlsqoIdukNClskeiKCjrjvnMCaoziee`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
         "sku" : "josh_merc_001",
         "nickname" : "joshua",
         "username" : "joshua",
         "email" : "joshua@gmail.com",
         "image": "",
         "role" : "Merchant",
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
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/active"
}
```

## Get User Blocked by Status

+ Endpoint : ``/users/blocked``
+ HTTP Method : `GET`
+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer xkzndDiskwDkLSksLIlOQWJYsNkskdHXkjsLwJiwdncxKnsdWyTDidkjBCykjsbYcjuLsjcnqpsiLxmzjcJsiskdczmJkskwoTwGiqUScsdaJsOksCjskIwkLkskdjICksmlCKskwQpeikzSkoeiPlsqoIdukNClskeiKCjrjvnMCaoziee`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
         "sku" : "josh_merc_001",
         "nickname" : "joshua",
         "username" : "joshua",
         "email" : "joshua@gmail.com",
         "image": "",
         "role" : "Merchant",
         "status" : "blocked"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/active"
}
```

## Get User by Username

+ Endpoint : ``/user/username/{username}``
+ HTTP Method : `GET`
+ Path Variable :
  + username
+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer xkzndDiskwDkLSksLIlOQWJYsNkskdHXkjsLwJiwdncxKnsdWyTDidkjBCykjsbYcjuLsjcnqpsiLxmzjcJsiskdczmJkskwoTwGiqUScsdaJsOksCjskIwkLkskdjICksmlCKskwQpeikzSkoeiPlsqoIdukNClskeiKCjrjvnMCaoziee`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
         "sku" : "josh_merc_001",
         "nickname" : "joshua",
         "username" : "joshua",
         "email" : "joshua@gmail.com",
         "image": "",
         "role" : "Merchant",
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
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/username/{username}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that username.",
    "path": "/user/username/{username}"
}
```

## Edit User by Sku

+ Endpoint : ``/user/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "nickname" : "hendra",
    "username" : "hendra",
    "email" : "hendra@gmail.com",
    "image": ""
}
```

+ Request Header :
  + Accept: `application/json`
  + Authorization : `Bearer xkzndDiskwDkLSksLIlOQWJYsNkskdHXkjsLwJiwdncxKnsdWyTDidkjBCykjsbYcjuLsjcnqpsiLxmzjcJsiskdczmJkskwoTwGiqUScsdaJsOksCjskIwkLkskdjICksmlCKskwQpeikzSkoeiPlsqoIdukNClskeiKCjrjvnMCaoziee`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": {
         "sku" : "josh_merc_001",
         "nickname" : "joshua",
         "username" : "joshua",
         "email" : "joshua@gmail.com",
         "image": "",
         "role" : "Merchant",
         "status" : "active"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Email Address already in use!",
    "path": "/user/edit/{sku}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/user/edit/{sku}"
}
```
