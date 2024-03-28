package com.mycompany.gestiondeturnos.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaTurno;

    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;

    @OneToOne
    private Tramite tramite;
    private boolean atendido;

    public Turno() {
    }

    public Turno(LocalDate fechaTurno, Ciudadano unCiudadano, Tramite unTramite, boolean atendido) {

        this.fechaTurno = fechaTurno;

        this.ciudadano = unCiudadano;
        this.tramite = unTramite;
        this.atendido = atendido;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Ciudadano getUnCiudadano() {
        return ciudadano;
    }

    public void setUnCiudadano(Ciudadano unCiudadano) {
        this.ciudadano = unCiudadano;
    }

    public Tramite getUnTramite() {
        return tramite;
    }

    public void setUnTramite(Tramite unTramite) {
        this.tramite = unTramite;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

}