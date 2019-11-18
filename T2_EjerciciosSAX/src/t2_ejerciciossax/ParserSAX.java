/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t2_ejerciciossax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Zer0
 */
public class ParserSAX extends DefaultHandler {

    String qName = "";

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
        System.out.printf("<" + qName + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.printf("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cad = new String(ch, start, length);
        System.out.printf( cad);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Aviso: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Error fatal: " + e.getMessage());
    }
}
