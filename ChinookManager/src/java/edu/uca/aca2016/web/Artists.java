/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.web;

import edu.uca.aca2016.jdbc.cpfiles.ChinookManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cfiles
 */
public class Artists extends HttpServlet{
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        String mid = request.getParameter("mid");
        String dothis = request.getParameter("do");
        String message = "";
        
        if (mid == null || mid.isEmpty()) {
            message = "";
        }
        else if (mid.equals("100")) {
            message = "Artist was added to database";
        }
        else if (mid.equals("101")) {
            message = "Artist was not added, name value was empty or incorrect.";
        }
        else if (mid.equals("200")) {
            message = "Artist was updated";
        }
        else if (mid.equals("201")) {
            message = "Artist was not updated, name value was empty or incorrect or id was missing.";
        }
        else if (mid.equals("300")) {
            message = "Artist was deleted";
        }
        else if (mid.equals("301")) {
            message = "Artist was not deleted.";
        }

        try(PrintWriter out = response.getWriter()){
            
            ChinookManager cm = new ChinookManager();
            HashMap<Integer, String> artists = cm.getArtists();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Chinook Artist Manager</title>");    
            out.println("<style>body { font-family: Verdana, Geneva, sans-serif; }</style>");
            out.println("</head>");
            out.println("<body>");
            
            if (!message.isEmpty()) {
                out.println("<span style='color: red;'>" + message + "</span>");
            }
            
            if (dothis != null && dothis.equals("Delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = cm.getArtistName(id);
                
                out.println("<h1>Delete Artist</h1>");
                out.println("<form method=\"post\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
                out.println("Are you sure you want to delete artist \"" + name + "\"?");
                out.println("<input type=\"submit\" value=\"Delete\" name=\"action\">");
                out.println("</form>");
            }
            else if (dothis != null && dothis.equals("Edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = cm.getArtistName(id);
                
                out.println("<h1>Edit Artist</h1>");
                out.println("<form method=\"post\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
                out.println("Artist Name: <input type=\"text\" name=\"name\" value=\"" + name + "\">");
                out.println("<input type=\"submit\" value=\"Edit\" name=\"action\">");
                out.println("</form>");
            }
            else {
                out.println("<h1>Add an Artist</h1>");
                out.println("<form method=\"post\">");
                out.println("Artist Name: <input type=\"text\" name=\"name\">");
                out.println("<input type=\"submit\" value=\"Add\" name=\"action\">");
                out.println("</form>");
            }
            
            out.println("<h1>Manage Artist</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Action</th></tr>");
            
            for(Map.Entry<Integer, String> artist : artists.entrySet()) {
                out.println("<tr><td>" + artist.getKey() + "</td><td>" + artist.getValue() + 
                    "</td><td><a href='?do=Edit&id="+ artist.getKey() +
                    "'>Edit</a> <a href='?do=Delete&id="+ artist.getKey() +"'>Delete</a></td></tr>");
            }
            
            out.println("</table>");
            
            out.println("</body>");
            out.println("</html>");
            
            cm.close();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String action = request.getParameter("action");
        String mid = "";

        ChinookManager cm = new ChinookManager();
        
        if (action != null && !action.isEmpty()) {
            if (action.equals("Add")) {
                String name = request.getParameter("name");
                
                if (name == null || name.isEmpty()) {
                    mid = "101";
                }
                else {
                    cm.addArtist(name);
                    mid = "100";
                }
            }
            else if (action.equals("Edit")) {
                String name = request.getParameter("name");
                int id = Integer.parseInt(request.getParameter("id"));
                
                boolean ret = cm.updateArtist(id, name);
                
                if (ret) {
                    mid = "200";
                }
                else {
                    mid = "201";
                }
            }
            else if (action.equals("Delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                boolean ret = cm.deleteArtist(id);
                
                if (ret) {
                    mid = "300";
                }
                else {
                    mid = "301";
                }
            }
        }
        
        cm.close();
        
        response.sendRedirect(request.getRequestURI() + "?mid=" + mid);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo(){
        return "Short description";
    }
}
