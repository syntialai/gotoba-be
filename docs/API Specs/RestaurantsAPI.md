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

## Add new Restaurant by Sku

+ Endpoint : ``/restaurant/{sku}``
+ HTTP Method : `POST`
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
    "path": "/restaurant/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find restaurant with sku {sku}.",
    "path": "/restaurant/{sku}"
}
```

## Edit Restaurant by Sku

+ Endpoint : `/restaurant/{sku}`
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
    "path": "/restaurant/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find restaurant with sku {sku}.",
    "path": "/restaurant/{sku}"
}
```


## Add new foods/drinks

+ Endpoint : `/restaurant/addMenu`
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Cumi Goreng",
    "picture": "asduqwyieuhxmz.png",
    "category" : "Food",
    "harga": "50000",
    "status": "1",
    "restoranSku": "jenn_rest_001_001",
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
        "restoranSku": "jenn_rest_001_001",
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
    "path": "/restaurant/addMenu"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/addMenu"
}
```

## Edit new foods/drinks

+ Endpoint : `/restaurant/editMenu/{id}`
+ HTTP Method : `PUT`
+ Path Variable :
  + id
+ Request Body :

```json
{
    "name": "Cumi Goreng",
    "picture": "asduqwyieuhxmz.png",
    "category" : "Food",
    "harga": "45000",
    "status": "1",
    "restoranSku": "jenn_rest_001_001",
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
        "picture": "asduqwyieuhxmz.png",
        "category" : "Food",
        "harga": "45000",
        "status": "1",
        "restoranSku": "jenn_rest_001_001",
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
    "path": "/restaurant/editMenu/{id}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/restaurant/editMenu/{id}"
}
```
```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with taht id. ",
    "path": "/restaurant/editMenu/{id}"
}
```
## Delete foods/drinks by id

+ Endpoint : `/restaurant/menu/delete/{id}`
+ HTTP Method : `PUT`
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
        "id": 1,
        "name": "Cumi Goreng",
        "picture": "asduqwyieuhxmz.png",
        "category" : "Food",
        "harga": "45000",
        "status": "2",
        "restoranSku": "jenn_rest_001_001",
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


## Get All Menu By skuRestaurants

+ Endpoint : ``/restaurant/menu/byRestaurants/{skuRestaurants}``
+ HTTP Method : `GET`
+ Path Variable :
  + skuRestaurants
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
        "picture": "asduqwyieuhxmz.png",
        "category" : "Food",
        "harga": "50000",
        "status": "1",
        "restoranSku": "jenn_rest_001_001",
        "merchantSku": "josh_merc_001"
    }, {
       "id":2,
       "name": "Air Kelapa",
       "picture": "caxjkhsiayieuhxmz.png",
       "category" : "Drinks",
       "harga": "10000",
       "status": "1",
       "restoranSku": "josh_rest_001_001",
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
    "path": "/restaurant/menu/byRestaurants/{skuRestaurants}"
}
```
```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find menu with that skuRestaurant. ",
    "path": "/restaurant/menu/byRestaurants/{skuRestaurants}"
}
```

## Get Menu By Id

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
        "restoranSku": "jenn_rest_001_001",
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
