<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar entrada</title>
    </head>
    <body>
        <?php
        //Este script permite modificar la entrada del blog
        //Conectar y seleccionar la base de datos
        $dbc = mysqli_connect('localhost', 'root');
        mysqli_select_db($dbc, 'myblog');
        if (isset($_GET['id']) && is_numeric($_GET['id'])) {
            //Definimos la consulta
            $query = "SELECT title, entry FROM entries WHERE entry_id={$_GET['id']}";
            if ($r = mysqli_query($dbc, $query)) { //Ejecutamos la consulta
                $fila = mysqli_fetch_array($r); //Recuperamos la información
                //Creamos el formulario
                print'<form action="EditarEntrada.php" method="post">
 <p>Título de la entrada: <input type="text" name="title" size="40" value="' . 
                        htmlentities($fila['title']) . '"/></p>
 <p>Texto: <textarea name="entry" cols="40" rows="5">' . htmlentities($fila['entry']) .
                        '</textarea></p>
 <input type="hidden" name="id" value="' . $_GET['id'] . '"/>
 <input type="submit" name="submit" value ="Actualizar Entrada"/>
 </form>';
            } else { //No se puede recuperar la informacion
                print '<p style="color:red;">No ha sido posible recuperar la entrada porque: <br/>' .
                        mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
            }
        } elseif (isset($_POST['id']) && is_numeric($_POST['id'])) {
            $problema = FALSE;
            if (!empty($_POST['title']) && !empty($_POST['entry'])) {
                $titulo = mysqli_real_escape_string($dbc, trim($_POST['title']));
                $entrada = mysqli_real_escape_string($dbc, trim($_POST['entry']));
            } else {
                print '<p style="color:red;">Por favor introduzca un título y una entrada <br/>';
                $problema = TRUE;
            }
            if (!$problema) {
                //Definimos y ejecutamos la consulta
                $query = "UPDATE entries SET title='$titulo', entry='$entrada' WHERE entry_id={$_POST['id']}";
                $r = mysqli_query($dbc, $query);
                //Mostramos el resultado
                if (mysqli_affected_rows($dbc) == 1) {
                    print '<p>La entrada del blog ha sido actualizada</p>';
                } else {
                    '<p style="color:red;">No ha sido posible actualizar la entrada porque: <br/>' .
                            mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
                }
            } else { //no se establece el ID
                print '<p style="color:red;">Error de acceso a la página </p>';
            }
        }
//        mysqli_close($dbc);
        
        ?>
    </body>
</html>