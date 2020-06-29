# Ticket API

## Find Near Location For Wisata

+ Endpoint : ``/nearBy/{longitude}/{lat}``
+ HTTP Method : `GET`
+ Path Variable :
  + merchantSku
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
           "longitude" : "25.905354",
           "latitude" : "45.191548",
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
           "longitude" : "25.905354",
           "latitude" : "45.191548",
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
           "longitude" : "25.905354",
           "latitude" : "45.191548",
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
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/ticket/merchant/{merchantSku}"
}
```

```json
{
    "timestamp": "2016-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find merchant with sku ABC.",
    "path": "/ticket/merchant/{merchantSku}"
}
```
