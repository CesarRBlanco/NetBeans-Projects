/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxpruebas;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author Zer0
 */
class ParserSAX extends DefaultHandler {

    String qName = "";
    boolean fantasia = false;

    @Override
    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

        if (attributes.getValue("genero") != null) {
            if (attributes.getValue("genero").equals("Fantasia")) {
                fantasia = true;
            
            
            }
        }

      
        this.qName = qName;

    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (qName.equals("titulo") && fantasia) {
            String cad = new String(chars, i, i1);
            System.out.println(cad);
        }
    }

    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
        super.endElement(string, string1, string2); //To change body of generated methods, choose Tools | Templates.
        if (string2.equals("titulo")) {
            this.qName = "";
        }
        if (string2.equals("pelicula")) {
            
            fantasia = false;
        }
    }

}
