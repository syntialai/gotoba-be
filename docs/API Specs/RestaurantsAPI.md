# Restaurant

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
        "sku": "jenn_rest_001",
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
        "status": "active"
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
