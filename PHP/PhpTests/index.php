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
        
//        function piramidDraw(){
//            $base=5;
//            for($cont=0;$cont<$base;$cont++){
//                
////            for($cont2=;$cont2<$base;$cont2++){
//                
//            }    
//            }
//        }
        
        piramidDraw();
        ?>
    </body>
</html>
