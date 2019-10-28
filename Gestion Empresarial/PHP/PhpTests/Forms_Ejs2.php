<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php


        ?>
        
        <form action="Forms_Ejs2.php" method="post">
        <p>Rellena el siguiente formulario</p>
        <p>Nombre: <input type="text" name="nombre"/></p>
        <p>Email: <input type="email" name="correo"/></p>
        <p>Contraseña: <input type="password" name="contraseña"/></p>
        <p>Repetir contraseña: <input type="password" name="contraseñaR"/></p>
        <input type="submit" name="send" value="Enviar Datos"/>
        </form>
    </body>
</html>
