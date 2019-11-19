/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejerciciossax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Zer0
 */
public class ParserSAXD extends DefaultHandler {

    String qName = "";
    int cont = 0;
    String titulo = "";
    List<String> generos = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument() throws SAXException {
              System.out.println("Hay "+generos.size()+" generos.");
        System.out.println("Fin del documento XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("pelicula")) {
        for (int i = 0; i < attributes.getLength(); i++) {

                if (generos.contains(attributes.getQName(i))) {
                    
                } else {
                    generos.add(attributes.getQName(i));
                }
                
            }
 
        }
         
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cad = new String(ch, start, length);

    }

}
