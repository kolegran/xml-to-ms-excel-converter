package parse;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// xmls without attributes, one level of nesting
public class SimpleXmlParser {

    public List<Map<String, String>> parse(String resourcePath, String tag) {
        final List<Map<String, String>> parsedXml = new ArrayList<>();
        Document document = XmlUtil.getDocument(SimpleXmlParser.class, resourcePath);
        XmlUtil.forEachElement(document.getElementsByTagName(tag), element -> {

            final Map<String, String> map = new HashMap<>();
            XmlUtil.forEachElement(element.getChildNodes(), item -> {
                map.put(item.getNodeName(), item.getTextContent());
            });

            parsedXml.add(map);
        });
        return parsedXml;
    }
}
