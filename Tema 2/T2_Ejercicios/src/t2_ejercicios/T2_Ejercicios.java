/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejercicios;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Zer0
 */
public class T2_Ejercicios {

    public Document crearArbol(String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(true);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = (Document) builder.parse(ruta);
        } catch (Exception e) {
            System.out.println("Error al generar el arbol DOM. Error: " + e.getMessage());
        }
        return doc;
    }

    public String[] getDato(Node doc, String tag) {
        String[] datos = null;
        NodeList titulos = ((Element) doc).getElementsByTagName(tag);
        for (int i = 0; i < titulos.getLength(); i++) {
            datos[i] = titulos.item(i).getFirstChild().getNodeValue().toString();
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
        return datos;
    }

    public void datosPeliculas(Document doc) {
        String[] titulo = null;
        String[] nombre = null;
        String[] apellido = null;
        NodeList nombreDirector = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < nombreDirector.getLength(); i++) {
            for (int j4 = 0; j4 < 5; j4++) {
                titulo = getDato(nombreDirector.item(i), "titulo");
            }
            for (int j2 = 0; j2 < 5; j2++) {
                nombre = getDato(nombreDirector.item(i), "nombre");
            }

            for (int j3 = 0; j3 < 5; j3++) {
                apellido = getDato(nombreDirector.item(i), "apellido");
            }
            for (int x = 0; x < apellido.length; x++) {
                System.out.println("Titulo: " + titulo + "\nNombre: " + nombre + "\nApellido: " + apellido);
            }
            System.out.println("-------------------");
        }

//        NodeList nombreDirector = doc.getElementsByTagName("nombre");
//        int arraysize=nombreDirector.getLength();
//        String[] nombre=new String[arraysize];
//        String[] apellidos=new String[arraysize];
//        for (int j = 0; j < nombreDirector.getLength(); j++) {
//            nombre[j] = nombreDirector.item(j).getFirstChild().getNodeValue();
//        }
//        NodeList apellidosDirector = doc.getElementsByTagName("apellido");
//        for (int j2 = 0; j2 < apellidosDirector.getLength(); j2++) {
//            apellidos[j2] = apellidosDirector.item(j2).getFirstChild().getNodeValue();
//        }
//
////        mostrarTitulos(doc);
//        for (int i = 0; i < nombre.length; i++) {
//        System.out.println("nombre: " + nombre[i] + "\napellido:" + apellidos[i]);
//        System.out.println("-------------------");
//        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\Zer0\\Desktop\\peliculas.xml";
        Document doc = null;
        T2_Ejercicios gestorArbol = new T2_Ejercicios();
        doc = gestorArbol.crearArbol(ruta);
        gestorArbol.datosPeliculas(doc);
    }

}
