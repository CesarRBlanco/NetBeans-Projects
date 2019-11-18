<?php

require 'Cuatro_ruedas.php';

class Coche extends Cuatro_ruedas {

    public $numero_cadenas_nieve;

    public function añadir_persona($peso_persona) {
        parent::añadir_persona($peso_persona);
        if ($this->peso >= 1500 && $this->numero_cadenas_nieve <= 2) {
            print "Atención, ponga 4 cadenas para la nieve.";
        }
    }

    public function añadir_cadenas_nieve($num) {
        if ($this->numero_cadenas_nieve >= 4 || $num > 4) {
            $this->numero_cadenas_nieve = 4;
        } else {
            $this->numero_cadenas_nieve = $this->numero_cadenas_nieve + $num;
        }
    }

    public function quitar_cadenas_nieve($num) {
        if ($this->numero_cadenas_nieve <= 0 || $num < 0) {
            $this->numero_cadenas_nieve = 0;
        } else {
            $this->numero_cadenas_nieve = $this->numero_cadenas_nieve - $num;
        }
    }

}

?>