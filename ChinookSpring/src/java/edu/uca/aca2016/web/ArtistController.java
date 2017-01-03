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

@Controller
public class ArtistController{
    @Autowired
    ArtistDAO dao;

    @RequestMapping("/artistform")
    public ModelAndView showform(){
        return new ModelAndView("artistform","command",new Artist());
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("artist") Artist artist){
        dao.save(artist);
        return new ModelAndView("redirect:/viewartist");
    }

    @RequestMapping("/viewartist")
    public ModelAndView viewartist(){
        List<Artist> list = dao.getArtistsList();
        return new ModelAndView("viewartist","list",list);
    }

    @RequestMapping(value = "/editartist/{id}")
    public ModelAndView edit(@PathVariable int id){
        Artist artist = dao.getArtistById(id);
        return new ModelAndView("artisteditform","command",artist);
    }
    
    @RequestMapping(value = "/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("artist") Artist artist){
        dao.update(artist);
        return new ModelAndView("redirect:/viewartist");
    }

    @RequestMapping(value = "/deleteartist/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/viewartist");
    }
}
