<?php

class Cuatro_ruedas extends Vehiculo {

    private $numero_puertas;

    public function repintar($color) {
        
    }

    public function setPuertas($numero_puertas) {
        $this->numero_puertas = $numero_puertas;
    }

    function getNumero_puertas() {
        return $this->numero_puertas;
    }

    public function añadir_persona($peso_persona) {
        $this->peso = $this->peso + $peso_persona;
    }

    function __construct($color, $peso, $numero_puertas) {
        $this->color = $color;
        $this->peso = $peso;
        $this->numero_puertas = $numero_puertas;
    }

}

?>