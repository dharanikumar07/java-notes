## 1. What is DispatcherServlet?

DispatcherServlet is the **Front Controller** of the Spring MVC framework.

It is a special Servlet that receives incoming HTTP requests and distributes them to the appropriate Controller based on the URL mapping.

**Simple meaning:**

Instead of every Controller directly receiving requests from the browser, all requests first come to DispatcherServlet. It decides which Controller should handle the request.

### Why do we need DispatcherServlet?

In traditional Servlet applications, we may create multiple Servlets to handle different URLs.

For example:

- `/login` → LoginServlet
    
- `/register` → RegisterServlet
    
- `/home` → HomeServlet
    

Managing multiple Servlets manually becomes difficult as the application grows.

Spring MVC solves this problem using DispatcherServlet.

It acts as a central entry point and manages the request flow.

### How DispatcherServlet works

1. Browser sends an HTTP request.
    
2. Tomcat receives the request.
    
3. DispatcherServlet receives the request.
    
4. It identifies the appropriate Controller using HandlerMapping.
    
5. Controller executes the required logic.
    
6. Controller returns a view name or response.
    
7. If a view name is returned, DispatcherServlet uses a ViewResolver to find the actual view.
    
8. The View is rendered and the response is sent to the browser.
    

### Example

```
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

When the browser requests:

`http://localhost:8080/home`

DispatcherServlet identifies the HomeController method and executes it.

**Remember:** DispatcherServlet does not contain our business logic. It coordinates the request handling process.

---

## 2. Configuring DispatcherServlet

In traditional Spring MVC applications, developers had to configure DispatcherServlet manually.

For example, using `web.xml`:

```
<servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>
        org.springframework.web.servlet.DispatcherServlet
    </servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

### Explanation

- `servlet-class` → Specifies DispatcherServlet.
    
- `servlet-name` → Gives the Servlet a name.
    
- `url-pattern` → Maps incoming URLs to DispatcherServlet.
    
- `/` → Handles requests through the default application mapping.
    

### What happens in Spring Boot?

In Spring Boot, we generally don't need to configure DispatcherServlet manually.

When we add the Spring Web dependency:

1. Spring Boot detects Spring MVC.
    
2. It automatically configures DispatcherServlet.
    
3. It registers DispatcherServlet with embedded Tomcat.
    
4. It becomes ready to handle incoming requests.
    

**Remember:**

Traditional Spring MVC → Manual configuration may be required.

Spring Boot → Auto-configuration handles it.

---

## 3. What is InternalResourceViewResolver?

InternalResourceViewResolver is a Spring MVC ViewResolver used to locate JSP pages based on the logical view name returned by a Controller.

**Simple meaning:**

The Controller returns only the JSP page name. InternalResourceViewResolver combines the prefix and suffix to find the actual JSP file.

### Why do we need it?

Suppose we have a JSP file:

`/WEB-INF/views/home.jsp`

Without a ViewResolver, we would need to specify the complete path repeatedly.

Instead, we configure a prefix and suffix once.

### Configuration

In traditional Spring MVC Java configuration:

```
@Bean
public InternalResourceViewResolver viewResolver() {

    InternalResourceViewResolver resolver =
        new InternalResourceViewResolver();

    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");

    return resolver;
}
```

### Understanding Prefix and Suffix

**Prefix:** The folder location where JSP pages are stored.

`/WEB-INF/views/`

**Suffix:** The file extension.

`.jsp`

### Example

Controller:

```
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {

        return "home";
    }
}
```

The Controller returns:

`home`

InternalResourceViewResolver combines:

- Prefix: `/WEB-INF/views/`
    
- View name: `home`
    
- Suffix: `.jsp`
    

Final JSP path:

`/WEB-INF/views/home.jsp`

### Spring Boot Configuration

In Spring Boot, we can configure the same prefix and suffix in `application.properties`.

```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

Spring Boot configures the JSP view resolution accordingly.

---

## 4. Complete Working Flow

Let's understand all three concepts together.

Suppose the browser requests `/home`.

1. Browser sends `/home` request.
    
2. Tomcat receives the request.
    
3. DispatcherServlet receives the request.
    
4. HandlerMapping finds the matching Controller.
    
5. HomeController executes and returns `"home"`.
    
6. DispatcherServlet asks the ViewResolver to resolve the view.
    
7. InternalResourceViewResolver combines prefix and suffix.
    
8. `/WEB-INF/views/home.jsp` is located and rendered.
    
9. HTML response goes back to the browser.
    

### Important Components

|Component|Responsibility|
|---|---|
|Tomcat|Receives HTTP requests and manages Servlets|
|DispatcherServlet|Central request handler|
|HandlerMapping|Finds the appropriate Controller|
|Controller|Processes the request|
|ViewResolver|Finds the appropriate View|
|InternalResourceViewResolver|Resolves JSP view paths|
|JSP|Generates dynamic HTML|

---

## 5. Important Interview Questions

**1. What is DispatcherServlet?**

DispatcherServlet is the Front Controller in Spring MVC that receives incoming requests and dispatches them to appropriate Controllers.

**2. Why is DispatcherServlet called Front Controller?**

Because it acts as the central entry point for incoming requests in a Spring MVC application.

**3. Do we need to configure DispatcherServlet manually in Spring Boot?**

No. Spring Boot automatically configures and registers DispatcherServlet when Spring MVC is available.

**4. What is InternalResourceViewResolver?**

It is a ViewResolver that resolves logical view names into actual JSP page paths using prefix and suffix.

**5. What is the difference between DispatcherServlet and ViewResolver?**

DispatcherServlet manages the request-processing flow, whereas ViewResolver identifies the actual View that should be rendered.

**6. What happens when a Controller returns "home"?**

DispatcherServlet uses the configured ViewResolver to locate the corresponding view, such as `/WEB-INF/views/home.jsp`.