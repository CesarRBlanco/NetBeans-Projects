/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

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

    public void añadirAtributo(Document doc, String atributoNodo, String atributoValor, String titulo) {
        NodeList peliculas = doc.getElementsByTagName("titulo");
        Element padre;
        NamedNodeMap atrib;
        Node atribu;
        int cont = 0;
        for (int j = 0; j < peliculas.getLength(); j++) {
            if (peliculas.item(j).getFirstChild().getNodeValue().equals(titulo)) {
                if (peliculas.item(j).getParentNode().getNodeName().equals("pelicula")) {
                    padre = (Element) peliculas.item(j).getParentNode();
                    padre.getElementsByTagName("titulo");
                    atrib = padre.getAttributes();
                    for (int i = 0; i < atrib.getLength(); i++) {
                        atribu = atrib.item(i);
                        if (atribu.getNodeName().equals(atributoNodo)) {
                            cont--;
                        } else {
//                            System.out.println(atribu.getNodeValue());
                            cont++;
                        }
                    }

                    if (cont == atrib.getLength()) {
                        System.out.printf("Voy a agregar %s: %s", atributoNodo, atributoValor);
                        padre.setAttribute(atributoNodo, atributoValor);
                    }
                }
            }
        }
    }

    public void borrarAtributo(Document doc, String atributoNodo, String titulo) {
        NodeList peliculas = doc.getElementsByTagName("titulo");
        Element padre;
        NamedNodeMap atrib;
        Node atribu;
        int cont = 0;
        for (int j = 0; j < peliculas.getLength(); j++) {
            if (peliculas.item(j).getFirstChild().getNodeValue().equals(titulo)) {
                if (peliculas.item(j).getParentNode().getNodeName().equals("pelicula")) {
                    padre = (Element) peliculas.item(j).getParentNode();
                    padre.getElementsByTagName("titulo");
                    atrib = padre.getAttributes();
                    for (int i = 0; i < atrib.getLength(); i++) {
                        atribu = atrib.item(i);
                        if (atribu.getNodeName().equals(atributoNodo)) {
                            padre.removeAttribute(atributoNodo);
                            System.out.println("Borrado con exito");
                        }
                    }
                }
            }
        }
    }

    public void añadirPelicula(Document doc, String rutaSalida, String titul, String direc,String apell, String estre, String gener,String idiom) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {

        try {
// A partir del documento doc se crea un nodo película que contendrá los demás
// elementos: titulo, director y estreno
            Element nodoPelicula = doc.createElement("pelicula");
// Se añade el atributo genero al elemento creado
            nodoPelicula.setAttribute("año", estre);
            nodoPelicula.setAttribute("genero", gener);
            nodoPelicula.setAttribute("idioma", idiom);
// Se añade a película un nodo tipo texto con un salto de línea (\n) para que
// al abrirlo con un editor de texto cada nodo salga en un línea diferente.
            nodoPelicula.appendChild(doc.createTextNode("\n"));
// Se crean los nodos hijos de película añadiéndolo un nodo texto que contendrá el
// valor del elemento y se le añaden a la película
// Para titulo
            Element nodoTitulo = doc.createElement("titulo");
            Text textNodoTitulo = doc.createTextNode(titul);
            nodoTitulo.appendChild(textNodoTitulo);
            nodoPelicula.appendChild(nodoTitulo);
// Se añade también un nodo text con un saldo de línea \n
            nodoPelicula.appendChild(doc.createTextNode("\n"));// Para director
            Element nodoDirector = doc.createElement("director");
            nodoDirector.appendChild(doc.createTextNode("\n"));
            Element nodoDirectorNombre = doc.createElement("nombre");
            Text textNodoDirectorNombre = doc.createTextNode(direc);
            nodoDirector.appendChild(doc.createTextNode("\n"));
            Element nodoDirectorApellido = doc.createElement("apellido");
            Text textNodoDirectorApellido = doc.createTextNode(apell);
            nodoDirector.appendChild(textNodoDirectorNombre);
            nodoDirector.appendChild(textNodoDirectorApellido);
            nodoDirector.appendChild(nodoDirectorNombre);
            nodoDirector.appendChild(nodoDirectorApellido);
            nodoPelicula.appendChild(nodoDirector);

// Se añade la película a películas, que es el primer nodo del documento
            Node raiz = doc.getFirstChild();
            raiz.appendChild(nodoPelicula);

// Añadir al fichero DOM Nuevo
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS ls = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
// Se crea un destino vacio
            LSOutput output = ls.createLSOutput();

            output.setEncoding(
                    "UTF-8");
// Se establece el flujo de salida
            output.setByteStream(
                    new FileOutputStream(rutaSalida));
//output.setByteStream(System.out);
// Permite escribir un documento DOM en XML
            LSSerializer serializer = ls.createLSSerializer();
// Se establecen las propiedades del serializador

            serializer.setNewLine(
                    "\r\n");;
            serializer.getDomConfig()
                    .setParameter("format-pretty-print", true);
// Se escribe el documento ya sea en un fichero o en una cadena de texto
            serializer.write(doc, output);
// String xmlCad=serializer.writeToString(document);
        } catch (DOMException e) {
            return;
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        String ruta = "C:\\Users\\Zer0\\Desktop\\peliculas.xml";
        String rutaSalida = "C:\\Users\\Zer0\\Desktop\\newMovies.xml";
        Document doc = null;
        T2_Ejercicios gestorArbol = new T2_Ejercicios();
        doc = gestorArbol.crearArbol(ruta);
        String titulo = "Matrix";
        String atributoNodo = "presupuesto";
        String atributovalor = "300.000.000 $";
        String titul="Depredador";
        String direc= "John";
        String apell= "Tierman";
        String estre="1987";
        String gene="acción";
        String idiom="en";
//        gestorArbol.datosPeliculas(doc);
//        gestorArbol.masDirectores(doc, 2);
//        gestorArbol.getGeneros(doc);
//        gestorArbol.añadirAtributo(doc, atributoNodo, atributovalor, titulo);
//        gestorArbol.borrarAtributo(doc, atributoNodo, titulo);
        gestorArbol.añadirPelicula(doc, rutaSalida,titul,direc,apell,estre,gene,idiom);
    }
}
