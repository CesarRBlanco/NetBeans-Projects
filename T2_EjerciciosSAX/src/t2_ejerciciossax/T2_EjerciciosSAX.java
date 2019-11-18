package t2_ejerciciossax;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class T2_EjerciciosSAX extends ParserSAXC {

    public T2_EjerciciosSAX(int n) {
        super(n);
    }


    public void getSax(String entradaXML) throws ParserConfigurationException, SAXException, IOException {
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ParserSAXC parserSax = new ParserSAXC(2);
        parser.parse(entradaXML, parserSax);
    }
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        String entradaXML = "C:\\Users\\Zer0\\Desktop\\peliculas.xml";
        T2_EjerciciosSAX uno = new T2_EjerciciosSAX(2);
        uno.getSax(entradaXML);
        
    }
    
}
