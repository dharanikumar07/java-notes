## 1. What is Thymeleaf?

Thymeleaf is a server-side Java template engine used to create dynamic HTML pages.

It allows us to display backend Java data inside HTML pages.

**Simple meaning:**

- Controller sends data.
    
- Thymeleaf receives that data.
    
- HTML displays the data dynamically.
    

**Example:** Display a student's name received from the Controller.

## 2. Why Thymeleaf?

Without a template engine, displaying dynamic backend data in HTML becomes difficult.

Thymeleaf helps us:

- Display Java data in HTML.
    
- Use conditions and loops.
    
- Connect forms with Spring MVC.
    
- Separate presentation from business logic.
    
- Write natural HTML templates.
    

## 3. Required Dependency

Add Spring Boot Starter Thymeleaf dependency.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Spring Boot automatically configures Thymeleaf when the dependency is available.

## 4. Project Structure

```
src
 └── main
     ├── java
     │    └── controller
     │         └── HomeController.java
     │
     └── resources
          └── templates
               └── home.html
```

**Important:**

- Controller → Handles requests.
    
- templates → Stores Thymeleaf HTML pages.
    
- home.html → Thymeleaf view.
    

Default template location: `src/main/resources/templates/`

## 5. Creating a Controller

```
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("name", "John");

        return "home";
    }
}
```

**Explanation:**

- `@Controller` → Handles web requests.
    
- `Model` → Transfers data to the View.
    
- `addAttribute()` → Adds data to Model.
    
- `return "home"` → Opens home.html.
    

## 6. Creating a Thymeleaf Page

File: `home.html`

```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home</title>
</head>
<body>

    <h1 th:text="${name}">Default Name</h1>

</body>
</html>
```

**Important:**

- `xmlns:th` → Declares the Thymeleaf namespace.
    
- `th:text` → Displays dynamic text.
    
- `${name}` → Reads the value from the Model.
    

**Output:**

```
John
```

## 7. Important Thymeleaf Attributes

|Attribute|Purpose|
|---|---|
|`th:text`|Displays text|
|`th:if`|Displays element if condition is true|
|`th:each`|Loops through collection|
|`th:href`|Creates dynamic links|
|`th:action`|Sets form action URL|
|`th:value`|Sets input value|
|`th:object`|Binds form to an object|
|`th:field`|Binds form fields to object properties|

### Example: Condition

```
<p th:if="${age >= 18}">
    Eligible
</p>
```

Displays the paragraph only when the condition is true.

### Example: Loop

```
<ul>
    <li th:each="student : ${students}"
        th:text="${student.name}">
    </li>
</ul>
```

Displays each student's name from the students collection.

## 8. Thymeleaf vs JSP

|JSP|Thymeleaf|
|---|---|
|Java Server Pages|Java Template Engine|
|`.jsp`|`.html`|
|Usually configured separately in Spring Boot|Auto-configured with starter|
|Requires JSP-specific setup|Works naturally with HTML|
|Translated into Servlet|Processes HTML templates|
|Common in traditional Spring MVC|Common in modern Spring Boot MVC|

## 9. Common Errors

|Error|Reason|
|---|---|
|Template not found|HTML file missing from templates folder|
|Data displays as null|Incorrect Model attribute name|
|`th:text` not working|Missing Thymeleaf dependency or namespace|
|Whitelabel Error Page|Incorrect URL mapping or server-side error|
|404 error|Incorrect Controller URL|

## 10. Interview Questions

1. What is Thymeleaf?
    
2. Why do we use Thymeleaf?
    
3. What is the default Thymeleaf template folder?
    
4. What is the purpose of `th:text`?
    
5. Difference between JSP and Thymeleaf?
    
6. How does Controller send data to Thymeleaf?
    
7. What is the purpose of `th:each`?
    
8. What is the difference between `@Controller` and `@RestController`?