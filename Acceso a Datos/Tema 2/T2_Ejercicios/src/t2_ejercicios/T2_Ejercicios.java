/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejercicios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Zer0
 */
public class T2_Ejercicios {

//Creacion del arbol, no tocar.
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

//[Revisar]   
//Metodo para acceder a los datos del XML
    public void getDato(Node doc, String tag) {
        //Conseguir los nodos que tengan el mismo tag que el que se pasa como parametro
        NodeList titulos = ((Element) doc).getElementsByTagName(tag);
        Element padre;
        NamedNodeMap atrib;
        Node atribu;
        int cont = 0;

        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getParentNode().getNodeName().equals("pelicula")) {
                padre = (Element) titulos.item(i).getParentNode();
                padre.getElementsByTagName(tag);
                atrib = padre.getAttributes();
                atribu = atrib.item(1);
                System.out.println(atribu.getNodeValue());
            }
            if (tag.equals("nombre")) {
                cont++;
                System.out.println(cont);
            }
        }
    }

//Llamada al metodo superior para conseguir los datos deseados
    public void datosPeliculas(Document doc) {
        NodeList nombreDirector = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < nombreDirector.getLength(); i++) {

            getDato(nombreDirector.item(i), "titulo");
            getDato(nombreDirector.item(i), "genero");
            getDato(nombreDirector.item(i), "nombre");
            getDato(nombreDirector.item(i), "apellido");
            System.out.println("-------------------");
        }
    }

//[Buena suerte entendiendo esto otra vez, campeon]
    public void masDirectores(Document doc, int n) {
        NodeList nombreDirector = doc.getElementsByTagName("pelicula");
        boolean key;
        for (int i = 0; i < nombreDirector.getLength(); i++) {

            key = getDatoDirec(nombreDirector.item(i), "nombre", n);
            if (key == true) {
                getDatoDirec(nombreDirector.item(i), "titulo", n);
            }
        }
    }

    public boolean getDatoDirec(Node doc, String tag, int n) {
        //Conseguir los nodos que tengan el mismo tag que el que se pasa como parametro
        NodeList titulos = ((Element) doc).getElementsByTagName(tag);
        int cont = 0;
        boolean key = false;
        for (int i = 0; i < titulos.getLength(); i++) {
            if (tag.equals("nombre")) {
                cont++;
                if (cont == n) {
                    key = true;
                }
            } else {
                System.out.println(titulos.item(i).getFirstChild().getNodeValue());
            }
        }
        return key;
    }

    //Llamada al metodo superior para conseguir los datos deseados
    public void getGeneros(Document doc) {
        NodeList nombreDirector = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < nombreDirector.getLength(); i++) {
            generos(nombreDirector.item(i), "titulo");
        }
        System.out.printf("Hay %s generos y son:\n", generos.size());
        for (int i = 0; i < generos.size(); i++) {
            System.out.println("- " + generos.get(i));
        }
    }
    List<String> generos = new ArrayList<>();
    int cont = 0;

    //Conseguir cuantos generos hay y sus nombres
    public void generos(Node doc, String tag) {
        //Conseguir los nodos que tengan el mismo tag que el que se pasa como parametro
        NodeList titulos = ((Element) doc).getElementsByTagName(tag);
        Element padre;
        NamedNodeMap atrib;
        Node atribu;

        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getParentNode().getNodeName().equals("pelicula")) {
                padre = (Element) titulos.item(i).getParentNode();
                padre.getElementsByTagName(tag);
                atrib = padre.getAttributes();
                atribu = atrib.item(1);
                generos.add(atribu.getNodeValue());
                for (int j = 0; j < generos.size() - 1; j++) {
                    if ((generos.get(j).equals(generos.get(cont)) && (generos.size() > 2))) {
                        generos.remove(cont);
                        cont--;
                    }
                }
                cont++;
            }
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\Zer0\\Desktop\\peliculas.xml";
        Document doc = null;
        T2_Ejercicios gestorArbol = new T2_Ejercicios();
        doc = gestorArbol.crearArbol(ruta);
//        gestorArbol.datosPeliculas(doc);
//        gestorArbol.masDirectores(doc, 2);
//        gestorArbol.getGeneros(doc);

    }
}
