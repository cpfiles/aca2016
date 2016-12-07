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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cfiles
 */
public class ArtistsMVC extends HttpServlet{
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
        
        ChinookManager cm = new ChinookManager();
        HashMap<Integer, String> artists = cm.getArtists();
        
        request.setAttribute("artists", artists);
        request.setAttribute("dothis", dothis);
        request.setAttribute("message", message);
        
        String id = request.getParameter("id");
        
        if (id != null && !id.isEmpty()) {
            request.setAttribute("id", id);
            request.setAttribute("artist_name", cm.getArtistName(Integer.parseInt(id)));
        }

        RequestDispatcher rd = request.getRequestDispatcher("/artists_mvc.jsp");
        rd.include(request, response);
        
        cm.close();
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
