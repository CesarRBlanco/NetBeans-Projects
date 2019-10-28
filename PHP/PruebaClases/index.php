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

        class Dado {

            public $puntos;

            function __construct() {
                ;
            }

            private function tirada() {
                $this->puntos = rand(1, 6);
            }

            public function tirar2() {
                $this->tirada();
                return $this->puntos;
            }

        }

        $dado1 = new Dado();
        for ($index = 0; $index < 10; $index++) {
            echo "<br> Ha salido un " . $dado1->tirar2();
        }
        ?>
    </body>
</html>
