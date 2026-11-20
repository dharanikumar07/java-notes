## 1. What is REST?

**REST (Representational State Transfer)** is an architectural style used to build web services that allow applications to communicate with each other over HTTP.

- REST allows communication between different applications.
    
- It uses HTTP methods to perform operations on resources.
    
- Data is commonly exchanged using JSON.
    
- REST APIs are stateless.
    

**Example:**

A Java application communicates with a React application through REST APIs.

```
React Application
       |
       | HTTP Request (JSON)
       v
Spring Boot REST API
       |
       v
    Database
       |
       v
Spring Boot REST API
       |
       | HTTP Response (JSON)
       v
React Application
```

### What is a Resource?

A resource is any data or object that an API manages.

Examples:

- Student
    
- Employee
    
- Product
    
- Customer
    

Each resource is identified using a URL.

```
/api/students
/api/employees
/api/products
```

### REST API vs Traditional MVC

|Traditional MVC|REST API|
|---|---|
|Returns HTML pages|Returns data (usually JSON)|
|Uses `@Controller`|Uses `@RestController`|
|Used for server-side views|Used for application communication|
|Example: Thymeleaf|Example: React, Angular, Mobile apps|

## 2. HTTP Methods

HTTP methods specify what operation should be performed on a resource.

|Method|Purpose|Example|
|---|---|---|
|GET|Retrieve data|Get all students|
|POST|Create new data|Add a student|
|PUT|Update existing data|Update a student|
|PATCH|Partially update data|Update student email|
|DELETE|Delete data|Delete a student|

### Examples

**GET**

```
GET /api/students
```

Retrieves all students.

**POST**

```
POST /api/students
```

Creates a new student.

**PUT**

```
PUT /api/students/101
```

Updates the student with ID 101.

**DELETE**

```
DELETE /api/students/101
```

Deletes the student with ID 101.

### Important Interview Concepts

**1. Safe Method**

A safe method does not modify server resources.

Example: GET.

**2. Idempotent Method**

Making the same request multiple times produces the same intended server state.

- GET – Idempotent
    
- PUT – Idempotent
    
- DELETE – Idempotent
    
- POST – Generally not idempotent
    

**3. Stateless**

The server does not maintain client session state between independent REST requests. Each request must contain the information needed to process it.

## 3. REST API Request and Response

A REST API works using a request-response mechanism.

**Request:**

```
GET /api/students/101
```

**Response:**

```
{
  "id": 101,
  "name": "Arun",
  "department": "Java"
}
```

JSON (JavaScript Object Notation) is a common format used to exchange data between applications.

### Common HTTP Status Codes

|Status Code|Meaning|
|---|---|
|200|OK – Request successful|
|201|Created – Resource created|
|204|No Content – Successful, no response body|
|400|Bad Request|
|401|Unauthorized|
|403|Forbidden|
|404|Not Found|
|500|Internal Server Error|

### Remember

- REST is an architectural style, not a programming language or framework.
    
- Spring Boot provides support for building REST APIs.
    
- HTTP methods define the operation.
    
- URLs identify resources.
    
- JSON is commonly used for data exchange.
    
- REST APIs are generally stateless.