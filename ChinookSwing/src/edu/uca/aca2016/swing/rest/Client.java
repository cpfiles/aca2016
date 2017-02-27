package edu.uca.aca2016.swing.rest;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Client{
    private OkHttpClient client;
    public Response response = null;
    public String content = null;
    public Error error = null;

    private final String address = "http://localhost:8080/ChinookSpring/api/";
    
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");


    public Client() throws IOException{
        this.client = new OkHttpClient.Builder()
            .addInterceptor(new AuthenticateInterceptor("jane","asdf1234"))
            .build();
    }

    protected void populateFromResponse(Response response) throws IOException{
        if(response != null){
            this.response = response;
            this.content = this.response.body().string();

            if(this.response.isSuccessful()){
                this.error = null;
            }
            else{
                this.error = new Error(response.message());
            }
        }
        else{
            this.response = null;
            this.content = null;
            this.error = new Error("Response was null");
        }
    }

    public <T> T get(String url, Type type){
        try{
            Request request = new Request.Builder()
                .url(this.address + url)
                .get()
                .build();

            //This request is used to do a GET.
            this.populateFromResponse(this.client.newCall(request).execute());

            //The returning value.
            T ret = null;

            //Always check for null...
            if(this.response != null){
                try{
                    ret = new Gson().fromJson(this.content,type);
                }
                catch(JsonSyntaxException e){
                    this.error = new Error("Response was not valid Json. " + e.getMessage());
                }
                catch(Exception e){
                    this.error = new Error("An Unknown Exception was thrown.");
                }
            }
            return ret;
        }
        catch(IOException ex){
            this.error = new Error("Exception: " + ex.getMessage());
        }
        return null;
    }
    
    public <T> void post(String url, T object, Type type){
        try{
            String json = new Gson().toJson(object,type);
            
            Request request = new Request.Builder()
              .url(this.address + url)
              .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, json))
              .build();
            
            Response response = client.newCall(request).execute();
            
            this.populateFromResponse(response);
        }
        catch(IOException ex){
          this.error = new Error("IO Exception: " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        Client c = new Client();

        List<Artist> aql = c.get("artist/",new TypeToken<List<Artist>>(){}.getType());
        
        if (c.error != null) {
            System.err.println(c.error);
            return;
        }
        
        System.out.println(aql.size());
        
        for(Artist a : aql){
            System.out.println(a.getName());
        }
        
        Artist ax = c.get("artist/2", Artist.class);
        
        if (c.error != null) {
            System.err.println(c.error);
            return;
        }

        System.out.println(ax.getName());
        
        Artist an = new Artist()
            .withName("TEST");
        c.post("/artist/", an, Artist.class);
        
        if (c.error != null) {
            System.err.println(c.error);
            return;
        }
        
        System.out.println(an.getName());
    }
}
