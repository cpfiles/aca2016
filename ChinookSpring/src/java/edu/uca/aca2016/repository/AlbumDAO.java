package edu.uca.aca2016.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.uca.aca2016.objects.Album;
import edu.uca.aca2016.objects.Artist;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class AlbumDAO{

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(Album artist){
        String sql = "INSERT INTO Album (Title) values(?)";

        Object[] values = {artist.getTitle()};

        return template.update(sql,values);
    }

    public int update(Album artist){
        String sql = "UPDATE Album SET Title=? WHERE AlbumId = ?";

        Object[] values = {artist.getTitle(),artist.getId()};

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
        String sql = "SELECT AlbumId AS id, Title FROM Album WHERE AlbumId = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Album>(Album.class));
    }

    public List<Album> getAlbumsByPage(int start, int total){
        String sql = "SELECT album.albumid, album.title, artist.artistid, artist.name "
                + "FROM album "
                + "INNER JOIN artist ON artist.artistid = album.albumid "
                + "LIMIT " + (start - 1) + "," + total;
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
}
