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
        ParserDto parser = new ParserDto();
        List<Route> list = Arrays.asList(
                new Route("Placing"),
                new Route("ContractSection"),
                new Route("ContractMarket"),
                new Route("PremiumRegulatoryAllocationScheme"),
                new Route("Allocation"),
                new Route("AllocationReference")
        );

        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element rootElement = document.getRootElement();


        Map<Doc, String> map = new HashMap();

        findRecord(map, parser, rootElement, list);

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

    private static String cleanString(String s) {
        s = s.replaceAll("[^A-Za-zА-Яа-я0-9/]", "");
        return s;
    }

    private static void findRecord(Map<Doc, String> map, ParserDto parser, Element rootElement, List<Route> list) {
        for (Element e : rootElement.getChildren(parser.second)) {
            for (Element e1 : e.getChildren(parser.third)) {
                for (Element e2 : e1.getChildren(parser.forth)) {
                    for (Element e3 : e2.getChildren(parser.fifth)) {
                        for (Element e4 : e3.getChildren(parser.sixth)) {
//                            String[] mass =
                            Doc.Basis.setxPath(Collections.singletonList(cleanString(list.toString())));
                            map.put(Doc.Basis, e4.getText());
                        }
                    }
                }
            }
        }
    }
}
///Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference