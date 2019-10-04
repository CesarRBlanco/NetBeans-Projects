/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1_ej;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zer0
 */
public class Tema1_Ej {

    public void ejercicio2(File f, String separador) {
        File[] ficheros = f.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            System.out.println(ficheros[x].getAbsolutePath());
            if (ficheros[x].isDirectory()) {
                String nuevo_separador;
                nuevo_separador = separador + " ";
                ejercicio2(ficheros[x], nuevo_separador);
            }
        }
    }

//------------------------------------------------------------------------------
    public int ejercicio3(File fPath, char letra) {
        int cont = 0;
        try (FileReader fRead = new FileReader(fPath)) {

            int i;
            while ((i = fRead.read()) != -1) {
                System.out.print((char) i);
                if ((char) i == letra) {
                    cont++;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
            cont = -1;
        }
        System.out.println();
        System.out.println(cont);
        return cont;
    }
//------------------------------------------------------------------------------

    public void ejercicio4(File fPath) throws IOException {
        ArrayList<Abecedario> abc = new ArrayList<>();
        try (FileReader fRead = new FileReader(fPath)) {
            int i;
            char ch;
            Abecedario aux;
            while ((i = fRead.read()) != -1) {
                ch = (char) i;
                if (abc.contains(new Abecedario(ch))) {
                    abc.get(abc.indexOf(new Abecedario(ch))).suma();

                } else {
                    Abecedario caracter = new Abecedario(ch);
                    abc.add(caracter);
                }
            }

//            while ((i = fRead.read()) != -1) {
//                aux=new Abecedario((char)i);
//                if (abc.contains(aux)) {
//                    abc.get(abc.indexOf(aux)).suma();
//                } else {
//                    abc.add(aux);
//                }
//            }
        } finally {
            int max = 0;
            char maxChar = '-';
            for (Abecedario letra : abc) {
                if (letra.getCont() >= max) {
                    max = letra.getCont();
                    maxChar = letra.getLetra();
                }
            }
            System.out.println("El caracter mas repetido es " + maxChar);

        }
    }

    class Abecedario {

        char letra = '-';
        int cont = 1;

        public Abecedario(char letra) {
            this.letra = letra;

        }

        public void suma() {
            this.cont++;
        }

        public char getLetra() {
            return this.letra;
        }

        public int getCont() {
            return this.cont;
        }

        @Override
        public boolean equals(Object obj) {
            return this.letra == ((Abecedario) obj).getLetra();
        }

    }
//------------------------------------------------------------------------------

    public void ejercicio5(File fPath, String fragmento) {

        String frase;
        int cont = 0;
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNext()) {
                cont++;
                frase = sc.nextLine();
                if ((frase.toLowerCase()).contains(fragmento.toLowerCase())) {
                    System.out.println("Linea " + cont + " | " + frase);
                }
            }
        } catch (IOException x) {
            System.err.println("Error en el archivo");
        }
    }
//------------------------------------------------------------------------------

    public void ejercicio6(File fPath, int nDiv, boolean nOl) {
        if (nOl == true) {
            divCaracter(fPath, nDiv);
        } else {
            divLinea(fPath, nDiv);
        }
    }

    public void divCaracter(File fPath, int nDiv) {
        char[] buffer = new char[nDiv];
        int i, cont = 1;
        try (FileReader fin = new FileReader(fPath)) {
            while ((i = fin.read(buffer)) != -1) {
                try (FileWriter fout = new FileWriter(fPath.getAbsolutePath().replace(fPath.getName(), cont + "_" + fPath.getName()))) {
                    fout.write(buffer, 0, i);
                    cont++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void divLinea(File fPath, int nDiv) {
        int cont = 0;
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNext()) {
                try (PrintWriter fich = new PrintWriter(fPath.getAbsolutePath().replace(fPath.getName(), cont + "_" + fPath.getName()))) {
                    for (int i = 0; i < nDiv && sc.hasNext(); i++) {
                        try {
                            fich.println(sc.nextLine());
                        } catch (Exception e) {
                        }
                    }
                    cont++;

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tema1_Ej.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unirFich(String[] array) {
        try (PrintWriter fich = new PrintWriter("C:\\Users\\Zer0\\Desktop\\fusion.txt")) {
            for (String array1 : array) {
                //File fichi = new File(array1);
                try (Scanner sc = new Scanner(new File(array1))) {
                    while (sc.hasNext()) {
                        fich.println(sc.nextLine());

                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tema1_Ej.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
//------------------------------------------------------------------------------

    public void ejercicio7(File fPath, char opcion) {
        switch (opcion) {
            case 'n':
                opcionN(fPath);
                break;
            case 'A':
                opcionA();
                break;
            case 'D':
                opcionD();
                break;
            case 'a':
                opcionAM();
                break;
            case 'd':
                opcionDM();
                break;
        }
    }

    public void opcionN(File fPath) {
        int cont = 0;
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNext()) {
                System.out.println(cont);
                cont++;
            }
            sc.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tema1_Ej.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void opcionA() {

    }

    public void opcionD() {

    }

    public void opcionAM() {

    }

    public void opcionDM() {

    }
//------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fragmento = "Testeo";
        int nDiv = 1;
        boolean nOl = false;
        String[] arrayFich = new String[2];
        arrayFich[0] = "C:\\Users\\Zer0\\Desktop\\0_test_file.txt";
        arrayFich[1] = "C:\\Users\\Zer0\\Desktop\\1_test_file.txt";
        File fPath = new File("C:\\Users\\Zer0\\Desktop\\test_file.txt");
        File f = new File("C:\\Users\\Zer0\\Desktop");
        char opcion = 'n';
        

//        Tema1_Ej ej2 = new Tema1_Ej();
//        ej2.ejercicio2(f,"");
//        Tema1_Ej ej3 = new Tema1_Ej();
//        char letra = 'a';
//        ej3.ejercicio3(fPath, letra);
//        Tema1_Ej ej4 = new Tema1_Ej();
//        ej4.ejercicio4(fPath);
//        Tema1_Ej ej5 = new Tema1_Ej();
//        ej5.ejercicio5(fPath, fragmento);
        Tema1_Ej ej6 = new Tema1_Ej();
        ej6.ejercicio6(fPath, nDiv, nOl);
        ej6.unirFich(arrayFich);
//        Tema1_Ej ej7 = new Tema1_Ej();
//        ej7.ejercicio7(fPath, opcion);
    }
}
