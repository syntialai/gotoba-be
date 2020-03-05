# Users API (For Customers)

## Register

+ Endpoint : ``/users/register``
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
    "message" : "User register successfully"
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

## Get All Users 

+ Endpoint : ``/users/``
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
        "password" : "hendra77",
        "role" : "Merchant",
        "status" : "active"
    }, 
    {
        "sku" : "sima_cust_001",
        "nickname" : "simangunsong",
        "username" : "simangunsong",
        "email" : "simangunsong@gmail.com",
        "password" : "simangunsong12",
        "role" : "Customer",
        "status" : "active"
    },
    {
        "sku" : "josh_merc_001",
        "nickname" : "joshua",
        "username" : "joshua",
        "email" : "joshua@gmail.com",
        "password" : "joshua",
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
    "message": "Login required"
}
```

## Get Users (by sku)

+ Endpoint : ``/users/{user-sku}``
+ HTTP Method : `GET`
+ Path Variable : 
    + user-sku
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
    "message": "Login required"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that sku."
}
```


## Get Users Active (by status)

+ Endpoint : ``/users/active``
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
         "password" : "joshua",
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
    "message": "Login required"
}
```

## Get Users Blocked (by status)

+ Endpoint : ``/users/active``
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
         "password" : "joshua",
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
    "message": "Login required"
}
```

## Get Users (by username)

+ Endpoint : ``/users/update/{sku}``
+ HTTP Method : `GET`
+ Request Body : 
```json
{
    "nickname" : "joshua",
    "username" : "joshua",
    "email" : "joshua@gmail.com",
    "password" : "joshua",
    "role" : "Merchant",
    "status" : "blocked"
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
         "password" : "joshua",
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
    "message": "Login required"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that username."
}
```

## Edit Users (by sku)

+ Endpoint : ``/users/{sku}``
+ HTTP Method : `POST`
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
    "message": "Login required"
}
```
```json
{
	"timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that username."
}
```
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
    "message": "Username Address already in use!"
}
```
