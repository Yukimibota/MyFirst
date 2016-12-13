/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.servlet;

import FYP.bean.DetectedObject;
import FYP.bean.ObjectPoint;
import FYP.db.FYPDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author Yukimibota
 */
@WebServlet(name = "HandlePhoto", urlPatterns = {"/HandlePhoto"})
public class HandlePhoto extends HttpServlet {
    private FYPDB db = new FYPDB();
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
        Vector<DetectedObject> objects = new Vector<DetectedObject>();
        Vector<ObjectPoint> objectPoints = new Vector<ObjectPoint>();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String photo = (String) request.getAttribute("photo");
            //String object = (String) request.getAttribute("object");
            String object = "[{\"x\":1,\"y\":2,\"length\":10,\"width\":20}]";
            JSONArray arr = new JSONArray(object);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject jOb = arr.getJSONObject(i);
                DetectedObject ob = new DetectedObject(jOb.getDouble("x"), jOb.getDouble("y"),
                        jOb.getDouble("length"), jOb.getDouble("width"));
                objectPoints.add(ob.getObjectPoint());
                objects.add(ob);
            }
            
            db.uploadPhotoData(objects, objectPoints);
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
