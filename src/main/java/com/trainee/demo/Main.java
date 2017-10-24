package com.trainee.demo;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException {
        Map<Doc, String> map = new HashMap();
        ParserDto parser = new ParserDto();
        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        System.out.println("document = " + document);
        Element rootElement = document.getRootElement();
        String str = "/" +parser.first + "/" + parser.second + "/" + parser.third + "/" + parser.forth + "/" + parser.fifth + "/" + parser.sixth;
        String[] mass = new String[]{str};

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(mass));


        for (Element e : rootElement.getChildren(parser.second)) {
            for (Element e1 : e.getChildren(parser.third)) {
                for (Element e2 : e1.getChildren(parser.forth)) {
                    for (Element e3 : e2.getChildren(parser.fifth)) {
                        for (Element e4 : e3.getChildren(parser.sixth)) {
                            System.out.println(e4.getText());
                            String text = e4.getText();
                            Doc.Basis.setxPath(list);
                            map.put(Doc.Basis, text);
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println();
        map.forEach((key, value) -> System.out.println("key = " + key + " value =  " + value + " path = " + key.getxPath()));

//        List<Element> contractSection = rootElement.getChildren("ContractSection");
//        for (Element aContractSection : contractSection) {
//            List<Element> contractMarket = aContractSection.getChildren("ContractMarket");
//            for (Element aContractMarket : contractMarket) {
//                List<Element> premiumRegulatoryAllocationScheme = aContractMarket.getChildren("PremiumRegulatoryAllocationScheme");
//                if (!premiumRegulatoryAllocationScheme.isEmpty()) {
//                    for (Element element : premiumRegulatoryAllocationScheme) {
//                        List<Element> allocation = element.getChildren("Allocation");
//                        for (Element element1 : allocation) {
//                            List<Element> allocationReference = element1.getChildren("AllocationReference");
//                            for (Element element2 : allocationReference) {
//                                System.out.println(element2.getTextNormalize());
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}
///Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference