Spring boot rest mvc example:
1. For controllers use @RestController annotation
2. Alternatively we can use @Controller but with @ResponseBody annotation
3. The JSON mapping will be automatically taken care by spring
4. Refer JobRestController
5. For getting variables from query params, we can use @PathVariable annotation
6. Use {} to define variables in the path
7. To receive post request we need to use @PostMapping annotation,
8. To bind the request body to the object, we need to use @RequestBody annotation
9. To update a resource, we can use @PutMapping, it also takes a @RequestBody
10. To delete a resource we can use @DeleteMapping and with @PathVariable
11. Content Negotiation - Jackson library is responsible for converting the java 
    objects into JSON, we can also use different library for XML,  jackson works
    only with JSON
12. To use XML, we need to add another jackson dependency with XML support
13. We can also make the controller actions respond with only certain type
    by using produces property in the mapping
    Ex: @GetMapping(path="job_posts", produces = {"application/json"})
14. The same applies for what data controller can receive/consume
    For this we can use consumes property in the mapping
    Ex: @PostMapping(path="job_post", consumes = {"application/xml"})
================================================================================

This whole project is now migrated to use Spring Data JPA ORM with postgresql DB

Aspect oriented programming:
https://docs.spring.io/spring-framework/reference/core/aop/introduction-defn.html

1. joint point - When it happens
2. Advice - what happens
3. Aspect - where the logic is written for what needs to happen
4. Pointcut - where it actually happens
5. Target object - which obj will experience this advice
6. Weaving - how it happens
7. Proxy - proxy object which makes main object look good
8. Type of advice: Before, After, After throwing, Around
9. Refer LoggingAspect class - we need to use @Aspect annotation
10. Methods need to be annotated with few annotations 
=================================================================================

This whole project is now secured with spring security