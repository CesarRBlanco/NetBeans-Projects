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
        <form action="Forms_Ejs.php" method="post">
            <p>
                Número de unidades
                <input type="text" name="numberUnits"/>
                <br>
                Précio unidad  
                <input type="text" name="priceUnits"/>
                <br>
                Tipo de IVA aplicable:
                <input type="radio" name="IVA" value="10"/>10%
                <input type="radio" name="IVA" value="15"/>15%
                <input type="radio" name="IVA" value="20"/>20%
                <br>
                <input type="submit" name="send"/>
            <p/>
        </form>  
        <?php
        $flag = FALSE;
        if (isset($_POST['numberUnits'])) {
            $cantidad = $_POST['numberUnits'];
        } else {
            $cantidad = '';
            $flag = TRUE;
        }
        if (isset($_POST['priceUnits'])) {
            $precio = $_POST['priceUnits'];
        } else {
            $precio = '';
            $flag = TRUE;
        }
        if (isset($_POST['IVA'])) {
            $iva = $_POST['IVA'];
        } else {
            $iva = '';
            $flag = TRUE;
        }
        if ($flag == true) {
            echo "Todos los campos deben ser rellenados";
        } else {
            $precioTotal = (($precio * $cantidad) * $iva) / 100;
            echo "Es coste total es:  $precioTotal";
        }
        ?>
    </body>
</html>
