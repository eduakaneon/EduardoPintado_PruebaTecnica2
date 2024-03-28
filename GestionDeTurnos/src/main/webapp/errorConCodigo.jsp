<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error - Ciudadano no encontrado</title>
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
            color: #333;
            text-align: center;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .back-btn {
            display: block;
            width: 100px;
            margin: 0 auto;
            padding: 10px 20px;
            text-align: center;
            background-color: #007bff;
            color: #ffffff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Error - Ciudadano no encontrado</h2>
        <p>Ha habido un error en su solicitud. El ciudadano asociado al código proporcionado no ha sido encontrado.</p>
        <a href="pedirTurnoConCodigo.jsp" class="back-btn">Volver</a>
    </div>
</body>
</html>
