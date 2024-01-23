package se.distansakademin.spring_exception_demo.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.distansakademin.spring_exception_demo.exceptions.IdNotFoundException;
import se.distansakademin.spring_exception_demo.exceptions.OverNineThousandException;
import se.distansakademin.spring_exception_demo.models.User;

@RestController
public class ApiController {

    @GetMapping("/test/{id}")
    public String getTest(@PathVariable int id) throws IdNotFoundException, OverNineThousandException {

        if(id > 9000){
            // 1. Skapa ett nytt exception (IdToHighException eller OverNineThousandException)
            // 2. Fånga nya exceptionet i GlobalExceptionHandler
            // 3. Kasta det nya exceptionet här
            // 4. Testa att ni får rätt statuskod i Chrome
            throw new OverNineThousandException(id);
        }

        if(id > 10){
            throw new IdNotFoundException(id);
        }

        return "Found id: " + id;
    }

    @PostMapping("/users")
    @Validated
    public User createUser(@RequestBody @Valid User user){
        return user;
    }
}
