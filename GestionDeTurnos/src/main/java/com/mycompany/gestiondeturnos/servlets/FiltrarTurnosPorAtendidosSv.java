package com.mycompany.gestiondeturnos.servlets;

import com.mycompany.gestiondeturnos.logica.Controladora;
import com.mycompany.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FiltrarTurnosPorAtendidosSv", urlPatterns = {"/FiltrarTurnosPorAtendidosSv"})
public class FiltrarTurnosPorAtendidosSv extends HttpServlet {

    Controladora controladora = new Controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");

        // Convertir el estado a un booleano
        boolean atendido = estado.equals("Ya Atendidos");

        // Filtrar los turnos por fecha y estado
        ArrayList<Turno> turnosFiltrados = controladora.mostrarTurnosPorAtendido(fecha, atendido);

        request.setAttribute("turnosFiltrados", turnosFiltrados);
        request.getRequestDispatcher("ResultadosFiltro.jsp").forward(request, response);
    }
}
    /*   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");

        // Convertir el estado a un booleano (true para Atendidos, false para En Espera)
        boolean atendido = estado.equals("Ya Atendidos");

        // Filtrar los turnos por fecha y estado
        ArrayList<Turno> turnosFiltrados = controladora.mostrarTurnosPorAtendidoYFecha(fecha, atendido);

        request.setAttribute("turnosFiltrados", turnosFiltrados);
        request.getRequestDispatcher("filtroTurnos.jsp").forward(request, response);
    }
}*/
