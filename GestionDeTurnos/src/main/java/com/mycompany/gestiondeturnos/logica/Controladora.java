package com.mycompany.gestiondeturnos.logica;

import com.mycompany.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Controladora {

    ControladoraPersistencia controladoraP = new ControladoraPersistencia();

    public void crearTurno(Turno turno) {
        controladoraP.crearTurno(turno);
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        controladoraP.crearCiudadano(ciudadano);
    }

    public void crearTramite(Tramite tramite) {
        controladoraP.crearTramite(tramite);
    }

    public boolean crearTurnoSinCodigo(Ciudadano ciudadano, Turno turno, Tramite tramite) {
        return controladoraP.crearTurnoSinCodigo(ciudadano, turno, tramite);
    }

    public boolean crearTurnoConCodigo(Long codigo, Turno turno, Tramite tramite) {
        return controladoraP.crearTurnoConCodigo(codigo, turno, tramite);
    }

    public Ciudadano traerCiudadano(Long id) {
        return controladoraP.traerCiudadano(id);
    }

    public Turno traerTurno(Long id) {
        return controladoraP.traerTurno(id);
    }

    public void modificarTurno(Turno turno) throws Exception {
        controladoraP.modificarTurno(turno);
    }

    public ArrayList<Turno> mostrarTurnosPorFecha(String fecha) {
        return controladoraP.mostrarTurnosPorFecha(fecha);
    }

    public ArrayList<Turno> mostrarTurnosPorAtendido(String fecha, Boolean atendido) {
        return (ArrayList<Turno>) controladoraP.mostrarTurnosPorAtendido(fecha, atendido);
    }

    public void actualizarEstadoAtendido(List<Long> turnoId, List<Boolean> atendido) {

        controladoraP.actualizarEstadoAtendido(turnoId, atendido);
    }

    public Ciudadano mostrarCiudadano(Long id) {

        return controladoraP.mostrarCiudadano(id);
    }

    public Ciudadano mostrarIdCiudadano(String nombre, String apellido, String dni) {
        return controladoraP.mostrarIdCiudadano(nombre, apellido, dni);
    }

    public ArrayList<Turno> obtenerTodosLosTurnos() {
        return controladoraP.obtenerTodosLosTurnos();
    }

    public ArrayList<Turno> filtrarTurnos(ArrayList<Turno> todosLosTurnos, String fecha, boolean atendido) {
        // Filtrar los turnos por fecha y estado
        return todosLosTurnos.stream()
                .filter(turno -> turno.isAtendido() == atendido)
                .filter(turno -> fecha == null || fecha.isEmpty() || turno.getFechaTurno().equals(fecha))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Turno> mostrarTurnosPorAtendidoYFecha(String fecha, boolean atendido) {
        return controladoraP.mostrarTurnosPorAtendidoYFecha(fecha, atendido);
    }

}
