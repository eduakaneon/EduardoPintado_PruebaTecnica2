<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio - Gestor de Turnos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }
        ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }
        li {
            margin-top: 20px;
        }
        a {
            text-decoration: none;
            color: #007bff;
            background-color: #ffffff;
            padding: 10px 20px;
            border: 1px solid #007bff;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        a:hover {
            background-color: #007bff;
            color: #ffffff;
        }
    </style>
</head>
<body>
    <h1>Bienvenido al Gestor de Turnos</h1>
    <ul>
        <li><a href="pedirTurnoConCodigo.jsp">Pedir turno con código de usuario</a></li>
        <li><a href="pedirTurnoSinCodigo.jsp">Pedir turno sin código de usuario</a></li>
        <li><a href="listarTurnosPorFecha.jsp">Listar turnos por fecha</a></li>
        <li><a href="filtroTurnos.jsp">Filtrado de turnos</a></li>
        <li><a href="modificarAtendidos.jsp">Modificar estado del turno</a></li>
    </ul>
</body>
</html>

