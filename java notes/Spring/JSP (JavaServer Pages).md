## 1. What is JSP?

JSP stands for JavaServer Pages.

JSP is a server-side technology used to create dynamic web pages using HTML and Java-related features.

**Simple meaning:**

Servlet is mainly used to handle requests and process logic, whereas JSP is mainly used to display dynamic content to users.

**Example:**

Suppose a user logs into an application.

The server retrieves the user's name from the database.

JSP displays:

```
<h1>Welcome, John!</h1>
```

Here, the username can change dynamically depending on the logged-in user.

## 2. Why JSP?

HTML alone cannot directly generate dynamic content based on server-side Java application data.

JSP helps developers:

- Display dynamic web pages.
    
- Display data received from Servlets.
    
- Separate presentation from business logic.
    
- Create HTML pages with dynamic values.
    

## 3. How JSP Works?

JSP does not execute directly as a normal HTML file.

The web container translates JSP into a Servlet and compiles it.

**Working process:**

1. Browser requests a JSP page.
    
2. Server checks whether the JSP needs translation or recompilation.
    
3. JSP is translated into a Servlet.
    
4. Servlet is compiled.
    
5. Servlet executes.
    
6. HTML response is sent to the browser.
    

**Important:** JSP is internally converted into a Servlet.

## 4. JSP Example

```
<html>
<body>

    <h1>Welcome ${name}</h1>

</body>
</html>
```

Here:

- `${name}` → Expression Language (EL).
    
- It displays the value of `name` available in the JSP context.
    

If the value is John, the browser displays:

Welcome John

## 5. Servlet vs JSP

|Servlet|JSP|
|---|---|
|Java class|JSP page|
|Mainly handles requests and processing|Mainly displays dynamic content|
|Java code is written in a class|HTML with JSP features|
|Manually writes HTML through Java APIs|Easier to write HTML|
|Used for request handling|Used for presentation|

**Remember:**

Servlet = Request handling

JSP = Presentation / View

## 6. JSP in Spring MVC

In traditional Spring MVC applications, JSP can be used as the View.

Example flow:

1. Browser sends request.
    
2. DispatcherServlet receives request.
    
3. Controller processes the request.
    
4. Controller adds data to Model.
    
5. View Resolver finds the JSP page.
    
6. JSP displays the data.
    
7. HTML response goes to the browser.
    

**Important:** JSP is one possible view technology. Spring MVC also supports Thymeleaf and other view technologies.

## 7. JSP vs Spring Boot

Spring Boot does not require JSP.

You can use:

- Thymeleaf
    
- JSP
    
- REST APIs with JSON
    
- Other view technologies
    

JSP has additional setup and packaging considerations in Spring Boot. For example, JSP is not supported with an executable JAR in the same way as WAR deployment; a WAR deployment is generally used.

## Interview Questions

1. What is JSP?
    
2. Why do we use JSP?
    
3. What happens internally when JSP executes?
    
4. Difference between Servlet and JSP?
    
5. Can JSP be converted into a Servlet?
    
6. What is the role of JSP in Spring MVC?
    
7. Does Spring Boot require JSP?

