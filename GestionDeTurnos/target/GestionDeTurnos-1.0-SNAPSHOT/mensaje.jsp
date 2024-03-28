<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mensaje del Servidor</title>
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
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        .success-message {
            background-color: #d4edda;
            color: #155724;
            padding: 10px;
            margin-bottom: 10px;
            text-align: center;
            border-radius: 5px;
        }
        .error-message {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            margin-bottom: 10px;
            text-align: center;
            border-radius: 5px;
        }
        button {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Mensaje del Servidor</h1>
        <%-- Mostrar mensaje de éxito si está presente --%>
        <% if (request.getAttribute("mensaje") != null) { %>
            <div class="success-message">
                <%= request.getAttribute("mensaje") %>
            </div>
        <% } else if (request.getAttribute("error") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>
        <%-- Agregar un botón para volver a la página principal --%>
        <form action="index.jsp">
            <button type="submit">Volver a Inicio</button>
        </form>
    </div>
</body>
</html>
