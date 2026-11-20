## 1. What is a Servlet?

A Servlet is a Java class that runs on a web server and handles HTTP requests and responses.

**Simple meaning:**

When a user sends a request from a browser, a Servlet receives the request, processes it and sends a response back to the browser.

**Example:**

1. User enters `www.example.com/login`.
    
2. Browser sends an HTTP request.
    
3. Servlet receives the request.
    
4. Servlet processes the request.
    
5. Servlet sends an HTTP response.
    
6. Browser displays the result.
    

## 2. Why Servlet?

Before Servlets, Java developers commonly used CGI (Common Gateway Interface) to handle web requests.

Servlets provide a more efficient way to handle multiple requests using Java and a server-managed thread model.

**Advantages:**

- Handles HTTP requests and responses.
    
- Supports dynamic web applications.
    
- Can communicate with databases.
    
- Can process multiple user requests.
    
- Reusable Java-based server-side technology.
    

## 3. How Servlet Works?

Servlet works inside a Servlet Container.

Examples:

- Apache Tomcat
    
- Jetty
    

The Servlet Container:

- Receives HTTP requests.
    
- Finds the appropriate Servlet.
    
- Manages Servlet lifecycle.
    
- Provides request and response objects.
    
- Sends the response back to the browser.
    

## 4. Servlet Lifecycle

A Servlet has three main lifecycle methods:

|Method|Purpose|
|---|---|
|`init()`|Called once when Servlet is initialized|
|`service()`|Handles incoming requests|
|`destroy()`|Called before Servlet is removed|

**Lifecycle Flow:**

1. Servlet class is loaded and instantiated.
    
2. `init()` executes once.
    
3. `service()` executes for each request.
    
4. `destroy()` executes when Servlet is taken out of service.
    

For HTTP Servlets, `service()` dispatches requests to methods such as:

- `doGet()` – Handles GET requests.
    
- `doPost()` – Handles POST requests.
    
- `doPut()` – Handles PUT requests.
    
- `doDelete()` – Handles DELETE requests.
    

## 5. Simple Servlet Example

```
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException {

        response.setContentType("text/html");

        response.getWriter().println("Hello World");
    }
}
```

**Explanation:**

- `@WebServlet("/hello")` → Maps the URL to this Servlet.
    
- `HttpServlet` → Base class for HTTP Servlets.
    
- `doGet()` → Handles GET requests.
    
- `HttpServletRequest` → Contains incoming request information.
    
- `HttpServletResponse` → Used to prepare the response.
    
- `getWriter()` → Writes response content.
    

## 6. What is Servlet Container?

A Servlet Container is a component of a web server that manages Servlets.

Example: Tomcat.

It manages:

- Servlet lifecycle.
    
- Request and response handling.
    
- Servlet creation and destruction.
    
- Request mapping and dispatching.
    

## 7. Servlet in Spring Boot

Spring Boot uses an embedded Servlet Container, usually Tomcat, in a typical Spring MVC application.

When we create a Spring Boot project with Spring Web:

1. Embedded Tomcat starts.
    
2. DispatcherServlet is registered.
    
3. Browser sends an HTTP request.
    
4. DispatcherServlet receives the request.
    
5. It finds the appropriate Controller.
    
6. Controller processes the request.
    
7. Response is returned to the browser.
    

**Important:** Spring MVC's DispatcherServlet is a special Servlet that acts as the front controller.

## Interview Questions

1. What is a Servlet?
    
2. What is a Servlet Container?
    
3. Explain Servlet lifecycle.
    
4. Difference between `doGet()` and `doPost()`?
    
5. What is HttpServlet?
    
6. What is DispatcherServlet?

7. Which Servlet Container is commonly used in Spring Boot?