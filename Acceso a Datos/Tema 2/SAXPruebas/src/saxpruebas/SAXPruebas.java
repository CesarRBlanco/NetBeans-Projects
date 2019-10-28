/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxpruebas;


import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;



/**
 *
 * @author Zer0
 */
public class SAXPruebas {

    public void getSax(String entradaXML) throws
            ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ParserSAX parserSax = new ParserSAX();
        parser.parse(entradaXML, parserSax);
    }

    public static void main(String[] args) {
        SAXPruebas s = new SAXPruebas();
        try {
            s.getSax("C:\\Users\\Zer0\\Desktop\\peliculas.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
