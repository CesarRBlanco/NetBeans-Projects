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

    public void mostrarTitulos(Document doc) {
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }

    public String getDato(Node doc, String tag) {
        Element ee = (Element) doc;
        NodeList lista = ee.getElementsByTagName(tag);
        if (lista.getLength() > 0) {
            return lista.item(0).getFirstChild().getNodeValue();
        } else {
            return null;
        }
    }

    public void datosPelicula(Document doc, String pelicula) {
        Element padre;
        NodeList aux;
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getFirstChild().getNodeValue().equals(pelicula)) {
                padre = (Element) titulos.item(i).getParentNode();
                aux = padre.getElementsByTagName("titulo");
                if (aux.getLength() > 0) {
                    System.out.println(aux.item(0).getFirstChild().getNodeValue());
                }
                aux = padre.getElementsByTagName("nombre");
                if (aux.getLength() > 0) {
                    System.out.println(aux.item(0).getFirstChild().getNodeValue());
                }
                aux = padre.getElementsByTagName("apellido");
                if (aux.getLength() > 0) {
                    System.out.println(aux.item(0).getFirstChild().getNodeValue());
                }
                break;
            }
        }
    }

    public void datosPelicula(Document doc) {
        Element padre;
        NodeList aux;
        NodeList titulos = doc.getElementsByTagName("titulo");
        NodeList directores = doc.getElementsByTagName("nombre");
        String pelicula;
        for (int i = 0; i < titulos.getLength(); i++) {
            pelicula = titulos.item(i).getFirstChild().getNodeValue();
            System.out.println(pelicula);
            datosPelicula(doc, pelicula);

        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\Zer0\\Desktop\\peliculas.xml";
        Document doc = null;
        T2_Ejercicios gestorArbol = new T2_Ejercicios();
        doc = gestorArbol.crearArbol(ruta);
//        gestorArbol.mostrarTitulos(doc);
        gestorArbol.datosPelicula(doc);
    }

}
