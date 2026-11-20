
1. **Create Maven Web Project**
    
    - Create a Java web application.
        
2. **Add Dependencies**
    
    - Spring Web MVC
        
    - Servlet API
        
    - JSP / JSTL dependencies
        
3. **Configure DispatcherServlet**
    
    - Create `web.xml`.
        
    - Register DispatcherServlet.
        
    - Configure URL mapping (`/`).
        
4. **Create Spring Configuration**
    
    - Create a configuration class.
        
    - Add `@EnableWebMvc`.
        
    - Configure component scanning.
        
5. **Configure ViewResolver**
    
    - Configure `InternalResourceViewResolver`.
        
    - Set JSP prefix and suffix.
        
6. **Create Controller**
    
    - Add `@Controller`.
        
    - Create request mappings using `@GetMapping` or `@RequestMapping`.
        
7. **Create JSP Pages**
    
    - Store JSP files inside `/WEB-INF/views/`.
        
8. **Configure and Run Tomcat**
    
    - Deploy the WAR application.
        
    - Start Tomcat and access the application.
        

## Simple Flow

Maven Project → Dependencies → DispatcherServlet → Spring Configuration → ViewResolver → Controller → JSP → Tomcat