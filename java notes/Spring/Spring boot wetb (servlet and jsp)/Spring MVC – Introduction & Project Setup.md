## 1. Introduction to MVC

MVC stands for **Model – View – Controller**. It is a design pattern used to separate an application into three parts, making code easier to maintain.

- **Model:** Stores application data.
    
- **View:** Displays data to the user (JSP).
    
- **Controller:** Handles user requests and connects Model and View.
    

**Flow:**

Browser → Controller → Model → View → Browser

## 2. Creating a Spring Boot Web App Project

Required dependencies:

- Spring Web – Provides Spring MVC and web functionality.
    
- Tomcat – Runs the web application.
    
- JSP support – Used for creating dynamic web pages.
    

**Remember:** Spring Boot simplifies configuration and provides embedded Tomcat.

## 3. Creating a JSP Page

JSP (JavaServer Pages) is used to create dynamic web pages using HTML and server-side data.

Example: `home.jsp`

```
<html>
<body>
    <h1>Welcome to Spring MVC</h1>
</body>
</html>
```

JSP pages are used as the View in traditional Spring MVC applications.

## 4. Creating a Controller

Controller handles incoming HTTP requests and decides which view should be displayed.

Annotation: `@Controller`

```
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

- `@Controller` – Marks a class as a Spring MVC Controller.
    
- `@GetMapping` – Maps a GET request to a method.
    
- `return "home"` – Returns the logical view name, resolved to `home.jsp` if JSP view resolution is configured.
    

**Remember:** Controller connects the request with the appropriate View.