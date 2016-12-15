/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.web.curiologic;

import edu.uca.aca2016.chinook.curiologic.ChinookGenreManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xulix
 */
@WebServlet(name = "GenreManager", urlPatterns = {"/GenreManager"})
public class GenreManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet GenreManager</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet GenreManager at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mesid = request.getParameter("mesid");
        String dothis = request.getParameter("do");
        String message = "";

        if (mesid == null || mesid.isEmpty()) {
            message = "";
        } else if (mesid.equals("100")) {
            message = "Genre was added to database";
        } else if (mesid.equals("101")) {
            message = "Genre was not added, name value was empty or incorrect.";
        } else if (mesid.equals("200")) {
            message = "Genre was updated";
        } else if (mesid.equals("201")) {
            message = "Genre was not updated, name value was empty or incorrect or id was missing.";
        } else if (mesid.equals("300")) {
            message = "Genre was deleted";
        } else if (mesid.equals("301")) {
            message = "Genre was not deleted.";
        }

        ChinookGenreManager cgm = new ChinookGenreManager();
        HashMap<Integer, String> genre = cgm.getGenres();

        request.setAttribute("genre", genre);
        request.setAttribute("dothis", dothis);
        request.setAttribute("message", message);

        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            request.setAttribute("id", id);
            request.setAttribute("genre_name", cgm.getGenreName(Integer.parseInt(id)));
        }

        RequestDispatcher rd = request.getRequestDispatcher("/GenreManager.jsp");
        rd.include(request, response);

        try {
            cgm.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // processRequest(request, response);
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String mesid = "";

        ChinookGenreManager cgm = new ChinookGenreManager();

        if (action != null && !action.isEmpty()) {
            if (action.equals("Add")) {
                String name = request.getParameter("name");

                if (name == null || name.isEmpty()) {
                    mesid = "101";
                } else {
                    cgm.addGenre(name);
                    mesid = "100";
                }
            } else if (action.equals("Edit")) {
                String name = request.getParameter("name");
                int id = Integer.parseInt(request.getParameter("id"));

                boolean ret = cgm.updateGenre(id, name);

                if (ret) {
                    mesid = "200";
                } else {
                    mesid = "201";
                }
            } else if (action.equals("Delete")) {
                int id = Integer.parseInt(request.getParameter("id"));

                boolean ret = cgm.deleteGenre(id);

                if (ret) {
                    mesid = "300";
                } else {
                    mesid = "301";
                }
            }
        }

        try {
            cgm.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenreManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getRequestURI() + "?mesid=" + mesid);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

//processRequest(request, response);

