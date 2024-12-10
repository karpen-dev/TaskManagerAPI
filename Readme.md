# Simple todo system

Get all todos:
```http request
GET http://localhost:8080/api/todos
```

Create new todo:
```http request
POST http://localhost:8080/api/todos
Content-Type: Application/json

{
    "title": "Learn Kotlin",
    "completed": false
}
```

Delete todo:
```http request
DELETE http://localhost:8080/api/todos/{id}
```