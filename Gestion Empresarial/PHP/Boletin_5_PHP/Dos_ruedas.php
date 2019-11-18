<?php



class Dos_ruedas extends Vehiculo {

    private $cilindrada;

    public function poner_gasolina($litros) {
        $this->añadir_persona($litros);
    }

    public function añadir_persona($peso_persona) {
        $this->peso= $this->peso+$peso_persona+2;
    }
    function setCilindrada($cilindrada) {
        $this->cilindrada = $cilindrada;
    }


}

?>