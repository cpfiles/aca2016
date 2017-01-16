package edu.uca.aca2016.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import edu.uca.aca2016.objects.Artist;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class ArtistDAO{

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public int save(Artist artist){
        String sql = "INSERT INTO Artist (Name) values(?)";

        Object[] values = {artist.getName()};

        return template.update(sql,values);
    }

    public int update(Artist artist){
        String sql = "UPDATE Artist SET Name=? WHERE ArtistId = ?";

        Object[] values = {artist.getName(),artist.getId()};

        return template.update(sql,values);
    }

    public int delete(int id){
        String sql = "DELETE FROM Artist WHERE ArtistId = ?";

        Object[] values = {id};

        return template.update(sql,values);
    }

    public List<Artist> getArtistsList(){
        return template.query("SELECT * FROM Artist",new RowMapper<Artist>(){
            public Artist mapRow(ResultSet rs,int row) throws SQLException{
                Artist a = new Artist();
                a.setId(rs.getInt("ArtistId"));
                a.setName(rs.getString("Name"));
                return a;
            }
        });
    }

    public Artist getArtistById(int id){
        String sql = "SELECT ArtistId AS id, Name FROM Artist WHERE ArtistId = ?";
        return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Artist>(Artist.class));
    }

    public List<Artist> getArtistsByPage(int start, int total){
        String sql = "SELECT * FROM Artist LIMIT " + (start - 1) + "," + total;
        return template.query(sql,new RowMapper<Artist>(){
            public Artist mapRow(ResultSet rs,int row) throws SQLException{
                Artist a = new Artist();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                return a;
            }
        });
    }
    
    public int getArtistsCount() {
        String sql = "SELECT COUNT(ArtistID) AS rowcount FROM Artist";
        SqlRowSet rs = template.queryForRowSet(sql);
        
        if (rs.next()) {
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
