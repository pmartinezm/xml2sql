package controlador.xml2java;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import util.Log;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Xml2Java {
    private String path;
    private Document doc;

    public Xml2Java(String path) {
        this.path = path;
        this.initialize();
    }

    private void initialize() {
        File xmlFile = this.getFile(this.path);
        this.doc = this.getDocument(xmlFile);
    }

    private File getFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            Log.msg("File found.");
            return file;
        }
        Log.error("File does not exist.");
        return null;
    }

    private Document getDocument(File xmlFile) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Log.msg("Xml document generated.");
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            Log.error("Can't generate xml document.");
            return null;
        }
    }

    public Document getXmlDoc() {
        return this.doc;
    }
}
