## 1. RequestMapping

`@RequestMapping` maps HTTP requests to Controller methods or classes.

```
@RequestMapping("/home")
public String home() {
    return "home";
}
```

It supports different HTTP methods such as GET and POST.

**Shortcut annotations:**

- `@GetMapping` – GET request.
    
- `@PostMapping` – POST request.
    
- `@PutMapping` – PUT request.
    
- `@DeleteMapping` – DELETE request.
    

## 2. Sending Data to Controller

HTML form sends user-entered data to the Controller through an HTTP request.

Example: `home.jsp`

```
<form action="add" method="get">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <button type="submit">Add</button>
</form>
```

**Remember:**

- `action` – Controller URL.
    
- `method` – HTTP request method.
    
- `name` – Parameter name sent to the server.
    

## 3. Accepting Data the Servlet Way

Servlet API provides `HttpServletRequest` to access incoming request parameters.

```
@RequestMapping("/add")
public String add(HttpServletRequest request) {

    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));

    int result = n1 + n2;

    return "result";
}
```

**Important methods:**

- `getParameter("num1")` – Gets request parameter as String.
    
- `Integer.parseInt()` – Converts String into int.
    

**Remember:** Servlet way means manually extracting request data using HttpServletRequest.

## 4. Display Data on Result Page

To display Controller data in JSP, add the data to the request using `setAttribute()`.

**Controller:**

```
request.setAttribute("result", result);
return "result";
```

**result.jsp:**

```
<h1>Result: ${result}</h1>
```

`${result}` is JSP Expression Language (EL), which displays the value stored in the request scope.

**Flow:**

Controller → setAttribute() → JSP → ${result} → Browser