package application;

import cddisk.CdDisk;
import cddisk.ToCdDiskConverter;
import parse.SimpleXmlParser;

import java.util.List;
import java.util.Map;

public class Application {
    private static final String CD_CATALOG_XML_PATH = "/xml/CdCatalog.xml";
    private static final String CD_TAG = "cd";

    public static void main(String[] args) {
        final List<Map<String, String>> parsedCdXml = new SimpleXmlParser().parse(CD_CATALOG_XML_PATH, CD_TAG);
        final ToCdDiskConverter toCdDiskConverter = new ToCdDiskConverter();
        final List<CdDisk> cdDisks = toCdDiskConverter.convert(parsedCdXml);

        for (CdDisk cdDisk : cdDisks) {
            System.out.println(cdDisk);
        }
    }
}
