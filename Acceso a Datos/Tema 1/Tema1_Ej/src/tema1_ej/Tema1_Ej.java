/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1_ej;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.EOFException;
import javax.activation.FileDataSource;

/**
 *
 * @author Zer0
 */
public class Tema1_Ej {

    Scanner sc = new Scanner(System.in);

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
                aux = new Abecedario((char) i);
                if (abc.contains(aux)) {
                    abc.get(abc.indexOf(aux)).suma();
                } else {
                    abc.add(aux);
                }
            }
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
        }
    }
//------------------------------------------------------------------------------

    public void ejercicio7(File fPath, char opcion) {
        switch (opcion) {
            case 'n':
                opcionN(fPath);
                break;
            case 'A':
                opcionAM(fPath);
                break;
            case 'D':
                opcionDM(fPath);
                break;
            case 'a':
                opcionA(fPath);
                break;
            case 'd':
                opcionD(fPath);
                break;
        }
    }

    public void opcionN(File fPath) {
        int cont = 0, cont2 = 0;
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                cont2++;
            }
        } catch (FileNotFoundException ex) {
        }
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNext()) {
                sc.next();
                cont++;
            }
            sc.close();

            System.out.printf("Hay %s palabras y %s lineas", cont, cont2);
        } catch (FileNotFoundException ex) {
        }

    }

    public void opcionAM(File fPath) {
        ArrayList<String> al = new ArrayList<>();
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNextLine()) {
                al.add(sc.nextLine());
            }
            Collections.sort(al);
            System.out.println(al);
        } catch (FileNotFoundException ex) {
        }
    }

    public void opcionDM(File fPath) {
        ArrayList<String> al = new ArrayList<>();
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNextLine()) {
                al.add(sc.nextLine());
            }
            Collections.sort(al, Collections.reverseOrder());
            System.out.println(al);
        } catch (FileNotFoundException ex) {
        }
    }

    public void opcionA(File fPath) {
        ArrayList<String> al = new ArrayList<>();
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNextLine()) {
                al.add(sc.nextLine());
            }
            Collections.sort(al, String.CASE_INSENSITIVE_ORDER);
            System.out.println(al);
        } catch (FileNotFoundException ex) {
        }

    }

    public void opcionD(File fPath) {
        ArrayList<String> al = new ArrayList<>();
        try (Scanner sc = new Scanner(fPath)) {
            while (sc.hasNextLine()) {
                al.add(sc.nextLine());
            }
            Collections.sort(al, String.CASE_INSENSITIVE_ORDER);
            Collections.reverse(al);
            System.out.println(al);
        } catch (FileNotFoundException ex) {
        }
    }
