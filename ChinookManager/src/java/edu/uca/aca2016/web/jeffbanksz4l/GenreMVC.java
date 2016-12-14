/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.web.jeffbanksz4l;

import edu.uca.aca2016.chinook.jeffbanksz4l.ChinookGenreManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeffb
 */
public class GenreMVC extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mid = request.getParameter("mid");
        String dothis = request.getParameter("do");
        String message = "";

        if (mid == null || mid.isEmpty()) {
            message = "";
        } else if (mid.equals("100")) {
            message = "Genre was added to database";
        } else if (mid.equals("101")) {
            message = "Genre was not added, name value was empty or incorrect.";
        } else if (mid.equals("200")) {
            message = "Genre was updated";
        } else if (mid.equals("201")) {
            message = "Genre was not updated, name value was empty or incorrect or id was missing.";
        } else if (mid.equals("300")) {
            message = "Genre was deleted";
        } else if (mid.equals("301")) {
            message = "Genre was not deleted.";
        }

        ChinookGenreManager cm = new ChinookGenreManager();
        HashMap<Integer, String> genres = cm.getGenres();

        request.setAttribute("genres", genres);
        request.setAttribute("dothis", dothis);
        request.setAttribute("message", message);

        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            try {
                request.setAttribute("id", id);
                request.setAttribute("genre_name", cm.getGenreName(Integer.parseInt(id)));
            } catch (SQLException ex) {
                Logger.getLogger(GenreMVC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/jb_genre_mvc.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String mid = "";

        ChinookGenreManager cm = new ChinookGenreManager();

        if (action != null && !action.isEmpty()) {
            if (action.equals("Add")) {
                String name = request.getParameter("name");

                if (name == null || name.isEmpty()) {
                    mid = "101";
                } else {
                    try {
                        cm.addGenre(name);
                        mid = "100";
                    } catch (SQLException ex) {
                        Logger.getLogger(GenreMVC.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (action.equals("Edit")) {
                try {
                    String name = request.getParameter("name");
                    int id = Integer.parseInt(request.getParameter("id"));

                    boolean ret = cm.updateGenre(id, name);

                    if (ret) {
                        mid = "200";
                    } else {
                        mid = "201";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GenreMVC.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equals("Delete")) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));

                    boolean ret = cm.deleteGenre(id);

                    if (ret) {
                        mid = "300";
                    } else {
                        mid = "301";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GenreMVC.class.getName()).log(Level.SEVERE, null, ex);
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
