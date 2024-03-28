<%@page import="java.util.List"%>
<%@page import="com.mycompany.gestiondeturnos.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar Turnos por Fecha</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            color: #333;
            text-align: center;
        }
        form {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="date"] {
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Listar Turnos por Fecha</h1>
        <form action="ListarTurnosPorFechaSv" method="get">
            <label for="fecha">Selecciona una fecha:</label>
            <input type="date" id="fecha" name="fecha" required>
            <button type="submit">Buscar</button>
        </form>

        <%-- Aquí se mostrarán los resultados si los hay --%>
        <% if (request.getAttribute("turno") != null) { %>
            <h2>Turnos para la fecha seleccionada:</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Turno</th>
                        <th>Codigo</th>
                        <th>ID_Turno</th>
                        <th>Ciudadano</th>
                        <th>Trámite</th>
                        <th>Atendido</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Turno> turnos = (List<Turno>) request.getAttribute("turno");
                    for (Turno turno : turnos) { %>
                        <tr>
                            <td><%= turno.getNumero() %></td>
                            <td><%= turno.getUnCiudadano().getId() %></td>
                            <td><%= turno.getUnTramite().getId() %></td>
                            <td><%= turno.getUnCiudadano().getNombre() + " " + turno.getUnCiudadano().getApellido() %></td>
                            <td><%= turno.getUnTramite().getDescripcion() %></td>
                            <td><%= turno.isAtendido() ? "Sí" : "No" %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>

        <form action="index.jsp">
            <button type="submit">Volver al Menú Principal</button>
        </form>
    </div>
</body>
</html>