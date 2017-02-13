package edu.uca.aca2016.repository;

import edu.uca.aca2016.objects.User;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO{
    
    JdbcTemplate template;
    
    private static final Logger logger = Logger.getLogger(AlbumDAO.class.getName());

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(User user){
        String sql = "INSERT INTO users (username, password) values(?, md5(?))";

        Object[] values = {user.getUsername(), user.getPassword()};
        
        logger.info("User DAO save values: " + values);
        
        int r = template.update(sql,values);
        
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        
        for (String role: user.getRoles()) {
            Object[] role_values = {user.getUsername(), role};
            
            logger.info("User DAO add role: " + values);
            
            template.update(sql, role_values);
        }

        // for this example we are going to return the insert of the user. 
        // we could do some more work here to make sure the roles went in, 
        // but the user is what is important.
        return r;
    }
}
