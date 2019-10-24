<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear tabla</title>
    </head>
    <body>
        <?php
//Conectarse y seleccionar la base de datos
        if ($dbc = mysqli_connect('localhost', 'root')) {
            if (!mysqli_select_db($dbc, 'myblog')) {
                print '<p style="color:red;">No ha sido posible seleccionar la base de datos porque: <br/>' .
                        mysqli_error($dbc) . '</p>';
                mysqli_close($dbc);
                $dbc = FALSE;
            }
        } else { //fallo en la conexión
            print '<p style="color:red;">No ha sido posible realizar la conexión: <br/>' .
                    mysqli_error($dbc) . '</p>';
        }
        if ($dbc) {
            $query = 'CREATE TABLE entries(
 entry_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(100) NOT NULL,
 entry TEXT NOT NULL,
 date_entered DATETIME NOT NULL
 )';
            //Ejecutar la consulta
            if (mysqli_query($dbc, $query)) {
                print '<p>La tabla ha sido creada</p>';
            } else {
                print '<p style="color:red;">No ha sido posible crear la tabla porque: <br/>' .
                        mysqli_error($dbc) . '</p>';
            }
            mysqli_close($dbc);
        }
        ?>
    </body>
</html>