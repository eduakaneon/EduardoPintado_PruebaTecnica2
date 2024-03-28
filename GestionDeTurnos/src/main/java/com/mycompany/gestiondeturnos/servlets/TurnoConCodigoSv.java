package com.mycompany.gestiondeturnos.servlets;

import com.mycompany.gestiondeturnos.logica.Controladora;
import com.mycompany.gestiondeturnos.logica.Tramite;
import com.mycompany.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoConCodigoSv", urlPatterns = {"/TurnoConCodigoSv"})
public class TurnoConCodigoSv extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fechaStr = request.getParameter("fecha");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fechaStr, formatter);

        Turno turno = new Turno();
        turno.setFechaTurno(fecha);
        Tramite tramite = new Tramite();
        tramite.setDescripcion(request.getParameter("tramite"));

        String cod = request.getParameter("codigo");
        
        // Validación del código de ciudadano
        if (cod == null || cod.isEmpty()) {
            response.sendRedirect("errorConCodigo.jsp");
            return;
        }

        try {
            Long codigo = Long.parseLong(cod);

            // Intentar crear el turno con el código de ciudadano proporcionado
            if (controladora.crearTurnoConCodigo(codigo, turno, tramite)) {
                request.setAttribute("codigo", turno.getUnCiudadano().getId());
                request.setAttribute("numero", turno.getNumero());
                request.setAttribute("id", turno.getId());
                request.setAttribute("fecha", turno.getFechaTurno());
                request.setAttribute("nombre", turno.getUnCiudadano().getNombre());
                request.setAttribute("apellido", turno.getUnCiudadano().getApellido());

                RequestDispatcher dispatcher = request.getRequestDispatcher("resultado2.jsp");
                dispatcher.forward(request, response);
            } else {
                // Si no se puede crear el turno, redirigir a la página de error
                response.sendRedirect("errorConCodigo.jsp");
            }
        } catch (NumberFormatException e) {
            // Si el código de ciudadano no es un número válido, redirigir a la página de error
            response.sendRedirect("errorConCodigo.jsp");
        } catch (Exception e) {
            // Manejo genérico de otras excepciones que puedan ocurrir
            e.printStackTrace(); // Manejo adecuado de la excepción depende del contexto
            response.sendRedirect("errorConCodigo.jsp");
        }
    }
    
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}