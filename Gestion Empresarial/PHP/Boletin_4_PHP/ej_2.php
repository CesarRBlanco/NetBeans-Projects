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

        class Calentador {

            private $temperatura;
            private $min;
            private $max;
            private $incremento;

            public function Calentador($min, $max) {
                $this->temperatura = 15.0;
                $this->min = $min;
                $this->max = $max;
                $this->incremento = 0.5;
            }

            public function calentar() {
                if ($this->temperatura >= $this->max) {
                    return;
                } else {
                    $this->setTemperatura($this->temperatura + $this->incremento);
                }
            }

            public function enfriar() {
                if ($this->temperatura <= $this->min) {
                    return;
                } else {
                    $this->setTemperatura($this->temperatura - $this->incremento);
                }
            }

            public function setTemperatura($temperatura) {
                $this->temperatura = $temperatura;
            }

            public function setIncremento($incremento) {
                if ($incremento < 0) {
                    $incremento = 0;
                } else {
                    $this->incremento = $incremento;
                }
            }

            public function verTemperatura() {
                print "Temperatura: " . $this->temperatura;
            }
        }
        
        
        
        ?>



    </body>
</html>
