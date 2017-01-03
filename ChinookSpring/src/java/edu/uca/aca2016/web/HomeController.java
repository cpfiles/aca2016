package edu.uca.aca2016.web;

import edu.uca.aca2016.objects.Artist;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
    
    @RequestMapping("/")
    public ModelAndView viewartist(){
        return new ModelAndView("index");
    }
}
