/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejerciciossax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Zer0
 */
public class ParserSAXC extends DefaultHandler {

    String qName = "";
    int cont = 0;
    int n = 0;
    String titulo="";

    public ParserSAXC(int n) {
        this.n = n;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName=qName;
        if (qName.equals("director")) {
            cont++;
        }
        if (qName.equals("pelicula")) {
            this.titulo="";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("pelicula")) {
            if (cont>=n){
                System.out.println("mi peli "+titulo);
            }
            cont=0;
        }
       this.qName="";
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cad = new String(ch, start, length);
        if (qName.equals("titulo")) {
           
            this.titulo=cad;
         
        }

    }

    
}
