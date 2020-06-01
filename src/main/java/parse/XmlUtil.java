package parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.function.Consumer;

public final class XmlUtil {

    public static Document getDocument(Class<?> aClass, String path) {
        try (InputStream source = aClass.getResourceAsStream(path)) {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder parser = factory.newDocumentBuilder();
            return parser.parse(source);
        } catch (Exception e) {
            throw new XmlParsingException(e);
        }
    }

    private static class XmlParsingException extends RuntimeException {
        public XmlParsingException(Exception e) {
            super(e);
        }
    }

    public static void forEachElement(NodeList elements, Consumer<Element> consumer) {
        for (int i = 0; i < elements.getLength(); i++) {
            final Node item = elements.item(i);
            if (item instanceof Element) {
                consumer.accept((Element) item);
            }
        }
    }
}
