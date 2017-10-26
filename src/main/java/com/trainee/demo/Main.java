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
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        Map<Doc, String> map = new HashMap();

        File fXmlFile = new File("example.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        int iterator = 0;

        XPathExpression xp = XPathFactory.newInstance().newXPath().compile(Doc.INSURED.getxPath().get(iterator));
        NodeList links = (NodeList) xp.evaluate(doc, XPathConstants.NODESET);


        while (links.getLength() == 0) {
            xp = XPathFactory.newInstance().newXPath().compile(Doc.INSURED.getxPath().get(iterator));
            links = (NodeList) xp.evaluate(doc, XPathConstants.NODESET);
            iterator++;
        }

        System.out.println("links = " + links.getLength());

        System.out.println(links.item(0).getChildNodes().item(0).getNodeValue());
    }
}