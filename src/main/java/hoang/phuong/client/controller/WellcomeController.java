package hoang.phuong.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WellcomeController extends ExceptionHandlerController {
    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String hello() {
        return "WellcomeFile";
    }

    @RequestMapping(path = {"/**"}, method = RequestMethod.GET)
    public String err() {
        return "error";
    }


}
