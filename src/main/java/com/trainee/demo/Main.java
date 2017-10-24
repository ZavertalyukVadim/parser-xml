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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException {

        List<String> list = Arrays.asList(
                "ContractSection",
                "ContractMarket",
                "PremiumRegulatoryAllocationScheme",
                "Allocation",
                "AllocationReference"
        );

        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element rootElement = document.getRootElement();


        Map<Doc, String> map = new HashMap();

        findRecord(map, rootElement, list);

        System.out.println();
        System.out.println();
        map.forEach((key, value) -> System.out.println("key = " + key + " value =  " + value + " path = " + key.getxPath()));
    }

    private static String cleanString(String s) {
        s = s.replaceAll("[^A-Za-zА-Яа-я0-9/]", "");
        return s;
    }

    private static void findRecord(Map<Doc, String> map, Element rootElement, List<String> list) {

        for (int i = 0; ; ) {
            System.out.println("S = " + list.get(i));
            for (Element e : rootElement.getChildren(list.get(i))) {
                i++;
                System.out.println("S = " + list.get(i));
                for (Element e1 : e.getChildren(list.get(i))) {
                    i++;
                    System.out.println("S? = " + list.get(i));
                    for (Element e2 : e1.getChildren(list.get(i--))) {
                        i++;
                        System.out.println("S! = " + list.get(i) + " id = " + i++);
                        for (Element e3 : e2.getChildren(list.get(i))) {
                            i++;
                            System.out.println("S = " + list.get(i));
                            for (Element e4 : e3.getChildren(list.get(i))) {
                                map.put(Doc.Basis, e4.getText());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
///Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference