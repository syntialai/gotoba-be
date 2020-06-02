# Restaurant API (For Merchant)

## Get All Restaurant

+ Endpoint : ``/restaurant``
+ HTTP Method : `GET`
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "sku": "jenn_rest_001_001",
        "name": "Jenny's Restaurant",
        "bistroType": "Salad Shop",
        "location": "Samosir Regency, North Sumatra",
        "rating": 5.0,
        "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
        "hoursOpen": {
            "Monday": ["8AM", "10PM"],
            "Tuesday": ["8AM", "10PM"],
            "Wednesday": ["8AM", "10PM"],
            "Thursday": ["8AM", "10PM"],
            "Friday": ["8AM", "10PM"],
            "Saturday": ["8AM", "10PM"],
            "Sunday": ["8AM", "10PM"]
        },
        "phone": "+62813 9791 4229",
        "status": "active",
        "merchantSku": "josh_merc_001"
    }, {
        "sku": "jenn_rest_002_002",
        "name": "Jenny's Restaurant",
        "bistroType": "Salad Shop",
        "location": "Samosir Regency, North Sumatra",
        "rating": 5.0,
        "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
        "hoursOpen": {
            "Monday": ["8AM", "10PM"],
            "Tuesday": ["8AM", "10PM"],
            "Wednesday": ["8AM", "10PM"],
            "Thursday": ["8AM", "10PM"],
            "Friday": ["8AM", "10PM"],
            "Saturday": ["8AM", "10PM"],
            "Sunday": ["8AM", "10PM"]
        },
        "phone": "+62813 9791 4229",
        "status": "active",
        "merchantSku": "josh_merc_002"
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
    "path": "/restaurant"
}
```

## Get Restaurant by Sku

+ Endpoint : ``/restaurant/{sku}``
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
    "data": {
        "sku": "jenn_rest_001_001",
        "name": "Jenny's Restaurant",
        "bistroType": "Salad Shop",
        "location": "Samosir Regency, North Sumatra",
        "rating": 5.0,
        "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
        "hoursOpen": {
            "Monday": ["8AM", "10PM"],
            "Tuesday": ["8AM", "10PM"],
            "Wednesday": ["8AM", "10PM"],
            "Thursday": ["8AM", "10PM"],
            "Friday": ["8AM", "10PM"],
            "Saturday": ["8AM", "10PM"],
            "Sunday": ["8AM", "10PM"]
        },
        "phone": "+62813 9791 4229",
        "status": "active",
        "merchantSku": "josh_merc_001"
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
    "path": "/restaurant/{sku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find restaurant with sku MER-123.",
    "path": "/restaurant/{sku}"
}
```

## Add new Restaurant

+ Endpoint : ``/restaurant/add``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Jenny's Restaurant",
    "bistroType": "Salad Shop",
    "location": "Samosir Regency, North Sumatra",
    "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
    "hoursOpen": {
        "Monday": ["8AM", "10PM"],
        "Tuesday": ["8AM", "10PM"],
        "Wednesday": ["8AM", "10PM"],
        "Thursday": ["8AM", "10PM"],
        "Friday": ["8AM", "10PM"],
        "Saturday": ["8AM", "10PM"],
        "Sunday": ["8AM", "10PM"]
    },
    "phone": "+62813 9791 4229"
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
        "sku": "jenn_rest_001_001",
        "name": "Jenny's Restaurant",
        "bistroType": "Salad Shop",
        "location": "Samosir Regency, North Sumatra",
        "rating": 5.0,
        "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
        "hoursOpen": {
            "Monday": ["8AM", "10PM"],
            "Tuesday": ["8AM", "10PM"],
            "Wednesday": ["8AM", "10PM"],
            "Thursday": ["8AM", "10PM"],
            "Friday": ["8AM", "10PM"],
            "Saturday": ["8AM", "10PM"],
            "Sunday": ["8AM", "10PM"]
        },
        "phone": "+62813 9791 4229",
        "status": "active",
        "merchantSku": "josh_merc_001"
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
    "path": "/restaurant/add"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/add"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find restaurant with sku {sku}.",
    "path": "/restaurant/add"
}
```

## Edit Restaurant by Sku

+ Endpoint : ``/restaurant/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Jenny's Restaurant",
    "bistroType": "Salad Shop",
    "location": "Samosir Regency, North Sumatra",
    "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
    "hoursOpen": {
        "Monday": ["8AM", "10PM"],
        "Tuesday": ["8AM", "10PM"],
        "Wednesday": ["8AM", "10PM"],
        "Thursday": ["8AM", "10PM"],
        "Friday": ["8AM", "10PM"],
        "Saturday": ["8AM", "10PM"],
        "Sunday": ["8AM", "10PM"]
    },
    "phone": "+62813 9791 4229"
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
        "sku": "jenn_rest_001_001",
        "name": "Jenny's Restaurant",
        "bistroType": "Salad Shop",
        "location": "Samosir Regency, North Sumatra",
        "rating": 5.0,
        "address": "Jl. Lkr. Tuktuk, Tuktuk Siadong, Simanindo, Kabupaten Samosir, Sumatera Utara 22395",
        "hoursOpen": {
            "Monday": ["8AM", "10PM"],
            "Tuesday": ["8AM", "10PM"],
            "Wednesday": ["8AM", "10PM"],
            "Thursday": ["8AM", "10PM"],
            "Friday": ["8AM", "10PM"],
            "Saturday": ["8AM", "10PM"],
            "Sunday": ["8AM", "10PM"]
        },
        "phone": "+6281397914229",
        "status": "active",
        "merchantSku": "josh_merc_001"
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
    "path": "/restaurant/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find restaurant with sku {sku}.",
    "path": "/restaurant/edit/{sku}"
}
```

