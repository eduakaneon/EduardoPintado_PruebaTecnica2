<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Turno - Gestor de Turnos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
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
        p {
            margin-bottom: 10px;
        }
        .btn-container {
            text-align: center;
        }
        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Detalle del Turno</h2>
        <p>Código de Usuario: <%= request.getAttribute("codigo") %></p>
        <p>Número de Turno: <%= request.getAttribute("numero") %></p>
        <p>Fecha del Turno: <%= request.getAttribute("fecha") %></p>
        <p>Nombre del Ciudadano: <%= request.getAttribute("nombre") %> <%= request.getAttribute("apellido") %></p>
        <p>ID del Turno: <%= request.getAttribute("id") %></p>
        <div class="btn-container">
            <a href="index.jsp" class="btn">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