//------------------------------------------------------------------------------

    public void ejercicio8(File fIn, File fOut, boolean wayKey) throws IOException {

        if (wayKey) {
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new FileInputStream(fIn);
                out = new FileOutputStream(fOut, true);
                int i;
                while ((i = in.read()) != -1) {
                    out.write(i);
                }
            } catch (IOException e) {

            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        } else {
            FileInputStream in = null;
            FileOutputStream out = null;
            int i;
            byte[] buffer = new byte[1000];
            while ((i = in.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            out.close();
            in.close();
        }
    }
//------------------------------------------------------------------------------

    public void ejercicio9(File fOut) throws IOException {
        menuEj9(fOut);
    }

    public void menuEj9(File fOut) throws IOException {
        int opcion;
        do {
            System.out.println("Seleciona una opción");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    altaAlumnos(fOut);
                    break;
                case 2:
                    consultaAlumnos(fOut);
                    break;
                case 3:
                    modificarAlumno(fOut);
                    break;
                case 4:
                    break;
            }
        } while (opcion != 5);
    }

    public void altaAlumnos(File fOut) throws IOException {

        String nombre;
        int fecha, codigo;
        FileOutputStream dataOut = null;
        DataOutputStream out = null;

        System.out.println("Nombre del alumno:");
        sc.nextLine();
        nombre = sc.nextLine();
        System.out.println("Fecha de nacimiento:");
        fecha = sc.nextInt();
        System.out.println("Codigo de alumno:");
        codigo = sc.nextInt();
        try {
            dataOut = new FileOutputStream(fOut, true);
            out = new DataOutputStream(dataOut);
            out.writeUTF(nombre);
            out.writeInt(fecha);
            out.writeInt(codigo);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            out.close();
        }
    }

    public void consultaAlumnos(File fOut) throws FileNotFoundException, IOException {
        FileInputStream fin = null;
        DataInputStream in = null;

        try {
            fin = new FileInputStream(fOut);
            in = new DataInputStream(fin);
            try {
                while (true) {
                    System.out.printf("Nombre:%s, Fecha de nacimiento:%d, Codigo:%03d. \n",
                            in.readUTF(), in.readInt(), in.readInt());
                }
            } catch (EOFException e) {
                System.out.println("Fin de fichero");
            }
        } finally {
            in.close();
            fin.close();
        }
    }

    public void modificarAlumno(File fOut) throws FileNotFoundException, IOException {
        String nombreReserv="";
        int fechaReserv=0, codigoReserv=0, codigoBusca;
        FileInputStream fin = null;
        DataInputStream in = null;
        FileOutputStream dataOut = null;
        DataOutputStream out = null;

        codigoBusca = sc.nextInt();
        try {
            fin = new FileInputStream(fOut);
            in = new DataInputStream(fin);
            dataOut = new FileOutputStream(fOut,true);
            out = new DataOutputStream(dataOut);
            try {
                while (true) {
                    nombreReserv = in.readUTF();
                    fechaReserv = in.readInt();
                    codigoReserv = in.readInt();
                    if (codigoReserv == codigoBusca) {
                        System.out.printf("Nombre:%s, Fecha de nacimiento:%d, Codigo:%03d. \n",
                                nombreReserv, fechaReserv, codigoReserv);
                        System.out.println("Introduce los nuevos datos.");
                        System.out.println("Nombre del alumno:");
                        sc.nextLine();
                        nombreReserv = sc.nextLine();
                        System.out.println("Fecha de nacimiento:");
                        fechaReserv = sc.nextInt();
                        System.out.println("Codigo de alumno:");
                        codigoReserv = sc.nextInt();
                    }
                }

            } catch (EOFException e) {
                System.out.println("Fin de fichero");
            }
            out.writeUTF(nombreReserv);
            out.writeInt(fechaReserv);
            out.writeInt(codigoReserv);

        } finally {
            if (in != null) {
                in.close();
            }
            if (fin != null) {
                fin.close();
            }

            if (out != null) {
                out.close();
            }
            if (dataOut != null) {
                dataOut.close();
            }

        }
    }
    //------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // ---
        String fragmento = "Testeo";
        int nDiv = 1;
        boolean nOl = false;
        char opcion = 'd';
        boolean wayKey = true;
        int codeSearch = 0001;

        // ---
        String[] arrayFich = new String[2];
        arrayFich[0] = "C:\\Users\\Zer0\\Desktop\\0_test_file.txt";
        arrayFich[1] = "C:\\Users\\Zer0\\Desktop\\1_test_file.txt";
        File fPath = new File("C:\\Users\\Zer0\\Desktop\\test_file.txt");
        File f = new File("C:\\Users\\Zer0\\Desktop");
        File fOut = new File("C:\\Users\\Zer0\\Desktop\\alumnos.dat");
        File fIn = new File("C:\\Users\\Zer0\\Desktop");

        // --- 
//        Tema1_Ej ej2 = new Tema1_Ej();
//        ej2.ejercicio2(f, "");
//        
//        Tema1_Ej ej3 = new Tema1_Ej();
//        char letra = 'a';
//        ej3.ejercicio3(fPath, letra);
//        
//        Tema1_Ej ej4 = new Tema1_Ej();
//        ej4.ejercicio4(fPath);
//        
//        Tema1_Ej ej5 = new Tema1_Ej();
//        ej5.ejercicio5(fPath, fragmento);
//        
//        Tema1_Ej ej6 = new Tema1_Ej();
//        ej6.ejercicio6(fPath, nDiv, nOl);
//        ej6.unirFich(arrayFich);
//        
//        Tema1_Ej ej7 = new Tema1_Ej();
//        ej7.ejercicio7(fPath, opcion);
//        
//        Tema1_Ej ej8 = new Tema1_Ej();
//        ej8.ejercicio8(fIn, fOut, wayKey);
//        
        Tema1_Ej ej9 = new Tema1_Ej();
        ej9.ejercicio9(fOut);
    }
}
