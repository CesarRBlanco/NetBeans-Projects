<?php

class Camion extends Cuatro_ruedas {

    private $longitud;

    public function añadir_remolque($longiutd_remolque) {
        $this->longitud = $this->longitud + $longiutd_remolque;
    }

    function setLongitud($longitud) {
        $this->longitud = $longitud;
    }

    function getLongitud() {
        return $this->longitud;
    }


}

?>