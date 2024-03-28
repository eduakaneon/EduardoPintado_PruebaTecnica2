<%@page import="java.util.List"%>
<%@page import="com.mycompany.gestiondeturnos.logica.Turno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resultados</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }
            form {
                max-width: 400px;
                margin: 50px auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 5px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }
            h2 {
                color: #333;
                text-align: center;
                margin-bottom: 20px;
            }
            label {
                display: block;
                margin-bottom: 10px;
            }
            input[type="number"],
            input[type="checkbox"] {
                margin-bottom: 20px;
            }
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #ffffff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <h1>Resultados del Filtrado</h1>

        <!-- Mostrar resultados en una tabla -->
        <table>
            <tr>
                <th>Fecha del Turno</th>
                <th>Estado del Turno</th>
                <!-- Agrega más encabezados según los campos que deseas mostrar -->
            </tr>
            <%
                // Obtener la lista de turnosFiltrados desde el atributo request
                List<Turno> turnosFiltrados = (List<Turno>) request.getAttribute("turnosFiltrados");

                // Iterar sobre la lista de turnos y mostrar cada uno en una fila de la tabla
                for (Turno turno : turnosFiltrados) {
            %>
            <tr>
                <td><%= turno.getFechaTurno()%></td>
                <td><%= turno.isAtendido() ? "Ya Atendido" : "En Espera"%></td>
                <!-- Puedes agregar más columnas según los campos que deseas mostrar -->
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>