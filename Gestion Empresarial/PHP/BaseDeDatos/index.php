<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de la base de datos</title>
    </head>
    <body>
        <?php
        //Conexión a mysql
        if ($dbc = mysqli_connect('localhost', 'root')) {
            print '<p>Conexión exitosa </p>';
            //Creación de la base de datos
            if (mysqli_query($dbc, 'CREATE DATABASE myblog')) {
                print '<p>La base de datos ha sido creada!</p>';
            } else {
                print '<p style="color:red;">No ha sido posible crear la base de datos porque: <br/>' .
                        mysqli_error($dbc) . '</p>';
            }
            //Seleccionamos la base de datos
            if (mysqli_select_db($dbc, 'myblog')) {
                print '<p> La base de datos ha sido seleccionada </p>';
            } else {
                print '<p style="color:red;">No ha sido posible seleccionar la base de datos porque: <br/>' .
                        mysqli_error($dbc) . '</p>';
            }
            mysqli_close($dbc);
        } else {
            print '<p style="color:red;">No ha sido posible realizar la conexión: <br/>' .
                    mysqli_error($dbc) . '</p>';
        }
        ?>
    </body