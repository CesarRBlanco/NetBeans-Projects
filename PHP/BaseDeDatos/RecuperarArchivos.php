<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver mi blog</title>
    </head>
    <body>
        <?php
        // Este script recupera las entradas de blog de una base de datos
        //Conectar y seleccionar la base de datos
        $dbc = mysqli_connect('localhost', 'root');
        mysqli_select_db($dbc, 'myblog');
        //Definir la consulta
        $query = 'SELECT * FROM entries ORDER BY date_entered DESC';
        if ($r = mysqli_query($dbc, $query)) {
            //Ejecutamos la consulta
            //Recuperar y mostrar cada registro
            while ($fila = mysqli_fetch_array($r)) {
                print "<p><h3>{$fila['title']}</h3> {$fila['entry']} <br/>
 <a href = \"EditarEntrada.php?id={$fila['entry_id']}\">Editar </a> &nbsp;
 <a href=\"BorrarEntrada.php?id={$fila['entry_id']}\">Borrar </a>
 </p> \n";
            }
        } else { //No se ha ejecutado la consulta
            print '<p style="color:red;">No ha sido posible recuperar la entrada porque: <br/>' .
                    mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
        }
        mysqli_close($dbc);
        ?>
    </body>
</html>