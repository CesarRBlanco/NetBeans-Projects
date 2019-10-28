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
            public static $referencia;

            public function __construct($autor, $titulo,$paginas) {
                $this->autor = $autor;
                $this->titulo = $titulo;
                $this->paginas=$paginas;
                $this->referencia="";
                
            }

            public function setReferencia(){
                
                $this->referencia=referencia+1;
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
            
            public function printLibro(){
               
                
                print "Titulo: ".$this->titulo."<br>Autor: ".$this->autor."<br>Páginas: ".$this->paginas;
            }

        }

        $libro1 = new Libro("UwU", "But OwO inside","420");
        $libro1->printLibro();
        
        ?>
    </body>
</html>
