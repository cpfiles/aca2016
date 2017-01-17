package edu.uca.aca2016.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uca.aca2016.objects.Artist;
import edu.uca.aca2016.objects.Message;
import edu.uca.aca2016.repository.ArtistDAO;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ArtistController{
    @Autowired
    ArtistDAO dao;
    
    private static final Logger logger = Logger.getLogger(ArtistController.class.getName());

    @RequestMapping("/artist/artistform")
    public ModelAndView showform(){
        return new ModelAndView("artistform","command",new Artist());
    }

    @RequestMapping(value = "/artist/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("artist") Artist artist, HttpServletRequest request){
        int r = dao.save(artist);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Artist has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New artist creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/artist/viewartist");
    }

    @RequestMapping("/artist/viewartist")
    public ModelAndView viewartist(HttpServletRequest request){
        //List<Artist> list = dao.getArtistsList();
        //return new ModelAndView("viewartist","list",list);
        
        return this.viewartist(1, request);
    }
    
    @RequestMapping("/artist/viewartist/{pageid}")
    public ModelAndView viewartist(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<Artist> list = dao.getArtistsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getArtistsCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewartist", context);
    }

    @RequestMapping(value = "/artist/editartist/{id}")
    public ModelAndView edit(@PathVariable int id){
        Artist artist = dao.getArtistById(id);
        return new ModelAndView("artisteditform","command",artist);
    }
    
    @RequestMapping(value = "/artist/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("artist") Artist artist, HttpServletRequest request){
        int r = dao.update(artist);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Artist has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit artist failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/artist/viewartist");
    }

    @RequestMapping(value = "/artist/deleteartist/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request){
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Artist has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete artist failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/artist/viewartist");
    }
}
