<%@page import="java.util.List"%>
<%@page import="com.mycompany.gestiondeturnos.logica.Turno"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados del Filtrado</title>
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
    <!-- Formulario de filtrado -->
    <form action="FiltrarTurnosPorAtendidosSv" method="post">
        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required>
        <label for="estado">Estado:</label>
        <select id="estado" name="estado" required>
            <option value="En Espera">En Espera</option>
            <option value="Ya Atendidos">Ya Atendidos</option>
        </select>
        <button type="submit">Filtrar</button>
    </form>
</body>
</html>
