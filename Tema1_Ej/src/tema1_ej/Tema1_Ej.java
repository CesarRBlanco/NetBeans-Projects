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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zer0
 */
public class Tema1_Ej {

//	public void ejercicio2(File path) {
//		File[] FList = path.listFiles();
//
//		for (File f : FList) {
//			System.out.println(f.getAbsolutePath());
//			if (f.isDirectory()) {
//				File[] FList2 = f.listFiles();
//				for (File f2 : FList2) {
//					System.out.println(f2.getAbsolutePath());
//				}
//			}
//		}
//	}
//	public void ejercicio3(File fPath, char letra) throws IOException {
//		int cont = 0;
//		try (FileReader fRead = new FileReader(fPath)) {
//
//			int i;
//			while ((i = fRead.read()) != -1) {
//				System.out.print((char) i);
//				if ((char) i == letra) {
//					cont++;
//				}
//			}
//		} catch (IOException x) {
//			System.err.format("IOException: %s%n", x);
//		}
//		System.out.println();
//		System.out.println(cont);
//	}       
//	public void ejercicio4(File fPath) throws IOException {
//		ArrayList<Abecedario> abc=new ArrayList<>();
//		try (FileReader fRead = new FileReader(fPath)) {
//			int i;
//			char ch;
//			while((i=fRead.read()) != -1){
//				ch=(char)i;
//				
//				if (abc.contains(new Abecedario(ch))) {
//					abc.get(abc.indexOf(new Abecedario(ch))).suma();
//					
//				}else {
//				Abecedario caracter = new Abecedario(ch);
//				abc.add(caracter);
//				}
//			}
//		}
//			finally {
//				int max=0;
//				char maxChar = '-';
//		for(Abecedario letra:abc) {
//			if(letra.getCont()>=max) {
//				max=letra.getCont();
//				maxChar=letra.getLetra();
//			}
//		}
//		System.out.println("El caracter mas repetido es "+maxChar);
//			}
//	public class Abecedario {
//		char letra = '-';
//		int cont = 1;
//
//		public Abecedario(char letra) {
//			this.letra = letra;
//
//		}
//
//		public void suma() {
//			this.cont++;
//		}
//
//		public char getLetra() {
//			return this.letra;
//		}
//
//		public int getCont() {
//			return this.cont;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			return this.letra == ((Abecedario) obj).getLetra();
//		}
//
//	}
//	public void ejercicio5(File fPath, String fragmento) {
//		Scanner sc = null;
//		String frase;
//		int cont=0;
//		try (FileReader fRead = new FileReader(fPath)) {
//			sc = new Scanner(fPath);
//			while (sc.hasNext()) {
//			cont++;
//				frase = sc.nextLine();
//				if ((frase.toLowerCase()).contains(fragmento.toLowerCase())) {
//					System.out.println("Linea "+cont+" | "+frase);
//				}
//			}
//		} catch (IOException x) {
//			System.err.println("Error en el archivo");
//		}
    
//    public void ejercicio6(File fPath, int nDiv, boolean nOl) {
//        if (nOl == true) {
//            divCaracter(fPath, nDiv);
//        } else {
//            divLinea(fPath, nDiv);
//        }
//    }
//    public void divCaracter(File fPath, int nDiv) {
//        char[] buffer = new char[nDiv];
//        int i, cont = 1;
//        try (FileReader fin = new FileReader(fPath)) {
//            while ((i = fin.read(buffer)) != -1) {
//                try (FileWriter fout = new FileWriter(fPath.getAbsolutePath().replace(".txt", " ") + cont + ".txt")) {
//                   try{
//                    fout.write(buffer, 0, i);
//                   }catch(Exception e){
//                       fout.write("");
//                   }
//                    cont++;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            
//        }
//    }
//    public void divLinea(File fPath, int nDiv) {
//        int cont = 0;
//        try (Scanner sc = new Scanner(fPath)) {
//            while (sc.hasNext()) {
//
//                try (PrintWriter fich = new PrintWriter(fPath.getAbsolutePath().replace(".txt", " ") + cont + ".txt")) {
//                    for (int i = 0; i < nDiv; i++) {
//                 try{
//                            fich.println(sc.nextLine());
//                 }catch(Exception e){
//                     fich.println("");
//                 } 
//                    }
//                    cont++;
//                }
//
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Tema1_Ej.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    public void unirFich(String[] array) {
//        try (PrintWriter fich = new PrintWriter("C:\\Users\\Zer0\\Desktop\\fusion.txt")) {
//            for (String array1 : array) {
//                File fichi = new File(array1);
//                try (Scanner sc = new Scanner(fichi)) {
//                    while (sc.hasNext()) {
//                        fich.println(sc.nextLine());
//                    }
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Tema1_Ej.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fragmento = "Testeo";
        int nDiv = 2;
        boolean nOl = false;
        String[] arrayFich = new String[2];
        arrayFich[0] = "C:\\Users\\Zer0\\Desktop\\test_file 0.txt";
        arrayFich[1] = "C:\\Users\\Zer0\\Desktop\\test_file 1.txt";
        File fPath = new File("C:\\Users\\Zer0\\Desktop\\test_file.txt");

//        File f = new File("C:\\Users\\Zer0\\Desktop");
//        Ejercicios ej2 = new Ejercicios();
//        ej2.ejercicio2(f);
//        Ejercicios ej3 = new Ejercicios();
//        char letra = 'a';
//        ej3.ejercicio3(fPath, letra);
//        Ejercicios ej4 = new Ejercicios();
//        ej4.ejercicio4(fPath);
//        Ejercicios ej5 = new Ejercicios();
//        ej5.ejercicio5(fPath, fragmento);
//        Tema1_Ej ej6 = new Tema1_Ej();
//        ej6.ejercicio6(fPath, nDiv, nOl);
//        ej6.unirFich(arrayFich);

    }
}
