package com.mycompany.gestiondeturnos.servlets;

import com.mycompany.gestiondeturnos.logica.Controladora;
import com.mycompany.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModificarAtendidosSv", urlPatterns = {"/ModificarAtendidosSv"})
public class ModificarAtendidosSv extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        Turno turno = controladora.traerTurno(Long.valueOf(request.getParameter("id")));

        request.setAttribute("turno", turno);
        request.getRequestDispatcher("modificarAtendidos.jsp").forward(request, response);

    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtener el ID del turno y su estado de atendido del formulario
    long turnoId = Long.parseLong(request.getParameter("turnoId"));
    boolean esAtendido = Boolean.parseBoolean(request.getParameter("atendido"));

    // Obtener el turno desde la base de datos
    Turno turno = controladora.traerTurno(turnoId);

    if (turno != null) {
        // Cambiar el estado de atendido del turno
        turno.setAtendido(esAtendido);

        try {
            // Guardar los cambios en la base de datos
            controladora.modificarTurno(turno);
            // Establecer el mensaje de éxito
            request.setAttribute("mensaje", "Estado de atendido modificado con éxito.");
        } catch (Exception ex) {
            Logger.getLogger(ModificarAtendidosSv.class.getName()).log(Level.SEVERE, null, ex);
            // En caso de error, establecer un mensaje de error
            request.setAttribute("mensaje", "Error al modificar el estado de atendido del turno.");
        }
    } else {
        // El turno no se encontró en la base de datos
        // Establecer un mensaje de error
        request.setAttribute("mensaje", "Error: El turno especificado no se encontró en la base de datos.");
    }

    // Redirigir a la página de mensaje
    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
