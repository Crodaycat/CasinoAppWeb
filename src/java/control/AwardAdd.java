/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Award;
import model.AwardPK;
import model.MachineType;

/**
 *
 * @author luis.giraldo10
 */
@WebServlet(name = "AwardAdd", urlPatterns = {"/AwardAdd"})
public class AwardAdd extends HttpServlet {

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
            int machineTypeId = Integer.parseInt(request.getParameter("machineType"));
            float price = Float.parseFloat(request.getParameter("price"));
            String description = request.getParameter("description");
            
            Award award = new Award();
            
            EntityManager em;
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CasinoAppWebPU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            AwardPK awardPK = new AwardPK(0, price);
            award.setAwardPK(awardPK);
            MachineType machineType = em.find(MachineType.class, machineTypeId);
            award.setMachineType(machineType);
            award.setDescription(description);
            
            em.persist(award);
            em.getTransaction().commit();
            em.close();
            
            request.getSession().setAttribute("message", "Machine succesfull created.");
            response.sendRedirect("addAward.jsp");
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
