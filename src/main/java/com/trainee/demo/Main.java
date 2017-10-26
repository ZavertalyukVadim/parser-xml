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
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        Map<Doc, String> map = new HashMap();
        List<String> parse = Parser.parse(Doc.REFERENCE.getxPath().get(0));

        File fXmlFile = new File("example.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        XPathExpression xp = XPathFactory.newInstance().newXPath().compile("/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference");

        NodeList links = (NodeList) xp.evaluate(doc, XPathConstants.NODESET);

        System.out.println(links.item(0).getChildNodes().item(0).getNodeValue());
    }
}