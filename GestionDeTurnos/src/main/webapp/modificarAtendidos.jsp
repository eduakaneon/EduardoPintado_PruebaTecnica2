<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Modificar Atendidos</title>
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
        <form action="ModificarAtendidosSv" method="post">
            <h2>Modificar Atendidos</h2>
            <label for="ciudadanoCodigo">Código del Ciudadano:</label>
            <input type="number" id="ciudadanoCodigo" name="ciudadanoCodigo" required>
            <label for="turnoId">ID del Turno:</label>
            <input type="number" id="turnoId" name="turnoId" required>
            <label for="atendido">Atendido:</label>
            <input type="checkbox" id="atendido" name="atendido" value="true">
            <input type="submit" value="Guardar cambios">
        </form>

        <%-- Botón para volver a index.jsp --%>
        <form action="index.jsp">
            <button type="submit">Volver a Inicio</button>
        </form>
    </body>
</html>