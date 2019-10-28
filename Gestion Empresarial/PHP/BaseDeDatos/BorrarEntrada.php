<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar una entrada del blog</title>
    </head>
    <body>
        <?php
        //Este script elimina una entrada del blog
        //Conectar y seleccionar la base de datos
        $dbc = mysqli_connect('localhost', 'root');
        mysqli_select_db($dbc, 'myblog');
        if (isset($_GET['id']) && is_numeric($_GET['id'])) {
            //Definimos la consulta
            $query = "SELECT title, entry FROM entries WHERE entry_id={$_GET['id']}";
            if ($r = mysqli_query($dbc, $query)) { //Ejecutamos la consulta
                $fila = mysqli_fetch_array($r); //Recuperamos la informacion
                //Creamos el formulario
                print '<form action="BorrarEntrada.php" method="post">
 <p>¿Seguro que quieres borrar esta entrada?</p>
 <p><h3>' . $fila['title'] . '</h3>' . $fila['entry'] . '<br/>
 <input type = "hidden" name = "id" value = "' . $_GET['id'] . '"/>
 <input type = "submit" name = "submit" value = "Borrar entrada"/>
 </form>';
            } else { //No se ha ejecutado la consulta
                print '<p style="color:red;">No ha sido posible recuperar la entrada porque: <br/>' .
                        mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
            }
        } elseif (isset($_POST['id']) && is_numeric($_POST['id'])) {
            //Definir la consulta
            $query = "DELETE FROM entries WHERE entry_id={$_POST['id']} LIMIT 1";
            $r = mysqli_query($dbc, $query); //Ejecutamos la consulta
            //Resultado
            if (mysqli_affected_rows($dbc) == 1) {
                print '<p>La entrada del blog ha sido eliminada</p>';
            } else { //No se ha ejecutado la consulta
                print '<p style="color:red;">No ha sido posible borrar la entrada porque: <br/>' .
                        mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
            }
        } else {
            print '<p style="color:red;">Error de acceso a la página </p>';
        }
//        mysqli_close($dbc);
        ?>
    </body>
</html>