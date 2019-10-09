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
        echo "<br/>";

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
                    if ($cont > 2 && ($cont2 == 0 || $cont2 == $cont - 1)) {
                        echo"*";
                    }
                    if (($cont > 2 && ($cont2 > 0 && $cont2 < $cont - 1))) {
                        echo"&nbsp&nbsp";
                    }
                    if ($cont == $base) {
                        for ($cont2 = 0; $cont2 < $cont - 1; $cont2++) {
                            echo"*";
                        }
                    }
                }
                echo "<br/>";
            }
        }

        piramidHollow();
        echo "<br/>";

        function binaryTraductor() {
            $random = rand(0, 255);
            echo $random;
            echo " to binary is: ";
            echo decbin($random);
        }

        binaryTraductor();
        echo "<br/>";

        function primeCheck($numberP) {

            if ($numberP == 1){
                return 0;
            }
            for ($i = 2; $i <= sqrt($numberP); $i++) {
                if ($numberP % $i == 0){
                    return 0;
                }
            }
            return 1;
        }

        function checkPrime() {
            $numberP = rand(0, 100);
            $flag = primeCheck($numberP);
            echo $numberP;
            echo " is ";
            if ($flag == 1){
                
                echo "Prime";
            }
            else{
                
                echo "Not Prime";
            }
        }

        checkPrime();
        ?>
    </body>
</html>
