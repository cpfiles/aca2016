package edu.uca.aca2016.web;

import edu.uca.aca2016.objects.Artist;
import edu.uca.aca2016.repository.ArtistDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ArtistRESTController{

    @Autowired
    ArtistDAO dao;

    @RequestMapping(value = "/api/artist/",method = RequestMethod.GET)
    public ResponseEntity<List<Artist>> listAllArtists(){
        List<Artist> artists = dao.getArtistsList();

        if(artists.isEmpty()){
            return new ResponseEntity<List<Artist>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Artist>>(artists,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/artist/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Artist> getArtist(@PathVariable("id") int id){
        Artist artist = null;
        
        try {
            artist = dao.getArtistById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Artist>(artist,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/artist/",method = RequestMethod.POST)
    public ResponseEntity<Void> createArtist(@RequestBody Artist artist,UriComponentsBuilder ucBuilder){
        dao.save(artist);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/artist/{id}").buildAndExpand(artist.getId()).toUri());
        
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/artist/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Artist> updateArtist(@PathVariable("id") int id,@RequestBody Artist artist){
        Artist currentArtist = null;

        try {
            currentArtist = dao.getArtistById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }

        currentArtist.setName(artist.getName());

        dao.update(currentArtist);
        return new ResponseEntity<Artist>(currentArtist,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/artist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Artist> deleteArtist(@PathVariable("id") int id) {
        Artist artist = null;
        
        try {
            artist = dao.getArtistById(id);
        }
        catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
 
        dao.delete(id);
        
        return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
    }
}
