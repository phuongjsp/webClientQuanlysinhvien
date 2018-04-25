package hoang.phuong.client.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

public abstract class ExceptionHandlerController {
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException() {
        return "error";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException() {
        return "error";
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public String handleHttpServerErrorException() {
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        System.out.println("Mess Error");
        System.out.println(ex.getMessage());
        return "error";
    }
}
