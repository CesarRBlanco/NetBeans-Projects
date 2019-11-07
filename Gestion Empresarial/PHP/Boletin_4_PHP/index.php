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

        class Libro {

            private $autor;
            private $titulo;
            private $paginas;
            private $referencia2;
            public static $prestado=0;
            public static $referencia = 0;
            private $contieneCD;

//Metodo selector SI/NO para el boolean            
            
            public function __construct($autor, $titulo, $paginas, $referencia2,$i) {
                $this->autor = $autor;
                $this->titulo = $titulo;
                $this->paginas = $paginas;
                $this->setReferencia();
                $this->setReferencia2($referencia2);
                $this->setPrestado($i);
            }

            public function setReferencia() {

                Libro::$referencia++;
            }

            function setReferencia2($referencia2) {
                if (strlen($referencia2) >= 3) {
                    $this->referencia2 = $referencia2;
                } else {
                    $this->referencia2 = "Error: Referencia demasiado corta.";
                }
            }

            function getPrestado() {
                return Libro::$prestado;
            }

            function setPrestado($i) {
                Libro::$prestado+$i;
            }

            public function getAutor() {
                return $this->autor;
            }

            public function getTitulo() {
                return $this->titulo;
            }

            public function getPaginas() {
                return $this->paginas;
            }

            public function printAutor() {
                print $this->autor;
            }

            public function printTitulo() {
                print $this->titulo;
            }

            public function printLibro() {
                if ($this->referencia2 != "") {
                    print "Titulo: " . $this->titulo . "<br>Autor: " .
                            $this->autor . "<br>Páginas: " . $this->paginas .
                            "<br>" . $this->referencia2 . "<br>Prestado: ". Libro::$prestado. "<br><br>";
                    
                } else {
                    print "Titulo: " . $this->titulo . "<br>Autor: " .
                            $this->autor . "<br>Páginas: " . $this->paginas .
                            "<br>Referencia: " . Libro::$referencia . "<br>Prestado: ".Libro::$prestado."<br><br>";
                }
            }
        }

        $libro1 = new Libro("Libro Numero 1", "Autor Numero 1", "132", "AA",1);
        $libro1->printLibro();
        $libro1->printLibro();
        $libro1->printLibro();
        $libro1->printLibro();
        $libro1->printLibro();

        $libro2 = new Libro("Libro2", "Autor2", "231", "AJ43",1);
        $libro2->printLibro();
        ?>
    </body>
</html>
