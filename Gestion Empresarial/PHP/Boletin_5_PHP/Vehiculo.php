<?php

abstract class Vehiculo {

    public $color;
    public $peso;
    private $salto_de_linea = "<br/>";
    protected static $numero_cambio_color = 0;

    function getColor() {
        return $this->color;
    }

    function getPeso() {
        return $this->peso;
    }
    static function getNumero_cambio_color() {
        return self::$numero_cambio_color;
    }

    static function setNumero_cambio_color($numero_cambio_color) {
        self::$numero_cambio_color + $numero_cambio_color;
    }

        
  protected  function setColor($color) {
        $this->color = $color;
        $this->setNumero_cambio_color(1);
    }

    function setPeso($peso) {
        $this->peso = $peso;
        if($this->peso>2100){
            $this->peso=2100;
        }
    }

    public function circula() {
        print("El vehiculo circula<br/>");
    }

    public function repintar($color) {
        $this->color = $color;
    }

    abstract function añadir_persona($peso_persona);

    public function Vehiculo($color, $peso) {
        $this->color = $color;
        $this->peso = $peso;
    }

    public static function ver_atributo($objeto) {
        foreach ($objeto as $clave => $valor) {
            print ('La propiedad ' . $clave . ' tiene el valor ' . $valor . $this->salto_de_linea);
        }
    }

}

?>