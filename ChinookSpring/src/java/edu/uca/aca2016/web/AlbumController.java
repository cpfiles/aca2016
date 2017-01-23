package edu.uca.aca2016.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uca.aca2016.objects.Album;
import edu.uca.aca2016.objects.Artist;
import edu.uca.aca2016.objects.Message;
import edu.uca.aca2016.repository.AlbumDAO;
import edu.uca.aca2016.repository.ArtistDAO;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AlbumController{
    @Autowired
    AlbumDAO dao;
    
    private static final Logger logger = Logger.getLogger(AlbumController.class.getName());

    @RequestMapping("/album/albumform")
    public ModelAndView showform(){
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        //context.put("list", list);
        
        Album album = new Album();
        
        ArtistDAO adao = new ArtistDAO();
        List<Artist> al = adao.getArtistsList();
        logger.info("Artist list size: " + al.size());
        album.setArtists(al);
        
        
        
        return new ModelAndView("albumform","command",album);
    }

    @RequestMapping(value = "/album/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("album") Album album, HttpServletRequest request){
        int r = dao.save(album);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Album has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New album creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/album/viewalbum");
    }

    @RequestMapping("/album/viewalbum")
    public ModelAndView viewalbum(HttpServletRequest request){
        //List<Album> list = dao.getAlbumsList();
        //return new ModelAndView("viewalbum","list",list);
        
        return this.viewalbum(1, request);
    }
    
    @RequestMapping("/album/viewalbum/{pageid}")
    public ModelAndView viewalbum(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<Album> list = dao.getAlbumsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getAlbumsCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewalbum", context);
    }

    @RequestMapping(value = "/album/editalbum/{id}")
    public ModelAndView edit(@PathVariable int id){
        Album album = dao.getAlbumById(id);
        return new ModelAndView("albumeditform","command",album);
    }
    
    @RequestMapping(value = "/album/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("album") Album album, HttpServletRequest request){
        int r = dao.update(album);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Album has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit album failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/album/viewalbum");
    }

    @RequestMapping(value = "/album/deletealbum/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request){
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Album has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete album failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/album/viewalbum");
    }
}
