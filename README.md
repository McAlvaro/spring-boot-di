> Dependency Injection Implementation with Java Spring Boot

# Dependency Injection

Dependency injection is a design pattern that aims to take the responsibility of creating the instances of the classes that another object needs and supply it so that this class can use them.

## Implementation without Dependency Injection

Let's implement an example of dependency injection.

- Initially we have a Service class.

```java
package com.mcalvaro.springbootdi.services;
 
public class MySimpleService {
 
    public String run() {
        return "Running a simple process";
    }
}
```

- And in our controller we create our service class

```java
package com.mcalvaro.springbootdi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcalvaro.springbootdi.services.MySimpleService;

@Controller
public class IndexController {

    private MySimpleService service = new MySimpleService();
 
    @GetMapping({"/",""})
    public String index(Model model) {
        model.addAttribute("result", service.run());
        return "index";
    }
}
```

While this works correctly, the service is coupled to a concrete class and implementation. This implies a maintenance and scalability problem.

## Implementing Dependency Injection

Initially we are going to create the instance in the controller with dependency injection, for this our service class has to be a Component (Bean), so that the Spring container can handle it.

- Mark the Service class with `@Component`.

```java
package com.mcalvaro.springbootdi.services;

import org.springframework.stereotype.Component;

@Component
public class MySimpleService {
 
    public String run() {
        return "Running a simple process";
    }
}
```

- We inject our class with `@Autowired`.

```java
package com.mcalvaro.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcalvaro.springbootdi.services.MySimpleService;

@Controller
public class IndexController {

    @Autowired
    private MySimpleService service;
 
    @GetMapping({"/",""})
    public String index(Model model) {
        model.addAttribute("result", service.run());
        return "index";
    }
}
```

Now although we are already injecting the service class in our controller, it is still coupled to a concrete implementation.

What we are going to do is to decouple the service class from a concrete implementation, so that it can be injected and managed with the Spring container.

- Let's create an interface to decouple the implementation.

```java
package com.mcalvaro.springbootdi.services;
 
public interface IService {
 
    public String run();
}
```

- We implement this interface in our service class

```java
package com.mcalvaro.springbootdi.services;

import org.springframework.stereotype.Component;

@Component
public class MySimpleService implements IService {
 
    @Override
    public String run() {
        return "Running a simple process";
    }
}
```

- We inject the service to our controller through the interface (the generic class)

```java
package com.mcalvaro.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcalvaro.springbootdi.services.IService;

@Controller
public class IndexController {

    @Autowired
    private IService service;
 
    @GetMapping({"/",""})
    public String index(Model model) {
        model.addAttribute("result", service.run());
        return "index";
    }
}
```
