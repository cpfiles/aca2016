package edu.uca.aca2016.web;

import edu.uca.aca2016.objects.Message;
import edu.uca.aca2016.objects.User;
import edu.uca.aca2016.repository.UserDAO;
import edu.uca.aca2016.validation.UserValidator;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController{
    @Autowired
    UserDAO dao;
    
    @Autowired
    private UserValidator userValidator;
    
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping("/user/userform")
    public ModelAndView showform(){
        User user = new User();

        return new ModelAndView("userform","user",user);
    }
    
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return new ModelAndView("userform", "user", user);
        }
        
        int r = dao.save(user);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        // this needs to go to the user list view, but i am not providing one.
        return new ModelAndView("redirect:/");
    }
    
    @InitBinder("user")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(userValidator);
    }
    
    public UserValidator getUserValidator() {
        return userValidator;
    }
 
    public void setArtistValidator(UserValidator artistValidator) {
        this.userValidator = artistValidator;
    }
}
