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

        class Vehiculo {

            private $color;
            private $peso;

            function getColor() {
                return $this->color;
            }

            function getPeso() {
                return $this->peso;
            }

            function setColor($color) {
                $this->color = $color;
            }

            function setPeso($peso) {
                $this->peso = $peso;
            }

            public function circula() {
                
            }

            public function añadir_persona($peso_persona) {
                
            }
            
            public function Vehiculo(){
                
            }

        }
        
//------------------------------------------------------------------------------        
        class Cuatro_ruedas extends Vehiculo {

            private $numero_puertas;

            public function repintar($color) {
                
            }

        }

//------------------------------------------------------------------------------
        class Dos_ruedas extends Vehiculo {

            private $cilindrada;

            public function poner_gasolina($litros) {
                
            }

        }

//------------------------------------------------------------------------------
        class Coche extends Cuatro_ruedas {

            private $numero_cadenas_nieve;

            public function añadir_cadenas_nieve($num) {
                
            }

            public function quitar_cadenas_nieve($num) {
                
            }

        }

//------------------------------------------------------------------------------        
        class Camion extends Cuatro_ruedas {

            private $longitud;

            public function añadir_remolque($longiutd_remolque) {
                
            }

        }
        ?>
    </body>
</html>
