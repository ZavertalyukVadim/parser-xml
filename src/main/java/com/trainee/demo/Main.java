package com.trainee.demo;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String path = "example.xml";
        Doc[] values = Doc.values();
        Map<String, String> map = getDocStringMap(path, values);

        map.forEach((key, value) -> System.out.println(key + " value = " + value));
    }

    private static Map<String, String> getDocStringMap(String path, Doc[] values) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        Map<String, String> map = new LinkedHashMap<>();

        File fXmlFile = new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);

        XPathExpression xp;
        int iterator = 0;

        for (Doc doc : values) {
            try {
                xp = XPathFactory.newInstance().newXPath().compile(doc.getxPath().get(iterator));
            } catch (Exception transformerException) {
                map.put(doc.getLabel(), "Does not currently exist in the XML.");
                continue;
            }
            NodeList links = (NodeList) xp.evaluate(document, XPathConstants.NODESET);


            while (links.getLength() == 0) {
                xp = XPathFactory.newInstance().newXPath().compile(doc.getxPath().get(iterator));
                links = (NodeList) xp.evaluate(document, XPathConstants.NODESET);
                iterator++;
            }

            if (links.getLength() > 1) {
                map.put(doc.getLabel(), "Tag duplicates found – ref to xml");
                continue;
            }
            map.put(doc.getLabel(), links.item(0).getChildNodes().item(0).getNodeValue());
        }
        return map;
    }
}