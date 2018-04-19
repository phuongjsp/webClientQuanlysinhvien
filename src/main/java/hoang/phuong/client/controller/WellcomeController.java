package hoang.phuong.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WellcomeController {
    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String hello(Model model) {
        return "index";
    }
}
