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
import edu.uca.aca2016.repository.ArtistDAO;
import java.util.HashMap;

@Controller
public class ArtistController{
    @Autowired
    ArtistDAO dao;

    @RequestMapping("/artist/artistform")
    public ModelAndView showform(){
        return new ModelAndView("artistform","command",new Artist());
    }

    @RequestMapping(value = "/artist/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("artist") Artist artist){
        dao.save(artist);
        return new ModelAndView("redirect:/artist/viewartist");
    }

    @RequestMapping("/artist/viewartist")
    public ModelAndView viewartist(){
        //List<Artist> list = dao.getArtistsList();
        //return new ModelAndView("viewartist","list",list);
        
        return this.viewartist(1);
    }
    
    @RequestMapping("/artist/viewartist/{pageid}")
    public ModelAndView viewartist(@PathVariable int pageid){
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

        return new ModelAndView("viewartist", context);
    }

    @RequestMapping(value = "/artist/editartist/{id}")
    public ModelAndView edit(@PathVariable int id){
        Artist artist = dao.getArtistById(id);
        return new ModelAndView("artisteditform","command",artist);
    }
    
    @RequestMapping(value = "/artist/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("artist") Artist artist){
        dao.update(artist);
        return new ModelAndView("redirect:/artist/viewartist");
    }

    @RequestMapping(value = "/artist/deleteartist/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/artist/viewartist");
    }
}
