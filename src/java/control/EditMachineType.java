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
import model.MachineType;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "EditMachineType", urlPatterns = {"/EditMachineType"})
public class EditMachineType extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("id"));
            String url = request.getParameter("url");
            
            MachineType type;
            switch (url) {
                case "edit":
                    type = edit(id);
                    if (type == null) {
                        request.setAttribute("message", "Machine not found. It may not exist.");
                        request.getRequestDispatcher("GetMachineTypes?url=getAllMachineTypes").forward(request, response);
                    }
                    request.setAttribute("type", type);
                    request.getRequestDispatcher("editMachineType.jsp").forward(request, response);
                    break;
                case "save":
                    String description = request.getParameter("description");
                    type = new MachineType(id, description);
                    save(type);
                    
                    request.setAttribute("message", "Machine type edited succesful.");
                    request.setAttribute("type", type);
                    request.getRequestDispatcher("editMachineType.jsp").forward(request, response);
                    
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
    
    private MachineType edit (int id) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CasinoAppWebPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        MachineType type = em.find(MachineType.class, id);

        em.getTransaction().commit();
        em.close();
        
        return type;
    }
    
    private void save (MachineType type) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CasinoAppWebPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(type);

        em.getTransaction().commit();
        em.close();
    }
}
