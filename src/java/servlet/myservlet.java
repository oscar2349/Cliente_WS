package servlet;

import Services.SumarNumeros_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

@WebServlet(name = "myservlet", urlPatterns = {"/myservlet"})
public class myservlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServiceSuma/SumarNumeros.wsdl")
    private SumarNumeros_Service service;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myservlet</title>");
            out.println("</head>");
            out.println("<body>");
            int n1 = Integer.parseInt(request.getParameter("Numero1"));
            int n2 = Integer.parseInt(request.getParameter("Numero2"));
            out.println("<h4>La Suma de los Numero indicados es: " + sumar(n1,n2) + "</h4>");
            out.println("<h4>La Resta de los Numero indicados es: " + resta(n1, n2)+ "</h4>");
            out.println("<h4>La Multiplicacion de los Numero indicados es: " + multiplicacion(n1, n2)+ "</h4>");
            out.println("</body>");
            out.println("</html>");
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
        
        LOG.info("Se ingreso al metodo GET");
    }
    private static final Logger LOG = Logger.getLogger(myservlet.class.getName());

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
       
        //processRequest(request, response);
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

    private int sumar(int numero1, int numero2) {

        Services.SumarNumeros port = service.getSumarNumerosPort();
        return port.sumar(numero1, numero2);
    }

    private int resta(int numero1, int numero2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Services.SumarNumeros port = service.getSumarNumerosPort();
        return port.resta(numero1, numero2);
    }

    private int multiplicacion(int numero1, int numero2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Services.SumarNumeros port = service.getSumarNumerosPort();
        return port.multiplicacion(numero1, numero2);
    }
    
    

}
