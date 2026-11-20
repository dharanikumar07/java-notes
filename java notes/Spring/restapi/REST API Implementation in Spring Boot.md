
## 1. @RestController

`@RestController` is used to create REST API controllers in Spring Boot.

It is a combination of:

- `@Controller`
    
- `@ResponseBody`
    

**Purpose:**

It tells Spring that the methods should return response data directly instead of resolving a view page.

```
@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(101, "Arun");
    }
}
```

Spring Boot automatically converts the returned Java object into JSON using an HTTP message converter (commonly Jackson).

**Response:**

```
{
  "id": 101,
  "name": "Arun"
}
```

## 2. @PathVariable

`@PathVariable` is used to extract a value from the URL path.

**Example:**

```
GET /students/101
```

Here, `101` is the student ID.

```
@GetMapping("/students/{id}")
public String getStudent(@PathVariable int id) {
    return "Student ID: " + id;
}
```

**Output:**

```
Student ID: 101
```

Remember: `@PathVariable` gets values from the URL path.

## 3. @RequestBody

`@RequestBody` is used to receive JSON data from the HTTP request body and convert it into a Java object.

**Client sends:**

```
{
  "id": 101,
  "name": "Arun"
}
```

**Spring Boot Controller:**

```
@PostMapping("/students")
public Student addStudent(@RequestBody Student student) {
    return student;
}
```

Spring automatically converts the incoming JSON into a Java object.

Remember:

- `@PathVariable` → Gets data from URL.
    
- `@RequestParam` → Gets data from query parameters.
    
- `@RequestBody` → Gets data from request body.
    

## 4. @PutMapping and @DeleteMapping

### @PutMapping

Used to update an existing resource.

```
@PutMapping("/students/{id}")
public String updateStudent(
        @PathVariable int id,
        @RequestBody Student student) {

    return "Student " + id + " updated";
}
```

Request:

```
PUT /students/101
```

The request body contains the updated student information.

### @DeleteMapping

Used to delete an existing resource.

```
@DeleteMapping("/students/{id}")
public String deleteStudent(@PathVariable int id) {
    return "Student " + id + " deleted";
}
```

Request:

```
DELETE /students/101
```

### Quick Difference

|Annotation|Purpose|
|---|---|
|@GetMapping|Retrieve data|
|@PostMapping|Create data|
|@PutMapping|Update data|
|@PatchMapping|Partially update data|
|@DeleteMapping|Delete data|

Note: These examples demonstrate controller mappings. Actual database operations must be implemented separately.

## 5. Content Negotiation

Content negotiation is the process of deciding the response format based on what the client can accept.

A client can request a particular response format using the HTTP `Accept` header.

**Example 1: Client requests JSON**

```
GET /students
Accept: application/json
```

Response:

```
[
  {
    "id": 101,
    "name": "Arun"
  }
]
```

**Example 2: Client requests XML**

```
GET /students
Accept: application/xml
```

Response (if XML conversion is configured):

```
<student>
    <id>101</id>
    <name>Arun</name>
</student>
```

### Important Headers

|Header|Purpose|
|---|---|
|Accept|Specifies the response format the client wants|
|Content-Type|Specifies the format of the request body or response body|

### Remember

- `Accept` → What format does the client want?
    
- `Content-Type` → What format is the data being sent in?
    

Spring Boot uses HTTP message converters to convert Java objects into formats such as JSON and XML.

For XML support, an appropriate XML message converter and dependency must be configured.

## Complete REST API Flow

```
Client (React / Postman)
          |
          | HTTP Request
          v
   @RestController
          |
          v
    Service Layer
          |
          v
   Repository Layer
          |
          v
       Database
          |
          v
   Repository Layer
          |
          v
    Service Layer
          |
          v
   @RestController
          |
          | JSON Response
          v
        Client
```

### Interview Quick Revision

1. What is `@RestController`?
    
    - Combination of `@Controller` and `@ResponseBody`.
        
2. What is `@PathVariable`?
    
    - Extracts values from the URL path.
        
3. What is `@RequestBody`?
    
    - Converts incoming JSON request data into a Java object.
        
4. Difference between PUT and PATCH?
    
    - PUT generally replaces the resource; PATCH partially updates it.
        
5. What is content negotiation?
    
    - Selecting a suitable response format based on the client's `Accept` header.
        
6. Difference between Accept and Content-Type?
    
    - Accept specifies the desired response format; Content-Type specifies the format of the data being sent.
        
7. How does Spring Boot convert Java objects into JSON?
    
    - Using HTTP message converters, commonly backed by Jackson.