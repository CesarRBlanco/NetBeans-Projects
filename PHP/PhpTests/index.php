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

        function multiply() {
            $tabla = 2;
            for ($cont = 0; $cont < 10; $cont++) {
                echo $tabla, "*", $cont, "=", $tabla * $cont, "<br/>";
            }
        }

        multiply();

        function squareDraw() {
            $side = 5;
            for ($cont = 0; $cont < $side; $cont++) {
                echo "<br/>";


                for ($cont2 = 0; $cont2 < $side; $cont2++) {
                    echo "*  ";
                }
            }
        }

        squareDraw();
        echo "<br/>";

        function piramidDraw() {
            $base = 5;

            for ($cont = 1; $cont < $base + 1; $cont++) {
                echo "<br/>";

                for ($cont3 = $base; $cont3 > $cont; $cont3--) {
                    echo "&nbsp";
                }

                for ($cont2 = 0; $cont2 < $cont; $cont2++) {
                    echo "*";
                }
            }
        }

        piramidDraw();

        function piramidHollow() {
            $base = 5;

            for ($cont = 1; $cont < $base + 1; $cont++) {

                for ($cont3 = $base; $cont3 > $cont; $cont3--) {
                    echo "&nbsp";
                }
                for ($cont2 = 0; $cont2 < $cont; $cont2++) {
                    if ($cont <= 2) {
                        echo"*";
                    }
                    if ($cont >= 3 && ($cont2 == 0 || $cont2 == $cont - 1)) {
                        echo"*";
                    } else {
                        echo"&nbsp&nbsp";
                    }
                    if ($cont == $base) {
                        for ($cont2 = 0; $cont2 < $cont-1; $cont2++) {
                            echo"*";
                        }
                    }
                }
                echo "<br/>";
            }
        }

        echo "<br/>";
        piramidHollow();
        ?>
    </body>
</html>
