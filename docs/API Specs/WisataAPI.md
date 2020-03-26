# Wisata API

## Get All Wisata

+ Endpoint : ``/wisata/``
+ HTTP Method : `GET`
+ Request Header :
  + Accept : `application/json`
+ Response Body (Success) :

```json
{
    "code": 200,
    "status": "OK",
    "data": [{
        "sku": "hend-para-batu-001",
        "name": "Batu gantung",
        "title": "Tempat wisata batu gantung",
        "description": "Tempat wisata ini sangat bagus, berlokasi di parapat",
        "image": "asdadzxcasdasd.png",
        "address": "jl.parapat",
        "createdBy" : "admi-josh-001",
        "price" : "15000",
        "hoursOpen": {
                    "Monday": ["8AM", "10PM"],
                    "Tuesday": ["8AM", "10PM"],
                    "Wednesday": ["8AM", "10PM"],
                    "Thursday": ["8AM", "10PM"],
                    "Friday": ["8AM", "10PM"],
                    "Saturday": ["8AM", "10PM"],
                    "Sunday": ["8AM", "10PM"]
                },
        "status": "active"
    }, {
     "sku": "hend-bali-lumb-001",
     "name": "Lumban bulbul pantai 1",
     "title": "Tempat wisata pantai 1 lumban bulbul",
     "description": "Tempat wisata ini sangat bagus, berlokasi di balige",
     "image": "vjdkdfwwdzxcasdassadzxcd.png",
     "address": "jl.baige",
     "createdBy" : "admi-hend-001",
     "price" : "20000",
     "hoursOpen": {
                     "Monday": ["8AM", "10PM"],
                     "Tuesday": ["8AM", "10PM"],
                     "Wednesday": ["8AM", "10PM"],
                     "Thursday": ["8AM", "10PM"],
                     "Friday": ["8AM", "10PM"],
                     "Saturday": ["8AM", "10PM"],
                     "Sunday": ["8AM", "10PM"]
                  },
     "status": "active"
    }, {
        "sku": "hend-bali-lumb-002",
         "name": "Lumban bulbul pantai 2",
         "title": "Tempat wisata pantai 2 lumban bulbul",
         "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
         "image": "cvdafzxsqzxcasdasd.png",
         "address": "jl.balige",
         "createdBy" : "admi-josh-001",
         "price" : "10000",
         "hoursOpen": {
                      "Monday": ["8AM", "10PM"],
                      "Tuesday": ["8AM", "10PM"],
                      "Wednesday": ["8AM", "10PM"],
                      "Thursday": ["8AM", "10PM"],
                      "Friday": ["8AM", "10PM"],
                      "Saturday": ["8AM", "10PM"],
                      "Sunday": ["8AM", "10PM"]
                      },
         "status": "active"
    }]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Data not found",
    "message": "Message: There is no data wisata"
}
```

## Get Wisata By sku

+ Endpoint : ``/wisata/{sku}``
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
        "sku": "hend-bali-lumb-002",
        "name": "Lumban bulbul pantai 2",
        "title": "Tempat wisata pantai 2 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
        "image": "cvdafzxsqzxcasdasd.png",
        "address": "jl.balige",
        "createdBy" : "admi-josh-001",
        "price" : "10000",
        "hoursOpen": {
                     "Monday": ["8AM", "10PM"],
                     "Tuesday": ["8AM", "10PM"],
                     "Wednesday": ["8AM", "10PM"],
                     "Thursday": ["8AM", "10PM"],
                     "Friday": ["8AM", "10PM"],
                     "Saturday": ["8AM", "10PM"],
                     "Sunday": ["8AM", "10PM"]
                     },
        "status": "active"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find wisata with that sku."
}
```

## Add new wisata

+ Endpoint : ``/wisata/add``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Lumban bulbul pantai 2",
    "title": "Tempat wisata pantai 2 lumban bulbul",
    "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
    "image": "cvdafzxsqzxcasdasd.png",
    "address": "jl.balige",
    "createdBy" : "admi-josh-001",
    "price" : "10000",
    "hoursOpen": {
                 "Monday": ["8AM", "10PM"],
                 "Tuesday": ["8AM", "10PM"],
                 "Wednesday": ["8AM", "10PM"],
                 "Thursday": ["8AM", "10PM"],
                 "Friday": ["8AM", "10PM"],
                 "Saturday": ["8AM", "10PM"],
                 "Sunday": ["8AM", "10PM"]
                 }  
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
    "message" : "Tambah data wisata sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid image format. Image must be .PNG/.JPG/.JPEG "
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access."
}
```

## Edit Wisata by Sku

+ Endpoint : ``/wisata/edit/{sku}``
+ HTTP Method : `PUT`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "name": "Lumban bulbul pantai 3",
    "title": "Tempat wisata pantai 3 lumban bulbul",
    "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
    "image": "cvdafzxsqzxcasdasd.png",
    "address": "jl.balige",
    "createdBy" : "admi-josh-001",
    "price" : "10000",
    "hoursOpen": {
                 "Monday": ["8AM", "10PM"],
                 "Tuesday": ["8AM", "10PM"],
                 "Wednesday": ["8AM", "10PM"],
                 "Thursday": ["8AM", "10PM"],
                 "Friday": ["8AM", "10PM"],
                 "Saturday": ["8AM", "10PM"],
                 "Sunday": ["8AM", "10PM"]
                 }  
}
```

+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
+ Response Body (Success) :

```json
{
    "name": "Lumban bulbul pantai 3",
    "title": "Tempat wisata pantai 3 lumban bulbul",
    "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
    "image": "cvdafzxsqzxcasdasd.png",
    "address": "jl.balige",
    "createdBy" : "admi-josh-001",
    "price" : "10000",
    "hoursOpen": {
                 "Monday": ["8AM", "10PM"],
                 "Tuesday": ["8AM", "10PM"],
                 "Wednesday": ["8AM", "10PM"],
                 "Thursday": ["8AM", "10PM"],
                 "Friday": ["8AM", "10PM"],
                 "Saturday": ["8AM", "10PM"],
                 "Sunday": ["8AM", "10PM"]
                 }  
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid image format. Image must be .PNG/.JPG/.JPEG "
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access."
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find wisata with that sku."
}
```

## Delete Wisata by Sku

+ Endpoint : ``/wisata/delete/{sku}``
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
    "message": "Invalid Request: You are not allowed to access."
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot delete wisata with that sku."
}
```
