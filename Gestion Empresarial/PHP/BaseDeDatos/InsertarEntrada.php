<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Entrada</title>
    </head>
    <body>
        <?php


        /* Este script agrega una entrada a una base de datos */
        if (isset($_POST['submitted'])) {
            //Conectar y seleccionar la base de datos
            $dbc = mysqli_connect('localhost', 'root');
            mysqli_select_db($dbc, 'myblog');
            //Validamos los datos del formulario
            $problema = FALSE;
            if (!empty($_POST['title']) && !empty($_POST['entry'])) {
                $titulo = trim($_POST['title']);
                $entrada = trim($_POST['entry']);
            } else {
                print '<p style="color:red;">Por favor introduzca un título y una entrada </p>';
                $problema = TRUE;
            }if (!$problema) {
                //Definimos los datos a introducir
                $query = "INSERT INTO entries (entry_id, title, entry, date_entered) VALUES (0, '$titulo', '$entrada',
NOW())";
                //Ejecutar la consulta
                if (mysqli_query($dbc, $query)) {
                    print '<p> Entrada añadida</p>';
//                    $cont = file_get_contents("RecuperarArchivos.php");
//                    echo $cont;


                    include('RecuperarArchivos.php');
                } else {
                    print '<p style="color:red;">No ha sido posible añadir la entrada porque: <br/>' .
                            mysqli_error($dbc) . '</p><p>El query que se estaba ejecutando era' . $query . '</p>';
                }
            }//todo OK
//            mysqli_close($dbc);
        } //Fin envío formulario
        ?>
        <form action="InsertarEntrada.php" method="post">
            <p>Título de la entrada: <input type="text" name="title" size="40"/></p>
            <p>Texto: <textarea name="entry" cols="40" rows="5"></textarea></p>
            <input type="submit" name="submit" value ="Añadir Entrada"/>
            <input type="hidden" name="submitted" value="true"/>
        </form>
    </body>
</html>