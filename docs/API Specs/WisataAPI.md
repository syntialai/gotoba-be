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
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.parapat",
        "createdBy" : "admi-josh-001",
        "price" : "15000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
        },
        "status": "active"
    }, {
        "sku": "hend-bali-lumb-001",
        "name": "Lumban bulbul pantai 1",
        "title": "Tempat wisata pantai 1 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di balige",
        "image": "vjdkdfwwdzxcasdassadzxcd.png",
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.baige",
        "createdBy" : "admi-hend-001",
        "price" : "20000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
        },
        "status": "active"
    }, {
        "sku": "hend-bali-lumb-002",
        "name": "Lumban bulbul pantai 2",
        "title": "Tempat wisata pantai 2 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
        "image": "cvdafzxsqzxcasdasd.png",
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.balige",
        "createdBy" : "admi-josh-001",
        "price" : "10000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
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
    "message": "Message: There is no data wisata",
    "path": "/wisata"
}
```



## Get All Wisata By Merchant Sku

+ Endpoint : ``/wisata/merchant/{merchantSku}``
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
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.parapat",
        "createdBy" : "admi-josh-001",
        "price" : "15000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
        },
        "status": "active"
    }, {
        "sku": "hend-bali-lumb-001",
        "name": "Lumban bulbul pantai 1",
        "title": "Tempat wisata pantai 1 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di balige",
        "image": "vjdkdfwwdzxcasdassadzxcd.png",
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.baige",
        "createdBy" : "admi-hend-001",
        "price" : "20000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
        },
        "status": "active"
    }, {
        "sku": "hend-bali-lumb-002",
        "name": "Lumban bulbul pantai 2",
        "title": "Tempat wisata pantai 2 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
        "image": "cvdafzxsqzxcasdasd.png",
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.balige",
        "createdBy" : "admi-josh-001",
        "price" : "10000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
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
    "message": "Message: There is no data wisata",
    "path": "/wisata/merchant/{merchantSku}"
}
```

## Get Wisata by Sku

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
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.balige",
        "createdBy" : "admi-josh-001",
        "price" : "10000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
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
    "message": "Invalid Request: Cannot find wisata with that sku.",
    "path": "/wisata/{sku}"
}
```

## Add new Wisata

+ Endpoint : ``/wisata/add``
+ HTTP Method : `POST`
+ Request Body :

```json
{
    "name": "Lumban bulbul pantai 2",
    "title": "Tempat wisata pantai 2 lumban bulbul",
    "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
    "image": "base64,/9j/2wCEAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDIBCQkJDAsMGA0NGDIhHCEyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMv/AABEIAcwBzAMBIgACEQEDEQH/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/APXxSGilNUZDaOlLSUAjzb4l+C4buzl1zT4SLuP5p0jH+sXu2PUfyqD4YeM2nRdE1GcM4H+jO3Uj+6T6ivT+Oh714z8R/CD6NfjXNKiZLRzul8oY8mTPXjoD+hoKPaTRXH+AvGMPiLTltp3C6hAoEinq4/vCuwoEAoPSikzSAKKDSZoAKaaU0UANB5xS0nQ5pcUDAim0+mHrQIKTNLSUAJ3pc03ml6UDFzRSA5pOaAFzQTSUGgAzSZoNJQAUGiikA0ikp1IaAI3HegHNOPIqMH",
    "longitude" : 25.905354,
    "latitude" : 45.191548,
    "address": "jl.balige",
    "createdBy" : "admi-josh-001",
    "price" : 10000,
    "hoursOpen": {
        "monday": ["8AM", "10PM"],
        "tuesday": ["8AM", "10PM"],
        "wednesday": ["8AM", "10PM"],
        "thursday": ["8AM", "10PM"],
        "friday": ["8AM", "10PM"],
        "saturday": ["8AM", "10PM"],
        "sunday": ["8AM", "10PM"]
    }  
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
    "message" : "Tambah data wisata sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid image format. Image must be .PNG/.JPG/.JPEG",
    "path": "/wisata/add"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/wisata/add"
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
    "longitude" : 25.905354,
    "latitude" : 45.191548,
    "address": "jl.balige",
    "createdBy" : "admi-josh-001",
    "price" : "10000",
    "hoursOpen": {
         "monday": ["8AM", "10PM"],
        "tuesday": ["8AM", "10PM"],
        "wednesday": ["8AM", "10PM"],
        "thursday": ["8AM", "10PM"],
        "friday": ["8AM", "10PM"],
        "saturday": ["8AM", "10PM"],
        "sunday": ["8AM", "10PM"]
    },
    "status": "active"
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
        "name": "Lumban bulbul pantai 3",
        "title": "Tempat wisata pantai 3 lumban bulbul",
        "description": "Tempat wisata ini sangat bagus, berlokasi di lumban bulbul balige",
        "image": "base64,/9j/2wCEAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDIBCQkJDAsMGA0NGDIhHCEyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMv/AABEIAcwBzAMBIgACEQEDEQH/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIygQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/2gAMAwEAAhEDEQA/APXxSGilNUZDaOlLSUAjzb4l+C4buzl1zT4SLuP5p0jH+sXu2PUfyqD4YeM2nRdE1GcM4H+jO3Uj+6T6ivT+Oh714z8R/CD6NfjXNKiZLRzul8oY8mTPXjoD+hoKPaTRXH+AvGMPiLTltp3C6hAoEinq4/vCuwoEAoPSikzSAKKDSZoAKaaU0UANB5xS0nQ5pcUDAim0+mHrQIKTNLSUAJ3pc03ml6UDFzRSA5pOaAFzQTSUGgAzSZoNJQAUGiikA0ikp1IaAI3HegHNOPIqMH",
        "longitude" : 25.905354,
        "latitude" : 45.191548,
        "address": "jl.balige",
        "createdBy" : "admi-josh-001",
        "price" : "10000",
        "hoursOpen": {
            "monday": ["8AM", "10PM"],
            "tuesday": ["8AM", "10PM"],
            "wednesday": ["8AM", "10PM"],
            "thursday": ["8AM", "10PM"],
            "friday": ["8AM", "10PM"],
            "saturday": ["8AM", "10PM"],
            "sunday": ["8AM", "10PM"]
        },
        "status": "active"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 400,
    "error": "Bad Request",
    "message": "Invalid Request: Invalid image format. Image must be .PNG/.JPG/.JPEG",
    "path": "/wisata/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/wisata/edit/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find wisata with that sku.",
    "path": "/wisata/edit/{sku}"
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
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/wisata/delete/{sku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot delete wisata with that sku.",
    "path": "/wisata/delete/{sku}"
}
```
