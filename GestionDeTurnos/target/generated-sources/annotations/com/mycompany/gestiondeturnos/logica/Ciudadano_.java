package com.mycompany.gestiondeturnos.logica;

import com.mycompany.gestiondeturnos.logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-27T12:19:33")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile SingularAttribute<Ciudadano, String> apellido;
    public static volatile SingularAttribute<Ciudadano, Long> id;
    public static volatile ListAttribute<Ciudadano, Turno> listTurnos;
    public static volatile SingularAttribute<Ciudadano, String> telefono;
    public static volatile SingularAttribute<Ciudadano, String> nombre;
    public static volatile SingularAttribute<Ciudadano, String> dni;

}