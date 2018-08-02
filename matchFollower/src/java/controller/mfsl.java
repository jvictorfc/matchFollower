/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import entities.Match;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import services.Utility;

/**
 *
 * @author jvict
 */
public class mfsl extends HttpServlet {

    private List<AsyncContext> contexts = new LinkedList<>();
            Gson gson = new Gson();
            ArrayList<Match> matches = Utility.getMatches();
            String jsonReady = gson.toJson(matches);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getLocale());
        response.setContentType("text/html;charset=UTF-8");
            ServletContext apli = request.getServletContext();
            apli.setAttribute("matchs", jsonReady);    
        String action = "";
        action = request.getParameter("action");
        String url = "";
        //Showing all matches
        if (action.equalsIgnoreCase("matches")) {
            response.setContentType("text/plain");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write(jsonReady);
        } else {
            if (action.equalsIgnoreCase("result")) {
                int team = Integer.parseInt(request.getParameter("team"));
                String func = request.getParameter("func");
                int match = Integer.parseInt(request.getParameter("id"));
                int score = Utility.changeScore(func, match, team);
                Gson gson = new Gson();
                matches = Utility.getMatches();
                jsonReady = gson.toJson(matches);

                for (AsyncContext asyncContext : contexts) {
                    try (PrintWriter writer = asyncContext.getResponse().getWriter()) {
                        writer.println(jsonReady);
                        writer.flush();
                        asyncContext.complete();
                    } catch (Exception ex) {
                    }
                }
            }
        }
        if (action.equalsIgnoreCase("push")) {
            final AsyncContext asyncContext = request.startAsync(request, response);
            asyncContext.setTimeout(10 * 60 * 1000);
            contexts.add(asyncContext);
        }
    }

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
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
