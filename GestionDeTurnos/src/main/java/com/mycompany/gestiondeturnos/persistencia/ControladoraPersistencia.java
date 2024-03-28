package com.mycompany.gestiondeturnos.persistencia;

import com.mycompany.gestiondeturnos.CiudadanoJpaController;
import com.mycompany.gestiondeturnos.TramiteJpaController;
import com.mycompany.gestiondeturnos.TurnoJpaController;
import com.mycompany.gestiondeturnos.logica.Ciudadano;
import com.mycompany.gestiondeturnos.logica.Tramite;
import com.mycompany.gestiondeturnos.logica.Turno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ControladoraPersistencia {

    TurnoJpaController turnoJpa = new TurnoJpaController();
    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    TramiteJpaController tramiteJpa = new TramiteJpaController();

    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }

    public void crearTramite(Tramite tramite) {
        tramiteJpa.create(tramite);
    }

    public Turno traerTurno(Long id) {
        return turnoJpa.findTurno(id);
    }

    public void modificarTurno(Turno turno) throws Exception {
        turnoJpa.edit(turno);
    }

    public boolean crearTurnoSinCodigo(Ciudadano ciudadano, Turno turno, Tramite tramite) {

        List<Ciudadano> listaCompro = ciudadanoJpa.findCiudadanoEntities();

        //uso de stream para obtener el ciudadano que tenga el mismo nombre, apellido y dni introducido en la pagina para crear turno si no tienes codigo
        listaCompro = listaCompro.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(ciudadano.getNombre())
                && c.getApellido().equalsIgnoreCase(ciudadano.getApellido())
                && c.getDni().equalsIgnoreCase(ciudadano.getDni()))
                .collect(Collectors.toList());

        //si el ciudadano no existe, crea el turno, ciudadano y tramite
        if (listaCompro.isEmpty()) {

            ciudadanoJpa.create(ciudadano);
            turno.setAtendido(false);
            turno.setUnCiudadano(ciudadano);
            tramiteJpa.create(tramite);
            turno.setUnTramite(tramite);

            List<Turno> listaTurnosPorFecha = turnoJpa.findTurnoEntities();
            Long cont = listaTurnosPorFecha.stream().filter(t -> t.getFechaTurno().equals(turno.getFechaTurno())).count();
            Integer contParsed = 1;
            contParsed = contParsed + cont.intValue();

            turno.setNumero(contParsed);
            turnoJpa.create(turno);
            return true;
        } else {
            // si el ciudadano existe, devuelve false, lo que te redirigirá a la pagina de error (TurnoSinCodigoSv -> doPost)
            return false;
        }

    }

    public boolean crearTurnoConCodigo(Long codigo, Turno turno, Tramite tramite) {

        Ciudadano ciudadano = new Ciudadano();
        //se comprueba si el ciudadano con el codigo introducido existe
        if (ciudadanoJpa.findCiudadano(codigo) != null) {
            ciudadano = ciudadanoJpa.findCiudadano(codigo);
            //si existe se crea el turno
            turno.setUnCiudadano(ciudadano);
            List<Turno> listaTurnosPorFecha = turnoJpa.findTurnoEntities();
            Long cont = listaTurnosPorFecha.stream().filter(t -> t.getFechaTurno().equals(turno.getFechaTurno())).count();
            Integer contParsed = 1;
            contParsed = contParsed + cont.intValue();

            tramiteJpa.create(tramite);
            turno.setNumero(contParsed);
            turno.setUnTramite(tramite);
            turno.setAtendido(false);
            turnoJpa.create(turno);

            return true;
        } else {
            //si no se devuelve falso y se reenvia a la pagina de error (TurnoConCodigoSv -> doPost)
            return false;
        }

    }

    public Ciudadano traerCiudadano(Long id) {
        Ciudadano ciudadano = new Ciudadano();
        if (ciudadanoJpa.findCiudadano(id) != null) {
            ciudadano = ciudadanoJpa.findCiudadano(id);
            return ciudadano;
        }
        return ciudadano;
    }

     public ArrayList<Turno> mostrarTurnosPorFecha(String fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaBuscada = LocalDate.parse(fecha, formatter);

        List<Turno> listadoTurnos = turnoJpa.findTurnoEntities();

        List<Turno> listaTurnosConFechaDada = listadoTurnos.stream()
                .filter(turno -> turno.getFechaTurno().equals(fechaBuscada))
                .collect(Collectors.toList());
        ArrayList<Turno> arrayTurnosConFechaDada = new ArrayList<>(listaTurnosConFechaDada);
        return arrayTurnosConFechaDada;
    }


    public List<Turno> mostrarTurnosPorAtendido(String fecha, boolean atendido) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaBuscada = LocalDate.parse(fecha, formatter);

        List<Turno> listadoTurnos = turnoJpa.findTurnoEntities();

        return listadoTurnos.stream()
                .filter(turno -> turno.getFechaTurno().equals(fechaBuscada) && turno.isAtendido() == atendido)
                .collect(Collectors.toList());
    }

 

    public void actualizarEstadoAtendido(List<Long> turnoIds, List<Boolean> atendidoValues) {
        try {

            for (int i = 0; i < turnoIds.size(); i++) {
                Long turnoId = turnoIds.get(i);
                boolean atendido = atendidoValues.get(i);

                Turno turno = turnoJpa.findTurno(turnoId);

                if (turno != null) {
                    turno.setAtendido(atendido);
                    turnoJpa.edit(turno);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Ciudadano mostrarCiudadano(Long id) {
        return ciudadanoJpa.findCiudadano(id);
    }

    public Ciudadano mostrarIdCiudadano(String nombre, String apellido, String dni) {
        List<Ciudadano> listaCompro = ciudadanoJpa.findCiudadanoEntities();
        Ciudadano ciudadano;
        ciudadano = listaCompro.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre)
                && c.getApellido().equalsIgnoreCase(apellido)
                && c.getDni().equalsIgnoreCase(dni))
                .findFirst().orElse(null);

        return ciudadano;
    }

    public ArrayList<Turno> obtenerTodosLosTurnos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestorTurnosPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Turno> query = entityManager.createQuery("SELECT t FROM Turno t", Turno.class);
            return new ArrayList<>(query.getResultList());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public ArrayList<Turno> mostrarTurnosPorAtendidoYFecha(String fecha, boolean atendido) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestorTurnosPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Turno> query = entityManager.createQuery(
                    "SELECT t FROM Turno t WHERE t.atendido = :atendido AND t.fecha = :fecha", Turno.class);
            query.setParameter("atendido", atendido);
            query.setParameter("fecha", fecha);
            return new ArrayList<>(query.getResultList());
        } finally {
            entityManager.close();
        }

    }
}
/*public ArrayList<Turno> mostrarTurnosPorAtendido(String fecha, String atendido) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaBuscada = LocalDate.parse(fecha, formatter);

        boolean esAtendido = Boolean.parseBoolean(atendido);
        List<Turno> listadoTurnos = turnoJpa.findTurnoEntities();

        List<Turno> listaTurnosFiltrados = listadoTurnos.stream().filter(t -> t.getFechaTurno().equals(fechaBuscada)).filter(t -> t.isAtendido() == esAtendido).collect(Collectors.toList());
        ArrayList<Turno> arrayTurnosFiltrados = new ArrayList<>(listaTurnosFiltrados);
        return arrayTurnosFiltrados;
    }*/
 /*  public List<Turno> mostrarTurnosPorAtendido(String fecha, boolean atendido) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("GestorTurnosPU");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT t FROM Turno t WHERE t.atendido = :atendido";

            // Agregar la condición de fecha si se proporciona
            if (fecha != null && !fecha.isEmpty()) {
                jpql += " AND t.fecha = :fecha";
            }

            TypedQuery<Turno> query = entityManager.createQuery(jpql, Turno.class);
            query.setParameter("atendido", atendido);

            // Configurar el parámetro de fecha si se proporciona
            if (fecha != null && !fecha.isEmpty()) {
                query.setParameter("fecha", fecha);
            }

            return query.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }*/
 /*  public ArrayList<Turno> mostrarTurnosPorAtendido(String fecha, boolean atendido) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("GestorTurnosPU");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT t FROM Turno t WHERE t.atendido = :atendido";

            // Agregar la condición de fecha si se proporciona
            if (fecha != null && !fecha.isEmpty()) {
                jpql += " AND t.fechaTurno = :fecha";
            }

            TypedQuery<Turno> query = entityManager.createQuery(jpql, Turno.class);
            query.setParameter("atendido", atendido ? 1 : 0); // Convertir booleano a int

            // Configurar el parámetro de fecha si se proporciona
            if (fecha != null && !fecha.isEmpty()) {
                query.setParameter("fecha", fecha);
            }

            // Convertir el resultado de la consulta a ArrayList
            List<Turno> resultList = query.getResultList();
            ArrayList<Turno> turnos = new ArrayList<>(resultList);
            return turnos;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }*/