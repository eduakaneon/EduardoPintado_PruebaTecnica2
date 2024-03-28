package com.mycompany.gestiondeturnos.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.gestiondeturnos.logica.Ciudadano;
import com.mycompany.gestiondeturnos.logica.Controladora;
import com.mycompany.gestiondeturnos.logica.Tramite;
import com.mycompany.gestiondeturnos.logica.Turno;

@WebServlet(name = "TurnoSinCodigoSv", urlPatterns = {"/TurnoSinCodigoSv"})
public class TurnoSinCodigoSv extends HttpServlet {

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
    Ciudadano ciudadano = new Ciudadano();
    Turno turno = new Turno();
    Tramite tramite = new Tramite();
    String fechaStr = request.getParameter("fecha");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate fecha = LocalDate.parse(fechaStr, formatter);
    ciudadano.setNombre(request.getParameter("nombre"));
    ciudadano.setApellido(request.getParameter("apellido"));
    ciudadano.setTelefono(request.getParameter("telefono"));
    ciudadano.setDni(request.getParameter("dni"));
    turno.setAtendido(false);
    turno.setFechaTurno(fecha);
    tramite.setDescripcion(request.getParameter("tramite"));

    // Verificar si el ciudadano ya existe en la base de datos
    Ciudadano ciudadanoExistente = controladora.mostrarIdCiudadano(ciudadano.getNombre(), ciudadano.getApellido(), ciudadano.getDni());
    if (ciudadanoExistente != null) {
        // Si el ciudadano ya existe, redirigir al usuario al proceso de creación de turno con código
        request.setAttribute("ciudadano", ciudadanoExistente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pedirTurnoConCodigo.jsp");
        dispatcher.forward(request, response);
        return; // Detener el flujo para evitar la creación duplicada de turnos
    }

    // Si el ciudadano no existe, proceder con la creación normal del turno
    if (controladora.crearTurnoSinCodigo(ciudadano, turno, tramite)) {
        // Mostrar mensaje de éxito
        request.setAttribute("mensaje", "Turno reservado con éxito! Recuerde esta información ya que resultará importante.");

        // Setear los atributos para mostrar los datos del ciudadano creado
        request.setAttribute("codigo", ciudadano.getId());
        request.setAttribute("numero", turno.getNumero());
        request.setAttribute("id", turno.getId());
        request.setAttribute("fecha", turno.getFechaTurno());
        request.setAttribute("nombre", ciudadano.getNombre());
        request.setAttribute("apellido", ciudadano.getApellido());

        // Redirigir al usuario a Resultado.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("Resultado.jsp");
        dispatcher.forward(request, response);
    } else {
        // Si no se ha podido crear el turno, redirigir al usuario a la página de éxito y mostrar un mensaje indicando que el turno no se pudo crear
        request.setAttribute("mensaje", "El turno no se pudo crear. Por favor, inténtelo de nuevo.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Resultado.jsp");
        dispatcher.forward(request, response);
    }
}

   

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}