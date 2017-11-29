/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dealer;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "GetDealer", urlPatterns = {"/GetDealer"})
public class GetDealer extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = request.getParameter("url");
            int id = Integer.parseInt(request.getParameter("id"));
            
            Dealer dealer;
            switch (url) {
                /*case "getAllDealers":
                    dealer = getDealer(id);
                    if (dealer == null) {
                        request.setAttribute("message", "Dealer not found. It may not exist.");
                        request.getRequestDispatcher("getAllDealers.jsp").forward(request, response);
                    }
                    
                    request.setAttribute("dealersList", dealer);
                    request.getRequestDispatcher("getAllDealers.jsp").forward(request, response);
                    break;*/
                case "consultDealer":
                    dealer = getDealer(id);
                    if (dealer == null) {
                        request.setAttribute("message", "Dealer not found. It may not exist.");
                        request.getRequestDispatcher("getAllDealers.jsp").forward(request, response);
                    }
                    ArrayList<Dealer> dealers = new ArrayList<>();
                    dealers.add(dealer);
                    request.setAttribute("dealersList", dealers);
                    request.getRequestDispatcher("getAllDealers.jsp").forward(request, response);
                    
                    break;
                case "editDealer":
                    dealer = getDealer(id);
                    if (dealer == null) {
                        request.setAttribute("message", "Dealer not found. It may not exist.");
                        request.getRequestDispatcher("getAllDealers.jsp").forward(request, response);
                    }
                    request.setAttribute("dealersList", dealer);
                    request.getRequestDispatcher("editDealer.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("dealerManager.jsp");
            }
            
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
    
    private Dealer getDealer (int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CasinoAppWebPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dealer dealer = em.find(Dealer.class, id);

        em.getTransaction().commit();
        em.close();
        
        return dealer;
    }
    
}
