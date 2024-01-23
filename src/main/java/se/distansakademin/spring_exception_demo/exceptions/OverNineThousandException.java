package se.distansakademin.spring_exception_demo.exceptions;

public class OverNineThousandException extends Exception{

    public OverNineThousandException(int id) {
        super("Power level too high: " + id);
    }
}
