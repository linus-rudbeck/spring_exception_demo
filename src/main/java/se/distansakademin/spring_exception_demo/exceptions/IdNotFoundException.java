package se.distansakademin.spring_exception_demo.exceptions;

public class IdNotFoundException extends Exception {

    public IdNotFoundException(int id) {
        super("Id not found: " + id);
    }
}
