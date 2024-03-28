package com.mycompany.gestiondeturnos.servlets;



import com.mycompany.gestiondeturnos.logica.Controladora;
import com.mycompany.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarTurnosPorFechaSv", urlPatterns = {"/ListarTurnosPorFechaSv"})
public class ListarTurnosPorFechaSv extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

      List<Turno> turnos = controladora.mostrarTurnosPorFecha(request.getParameter("fecha"));


        turnos.forEach(t -> System.out.println(t.getFechaTurno()));

        request.setAttribute("turno", turnos);
        request.getRequestDispatcher("listarTurnosPorFecha.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}