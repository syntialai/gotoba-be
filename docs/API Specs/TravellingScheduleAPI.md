# Travelling Schedule API

## Get All My Schedule by User Sku

+ Endpoint : ``/schedule/{userSku}``
+ HTTP Method : `GET`
+ Path Variable :
  + userSku
+ Request Header :
  + Accept : `application/json`
  + Authorization : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1NTE5ODksImlhdCI6MTU2NjUzMzk4OX0.Kvx2VZkmckMexnTwK8A3vHSDar3J-K-dCrkJ2jmQtKdAWbw1dAjJ34WXCQXs-WO23OQPTqVF36E1STEhGZFZfg`
    
+ Response Body (Success) :

```json
{
    "data": [
                {
                    "sku": "d335ff95-5cb2-491d-be23-352fdcf92b07",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Ajibata.png",
                    "nama": "Ajibata",
                    "namaCamat": "Camat Ajibata"
                },
                {
                    "sku": "d1d675d8-8d30-47ba-8df5-9acd869c4814",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Balige.png",
                    "nama": "Balige",
                    "namaCamat": "Camat Balige"
                },
                {
                    "sku": "52fcd71b-2054-4f41-9e81-a8c9a0a7ace2",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "BonatuaLunasi.png",
                    "nama": "BonatuaLunasi",
                    "namaCamat": "Camat BonatuaLunasi"
                },
                {
                    "sku": "a8b300ad-c24d-4eab-bada-b180dcabb0ca",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Borbor.png",
                    "nama": "Borbor",
                    "namaCamat": "Camat Borbor"
                },
                {
                    "sku": "6164da9e-3c56-40aa-8d9e-8bb2d513affa",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Habinsaran.png",
                    "nama": "Habinsaran",
                    "namaCamat": "Camat Habinsaran"
                },
                {
                    "sku": "5ce502aa-770f-4e45-82e6-6e2cee780855",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "LumbanJulu.png",
                    "nama": "LumbanJulu",
                    "namaCamat": "Camat LumbanJulu"
                },
                {
                    "sku": "4260da8b-fb94-4b4e-a06b-f560f34b4166",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Nassau.png",
                    "nama": "Nassau",
                    "namaCamat": "Camat Nassau"
                },
                {
                    "sku": "07e519ba-7992-47cf-85b1-c2a1efa4a7ff",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Parmaksian.png",
                    "nama": "Parmaksian",
                    "namaCamat": "Camat Parmaksian"
                },
                {
                    "sku": "62a8b29f-5dee-4d1e-a143-f83db2175aed",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "PintuPohanMeranti.png",
                    "nama": "PintuPohanMeranti",
                    "namaCamat": "Camat PintuPohanMeranti"
                },
                {
                    "sku": "1da8342b-cba8-4f9a-ae8c-8607f9cf229d",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Porsea.png",
                    "nama": "Porsea",
                    "namaCamat": "Camat Porsea"
                },
                {
                    "sku": "d6ec898c-7488-4cb8-92a3-3aba3d4efb64",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "SiantarNarumonda.png",
                    "nama": "SiantarNarumonda",
                    "namaCamat": "Camat SiantarNarumonda"
                },
                {
                    "sku": "7306e5df-c3ad-4c16-aded-9144607ff4fb",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Sigumpar.png",
                    "nama": "Sigumpar",
                    "namaCamat": "Camat Sigumpar"
                },
                {
                    "sku": "6cf516b4-560e-4472-81fc-a81bb2cee44b",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Silaen.png",
                    "nama": "Silaen",
                    "namaCamat": "Camat Silaen"
                },
                {
                    "sku": "3e0a7d87-3e24-41fe-9bc2-6d8fc3186b4a",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Tampahan.png",
                    "nama": "Tampahan",
                    "namaCamat": "Camat Tampahan"
                },
                {
                    "sku": "08e5e0f8-5a64-4098-9b05-986793f6720b",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Uluan.png",
                    "nama": "Uluan",
                    "namaCamat": "Camat Uluan"
                },
                {
                    "sku": "baf3765a-fda4-4078-aae7-5fafe4a7204f",
                    "fotoCamat": "profile.png",
                    "gambarKecamatan": "Laguboti.png",
                    "nama": "Laguboti",
                    "namaCamat": "Camat Laguboti"
                },
                {
                    "sku": "adff1568-bc3a-4e07-8828-4d2695420139",
                    "fotoCamat": "foto.png",
                    "gambarKecamatan": "adff1568-bc3a-4e07-8828-4d2695420139.png",
                    "nama": "MEdan",
                    "namaCamat": "MEdan"
                }
            ]
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 404,
    "error": "Data not found",
    "message": "Message: There is no schedule found in that user sku",
    "path": "/schedule/{userSku}"
}
```

```json
{
    "timestamp": "2020-11-15T22:55:40.110Z",
    "status": 401,
    "error": "Unauthorized",
    "message": "Invalid Request: You are not allowed to access.",
    "path": "/schedule/{userSku}"
}
```

## Add Schedule by Sku

+ Endpoint : ``/schedule/{userSku}/add``
+ HTTP Method : `POST`
+ Path Variable :
  + sku
+ Request Body :

```json
{
    "title": "Libur musim panas",
    "description": "Liburan musim panas di daerah danau toba",
    "date" : "2015-11-13 13:30:21",
    "endDate" : "2015-11-14 13:30:21",
    "vacationDestination" : "hend-para-batu-001"
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
    "message": "Tambah schedule sukses"
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/{userSku}/add"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find User with that sku.",
    "path": "/schedule/{userSku}/add"
}
```

## Get Schedule by Id

+ Endpoint : ``/schedule/detail/{id}``
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
        "id": 1,
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "hend-para-batu-001",
        "userSku": "Josh-Cust-001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/{id}"
}
``` 

## Edit Schedule by Id

+ Endpoint : ``/schedule/edit/{id}``
+ HTTP Method : `PUT`
+ Path Variable :
  + id
+ Request Body :

```json
{
    "title": "Libur musim panas",
    "description": "Liburan musim panas di daerah danau toba",
    "date" : "2015-11-13 13:30:21",
    "endDate" : "2015-11-14 13:30:21",
    "vacationDestination" : "hend-para-batu-001"
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
        "id": 1,
        "title": "Libur musim panas",
        "description": "Liburan musim panas di daerah danau toba",
        "date": "2015-11-13 13:30:21",
        "endDate": "2015-11-14 13:30:21",
        "vacationDestination": "hend-para-batu-001",
        "userSku": "Josh-Cust-001"
    }
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/edit/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/edit/{id}"
}
```

## Delete Schedule by Id

+ Endpoint : ``/schedule/delete/{id}``
+ HTTP Method : `DELETE`
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
      "message": "Schedule deleted with id 1."
}
```

+ Response Body (Fail) :

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Login required",
    "path": "/schedule/delete/{id}"
}
```

```json
{
    "timestamp": "2019-08-23T04:22:26.690+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid Request: Cannot find Schedule with that id.",
    "path": "/schedule/delete/{id}"
}
```
