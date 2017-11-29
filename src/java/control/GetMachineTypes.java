/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MachineType;

/**
 *
 * @author luis.giraldo10
 */
@WebServlet(name = "GetMachineTypes", urlPatterns = {"/GetMachineTypes"})
public class GetMachineTypes extends HttpServlet {

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
            List<MachineType> machines;
            switch (url) {
                case "addMachine":
                    machines = getAllMachines();
                    request.setAttribute("machineTypeList", machines);
                    request.getRequestDispatcher("addMachine.jsp").forward(request, response);
                    break;
                case"getAllMachines":
                    machines = getAllMachines();
                    request.setAttribute("machineTypeList", machines);
                    request.getRequestDispatcher("getAllMachines.jsp").forward(request, response);
                    break;
                case "addAward":
                    machines = getAllMachines();
                    request.setAttribute("machineTypeList", machines);
                    request.getRequestDispatcher("addAward.jsp").forward(request, response);
                    break;
                case "getAllMachineTypes":
                    machines = getAllMachines();
                    request.setAttribute("machineTypeList", machines);
                    request.getRequestDispatcher("getAllMachineTypes.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    break;
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
    
    private List<MachineType> getAllMachines () {
        EntityManager em;
        EntityManagerFactory emf;

        emf = Persistence.createEntityManagerFactory("CasinoAppWebPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<MachineType> machines = em.createNamedQuery("MachineType.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        
        return machines;
    }
    
}
