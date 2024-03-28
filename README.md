# EduardoPintado_PruebaTec2


# GestionDeTurnos

Este proyecto de gestión de turnos está diseñado para ayudar a gestionar los turnos de atención al público en una institución. Proporciona funcionalidades para la creación de turnos, seguimiento de su estado y filtrado por fecha.

## Supuestos

1. La aplicación se utiliza para gestionar turnos de atención al público en una institución determinada.
2. Cada turno está asociado a un ciudadano y a un trámite.
3. Los turnos pueden tener dos estados: "En Espera" y "Ya Atendidos".
4. Los usuarios pueden filtrar los turnos por fecha y estado de atención.

## Funcionamiento

El proyecto consta de las siguientes partes:

1. **Servlets**: Contienen la lógica para manejar las solicitudes HTTP y realizar las operaciones necesarias en el backend.
2. **Controladoras**: Lógica de negocio que interactúa con la capa de persistencia y realiza operaciones como crear, modificar y filtrar turnos.
3. **Persistencia**: Capa de acceso a datos que utiliza JPA para interactuar con la base de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de turnos.
4. **JSP (JavaServer Pages)**: Vistas web que muestran la información al usuario y permiten realizar acciones como filtrar turnos por fecha.

## Funcionalidades Implementadas

1. Creación de turnos.
2. Visualización de turnos por fecha.
3. Filtro de turnos por fecha.
4. Vista de detalles de turno.

## Funcionalidades Pendientes

La funcionalidad de filtrar turnos por estado de atención aún no ha sido implementada. Esta característica permitirá a los usuarios filtrar los turnos según su estado de atención ("En Espera" o "Ya Atendidos"). Se ha tratado de resolver de diferentes maneras como se podrá observar en el codigo comentado, pero no se ha llegado a una solución definitiva.

## Configuración del Proyecto

1. Clonar el repositorio desde GitHub.
2. Importar el proyecto en un IDE compatible con Java EE, como Eclipse o IntelliJ IDEA.
3. Configurar la base de datos según la configuración definida en `persistence.xml`.
4. Desplegar la aplicación en un servidor web compatible, como Apache Tomcat.

## Tecnologías Utilizadas

- Java
- Java EE (Servlets, JSP)
- JPA (Java Persistence API)
- HTML
- CSS






