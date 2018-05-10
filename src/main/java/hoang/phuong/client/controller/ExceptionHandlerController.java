package hoang.phuong.client.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

public abstract class ExceptionHandlerController {
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex) {
        ex.printStackTrace();
        return "error";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(NumberFormatException ex) {
        ex.printStackTrace();
        return "error";
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public String handleHttpServerErrorException(Model model, HttpServerErrorException ex) {
        model.addAttribute("messages", "Vui Long dang nhap truoc khi sua dung tinh nang nay");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        ex.printStackTrace();
        return "error";
    }
}
