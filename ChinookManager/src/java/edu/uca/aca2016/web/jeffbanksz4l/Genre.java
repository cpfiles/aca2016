/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uca.aca2016.web.jeffbanksz4l;

import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.uca.aca2016.chinook.jeffbanksz4l.ChinookGenreManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffb
 */
public class Genre extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {

            ChinookGenreManager cm = new ChinookGenreManager();
            HashMap<Integer, String> genres = cm.getGenres();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Chinook Genre Manager</title>");
            out.println("<style>body { font-family: Times New Roman, Verdana, sans-serif; }</style>");
            out.println("</head>");
            out.println("<body>");

            if (!message.isEmpty()) {
                out.println("<span style='color: green;'>" + message + "</span>");
            }

            if (dothis != null && dothis.equals("Delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = cm.getGenreName(id);

                out.println("<h1>Delete Genre</h1>");
                out.println("<form method=\"post\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
                out.println("Are you sure you want to delete genre \"" + name + "\"?");
                out.println("<input type=\"submit\" value=\"Delete\" name=\"action\">");
                out.println("</form>");
            } else if (dothis != null && dothis.equals("Edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = cm.getGenreName(id);

                out.println("<h1>Edit Genre</h1>");
                out.println("<form method=\"post\">");
                out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
                out.println("Genre Name: <input type=\"text\" name=\"name\" value=\"" + name + "\">");
                out.println("<input type=\"submit\" value=\"Edit\" name=\"action\">");
                out.println("</form>");
            } else {
                out.println("<h1>Add a Genre</h1>");
                out.println("<form method=\"post\">");
                out.println("Genre Name: <input type=\"text\" name=\"name\">");
                out.println("<input type=\"submit\" value=\"Add\" name=\"action\">");
                out.println("</form>");
            }

            out.println("<h1>Manage Genre</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Action</th></tr>");

            for (Map.Entry<Integer, String> genre : genres.entrySet()) {
                out.println("<tr><td>" + genre.getKey() + "</td><td>" + genre.getValue()
                        + "</td><td><a href='?do=Edit&id=" + genre.getKey()
                        + "'>Edit</a> <a href='?do=Delete&id=" + genre.getKey() + "'>Delete</a></td></tr>");
            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            cm.close();
        } catch (SQLException ex) {
            logger.severe("SQL Exception: " + ex.getMessage());
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
                        Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
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