## Get All Menus by Restaurant Sku

+ Endpoint : ``/restaurant/{sku}/menu/``
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
        "id":1,
        "name": "Cumi Goreng",
        "image": "asduqwyieuhxmz.png",
        "category" : "Food",
        "price": "50000",
        "status": "1",
        "restaurantSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
    }, {
       "id":2,
       "name": "Air Kelapa",
       "image": "caxjkhsiayieuhxmz.png",
       "category" : "Drinks",
       "price": "10000",
       "status": "1",
       "restaurantSku": "josh_rest_001_001",
       "merchantSku": "josh_merc_001"
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
    "path": "/restaurant/{sku}/menu/"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with that restaurant sku. ",
    "path": "/restaurant/{sku}/menu/"
}
```

## Get Restaurant Menu by Id

+ Endpoint : ``/restaurant/menu/{id}``
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
        "id":1,
        "name": "Cumi Goreng",
        "picture": "asduqwyieuhxmz.png",
        "category" : "Food",
        "harga": "50000",
        "status": "1",
        "restaurantSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
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
    "path": "/restaurant/menu/{id}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with that skuRestaurant. ",
    "path": "/restaurant/menu/{id}"
}
```

## Add new Restaurant Menu by Restaurant Sku

+ Endpoint : ``/restaurant/{sku}/menu/add``
+ HTTP Method : `POST`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Cumi Goreng",
    "picture": "asduqwyieuhxmz.png",
    "category" : "Food",
    "harga": "50000",
    "status": "1",
    "restaurantSku": "jenn_rest_001_001",
    "merchantSku": "josh_merc_001"
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
        "id":1,
        "name": "Cumi Goreng",
        "picture": "asduqwyieuhxmz.png",
        "category" : "Food",
        "harga": "50000",
        "status": "1",
        "restaurantSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid picture format, picture must be .png/.jpg/,.jpeg !",
    "path": "/restaurant/{sku}/menu/add"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/{sku}/menu/add"
}
```

## Edit Restaurant Menu by Id and by Restaurant Sku

+ Endpoint : `/restaurant/{sku}/menu/edit/{id}`
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
  + id
+ Request Body :

```json
{
    "name": "Cumi Goreng",
    "image": "asduqwyieuhxmz.png",
    "category" : "Food",
    "price": "45000",
    "status": "1",
    "restaurantSku": "jenn_rest_001_001",
    "merchantSku": "josh_merc_001"
}
```

+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "code": 201,
    "status": "OK",
    "data": {
        "id": 1,
        "name": "Cumi Goreng",
        "image": "asduqwyieuhxmz.png",
        "category" : "Food",
        "price": "45000",
        "status": "1",
        "restaurantSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
    },
    "message" :  "Update Sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid picture format, picture must be .png/.jpg/,.jpeg !",
    "path": "/restaurant/{sku}/menu/edit/{id}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/{sku}/menu/edit/{id}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with taht id. ",
    "path": "/restaurant/{sku}/menu/edit/{id}"
}
```

## Delete Restaurant Menu by Id and by Restaurant Sku

+ Endpoint : ``/restaurant/{sku}/menu/delete/{id}``
+ HTTP Method : `DELETE`
+ Path Variable :
  + sku
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
        "name": "Cumi Goreng",
        "image": "asduqwyieuhxmz.png",
        "category" : "Food",
        "price": "45000",
        "status": "2",
        "restaurantSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
    },
    "message" :  "Delete Sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/menu/delete/{id}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with that id. ",
    "path": "/restaurant/menu/delete/{id}"
}
```
