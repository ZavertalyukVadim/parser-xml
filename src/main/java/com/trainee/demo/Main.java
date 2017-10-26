package com.trainee.demo;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
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
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "example.xml";
        Doc[] values = Doc.values();
        Map<String, String> map = getDocStringMap(path, values);
        map.forEach((key, value) -> System.out.println(key + " value = " + value));
    }

    private static Map<String, String> getDocStringMap(String path, Doc[] values) {

        Map<String, String> map = new LinkedHashMap<>();

        File fXmlFile = new File(path);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;

        try {
            document = dBuilder.parse(fXmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        XPathExpression xp;


        for (Doc doc : values) {
            int iterator = 0;

            if (checkedPremiumCurrency(map, document, doc)) {
                continue;
            }

            if (checkedBrokenId(map, document, doc)){
                continue;
            }

            try {
                xp = XPathFactory.newInstance().newXPath().compile(doc.getxPath().get(iterator));
            } catch (Exception transformerException) {
                map.put(doc.getLabel(), "Does not currently exist in the XML.");
                continue;
            }

            NodeList links = null;

            try {
                links = (NodeList) xp.evaluate(document, XPathConstants.NODESET);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }


            while (links.getLength() == 0) {
                try {
                    xp = XPathFactory.newInstance().newXPath().compile(doc.getxPath().get(iterator));
                    links = (NodeList) xp.evaluate(document, XPathConstants.NODESET);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                iterator++;
            }

            if (links.getLength() > 1) {
                map.put(doc.getLabel(), "Tag duplicates found – ref to xml");
                continue;
            }

            map.put(doc.getLabel(), links.item(0).getTextContent());
        }
        return map;
    }

    private static boolean checkedPremiumCurrency(Map<String, String> map, Document document, Doc doc) {
        if (doc == Doc.PREMIUM_CURRENCY) {
            try {
                List<String> parsedString = Parser.parse(Doc.PREMIUM_CURRENCY.getxPath().get(0));

                XPathExpression xp1 = XPathFactory.newInstance().newXPath().compile(parsedString.get(0));

                NodeList nodeList = (NodeList) xp1.evaluate(document, XPathConstants.NODESET);

                NamedNodeMap attributes = nodeList.item(0).getAttributes();
                map.put(doc.getLabel(), attributes.getNamedItem("Ccy").getTextContent());
                return true;

            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static boolean checkedBrokenId(Map<String, String> map, Document document, Doc doc) {
        if (doc == Doc.BROKEN_ID) {
            try {
                List<String> parsedString = Parser.parse(Doc.BROKEN_ID.getxPath().get(0));

                XPathExpression xp1 = XPathFactory.newInstance().newXPath().compile(parsedString.get(0));

                NodeList nodeList = (NodeList) xp1.evaluate(document, XPathConstants.NODESET);

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node agency = nodeList.item(i).getAttributes().getNamedItem("Agency");
                    if (!agency.getNodeValue().contains("DUNS")) {
                        map.put(doc.getLabel(), agency.getNodeValue());
                        return true;
                    }
                }
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}