## 1. What is a Web Application?

A Web Application is software that runs on a web server and users access it through a web browser.

**Examples:** Gmail, Amazon, Banking Applications.

**Basic Working:**

Browser → Server → Application Logic → Response → Browser

Unlike desktop applications, web applications are accessed through a browser using HTTP requests and responses.

## 2. Creating a Servlet Project

A Servlet Project is a Java web application that uses Servlets to handle client requests and send responses.

In my project, I used:

- Spring Boot – Application setup and configuration.
    
- Spring Web – Provides Spring MVC and web capabilities.
    
- Embedded Tomcat – Runs the web application and manages Servlets.
    
- JSP – Used to create dynamic web pages (View).
    

**Remember:** Spring Boot simplifies project configuration, while Tomcat handles Servlet execution.

## 3. Running Tomcat

Tomcat is a Servlet Container that runs Java web applications.

**Main responsibilities:**

- Receives HTTP requests.
    
- Manages Servlet lifecycle.
    
- Creates request and response objects.
    
- Sends responses back to the browser.
    

**In Spring Boot:**

Tomcat is embedded, so we don't need to install and configure an external Tomcat server for normal development.

When we run the Spring Boot application:

1. Spring Boot starts.
    
2. Embedded Tomcat starts.
    
3. DispatcherServlet is registered.
    
4. Application becomes ready to receive HTTP requests.
    

**Remember:** Tomcat is the server/container; Spring Boot makes starting and configuring it easier.

## 4. Servlet Mapping

Servlet Mapping means connecting a URL pattern to a particular Servlet.

It tells the Servlet Container which Servlet should handle a particular request.

**Traditional Servlet Example:**

```
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {

        response.getWriter().println("Hello World");
    }
}
```

Here:

- `@WebServlet("/hello")` → Maps URL to Servlet.
    
- `doGet()` → Handles GET request.
    
- `/hello` → URL pattern.
    

When the browser requests:

`http://localhost:8080/hello`

The HelloServlet handles that request.

**In Spring Boot:**

We commonly use `@GetMapping` and `@PostMapping` in Controllers instead of manually mapping Servlets.

```
@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```

Here, Spring MVC maps `/hello` to the Controller method through DispatcherServlet.

**Remember:**

- Traditional Servlet → `@WebServlet`
    
- Spring MVC → `@GetMapping`, `@PostMapping`
    

## 5. Responding to the Client

A client is usually a web browser that sends an HTTP request to the server.

The server processes the request and sends an HTTP response.

**Traditional Servlet Example:**

```
protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
) throws IOException {

    response.setContentType("text/html");

    response.getWriter().println("<h1>Hello Client</h1>");
}
```

**Important Objects:**

|Object|Purpose|
|---|---|
|HttpServletRequest|Contains incoming request data|
|HttpServletResponse|Creates the outgoing response|
|getWriter()|Writes response content|

**In Spring MVC:**

A Controller can return a view name:

```
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

Spring MVC resolves the `home` view (JSP, if configured) and sends the generated HTML response to the browser.

## 6. Complete Working Flow

Browser → Tomcat → DispatcherServlet → Controller → Service → Repository → Database

The response travels back through Spring MVC and Tomcat to the browser.

**Important Concepts to Remember:**

|Concept|Meaning|
|---|---|
|Web Application|Application accessed through browser|
|Servlet|Handles HTTP requests and responses|
|Tomcat|Servlet Container|
|Servlet Mapping|Connects URL to Servlet|
|DispatcherServlet|Front Controller in Spring MVC|
|JSP|Generates dynamic HTML pages|
|Spring Web|Provides Spring MVC web functionality|

## Interview Questions

1. What is a Web Application?
    
2. What is a Servlet?
    
3. What is Apache Tomcat?
    
4. What is a Servlet Container?
    
5. What is Servlet Mapping?
    
6. What is the difference between `@WebServlet` and `@GetMapping`?
    
7. What is DispatcherServlet?
    
8. How does Spring Boot start Tomcat?
    
9. How does a Servlet send a response to a client?