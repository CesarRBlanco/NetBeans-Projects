<?php

require 'Vehiculo.php';
require 'Coche.php';
require 'Dos_ruedas.php';
require 'Camion.php';
$coche = new Coche("negro", 1500);
$coche->circula();
$coche->añadir_persona(70);

print $coche->getColor();
print "<br/>";
print $coche->getPeso();

print "<br/>";
print "<br/>";

$coche2 = new Coche("verde", 1500);
$coche2->añadir_persona(65);
$coche2->añadir_persona(65);
print $coche2->getColor();
print "<br/>";
print $coche2->getPeso();
print "<br/>";
$coche2->repintar("rojo");
$coche2->añadir_cadenas_nieve(2);
print $coche2->getColor();
print "<br/>";
print $coche2->numero_cadenas_nieve;

print "<br/>";
print "<br/>";

$moto = new Dos_ruedas("negro", 120);
$moto->añadir_persona(80);
$moto->poner_gasolina(20);
print $moto->getColor();
print "<br/>";
print $moto->getPeso();

print "<br/>";
print "<br/>";

$camion = new Camion("azul", 10000);
$camion->setPuertas(2);
$camion->setLongitud(10);
$camion->añadir_remolque(5);
$camion->añadir_persona(80);
print $camion->getColor();
print "<br/>";
print $camion->getPeso();
print "<br/>";
print $camion->getLongitud();
print "<br/>";
print $camion->getNumero_puertas();

print "<br/>";
print "<br/>";

$moto2=new Dos_ruedas("rojo",150);
$moto2->añadir_persona(70);
$moto2->repintar("verde");
$moto2->setCilindrada(1000);
Vehiculo::ver_atributo($moto2);

print "<br/>";
print "<br/>";

$camion2=new Camion("blanco",6000);
$camion2->añadir_persona(84);
$camion2->repintar("azul");
$camion2->setPuertas(2);
Vehiculo::ver_atributo($camion2);

print "<br/>";
print "<br/>";

$coche3=new Coche("verde", 2100, 4);
$coche3->añadir_cadenas_nieve(2);
$coche3->añadir_persona(80);
$coche3->repintar("azul");

?>
 