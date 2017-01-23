package edu.uca.aca2016.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.uca.aca2016.objects.Album;
import edu.uca.aca2016.objects.Artist;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class AlbumDAO{

    JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(AlbumDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(Album album){
        String sql = "INSERT INTO Album (Title, ArtistID) values(?, ?)";

        Object[] values = {album.getTitle(), album.getArtistid()};
        
        logger.info("Album DAO save values: " + values);

        return template.update(sql,values);
    }

    public int update(Album album){
        String sql = "UPDATE Album SET Title=?, ArtistID=? WHERE AlbumId = ?";

        Object[] values = {album.getTitle(), album.getArtistid(), album.getId()};

        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM Album WHERE AlbumId = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }

    public List<Album> getAlbumsList(){
        return template.query("SELECT * FROM Album",new RowMapper<Album>(){
            public Album mapRow(ResultSet rs,int row) throws SQLException{
                Album a = new Album();
                a.setId(rs.getInt("AlbumId"));
                a.setTitle(rs.getString("Title"));
                return a;
            }
        });
    }

    public Album getAlbumById(int id){
        String sql = "SELECT AlbumId AS id, Title, ArtistID FROM Album WHERE AlbumId = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Album>(Album.class));
    }

    public List<Album> getAlbumsByPage(int start, int total){
        String sql = "SELECT album.AlbumId, album.Title, artist.ArtistId, artist.Name " +
                "FROM Album AS album " +
                "INNER JOIN Artist AS artist ON artist.ArtistId = album.ArtistId " +
                "ORDER BY artist.Name, album.Title " + 
                "LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Album>(){
            public Album mapRow(ResultSet rs,int row) throws SQLException{
                Album a = new Album();
                a.setId(rs.getInt(1));
                a.setTitle(rs.getString(2));
                
                Artist artist = new Artist();
                artist.setId(rs.getInt(3));
                artist.setName(rs.getString(4));
                
                a.setArtist(artist);
                return a;
            }
        });
    }
    
    public int getAlbumsCount() {
        String sql = "SELECT COUNT(AlbumID) AS rowcount FROM Album";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
    
    public Map<Integer,String> getArtistsMap() {
        Map<Integer,String> artists = new LinkedHashMap<Integer,String>();
        String sql = "SELECT ArtistID, Name FROM Artist ORDER BY Name";
        
        SqlRowSet rs = template.queryForRowSet(sql); 
        
        while(rs.next()){ 
            artists.put(rs.getInt(1), rs.getString(2));
        }
        
        return artists;
    }
}
