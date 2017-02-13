package edu.uca.aca2016.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String username;
    private String password;
    private List<String> roles;
    private Map<String, String> rolemap;

    public User(){
        this.rolemap = new LinkedHashMap<String,String>();
        this.rolemap.put("ROLE_USER",  "User");
        this.rolemap.put("ROLE_ADMIN", "Administrator");
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Map<String,String> getRolemap(){
        return this.rolemap;
    }

    public List<String> getRoles(){
        return roles;
    }

    public void setRoles(List<String> roles){
        this.roles = roles;
    }
}
