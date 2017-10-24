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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException {
        List<String> list = Parser.parse(Doc.Reference.getxPath().get(0));

        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element rootElement = document.getRootElement();


        Map<Doc, String> map = new HashMap();
        findRecordForFive(map, rootElement, list);
        findRecordForFour(map, rootElement, list);
        findRecordForFour(map, rootElement, list);
        findRecordForTwo(map, rootElement, list);
        findRecordForOne(map, rootElement, list);
        System.out.println();
        System.out.println();
        map.forEach((key, value) -> System.out.println("key = " + key + " value =  " + value + " path = " + key.getxPath()));
    }

    private static void findRecordForOne(Map<Doc, String> map, Element rootElement, List<String> list) {
        int i = 0;
        System.out.println("S1 = " + list.get(i));
        for (Element e1 : rootElement.getChildren(list.get(i))) {
            map.put(Doc.Cancel, e1.getText());
            return;
        }


    }

    private static void findRecordForFive(Map<Doc, String> map, Element rootElement, List<String> list) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        System.out.println("S1 = " + list.get(i));
        for (Element e : rootElement.getChildren(list.get(i))) {
            System.out.println("S2 = " + list.get(i));
            for (Element e1 : e.getChildren(list.get(++i))) {
                if (j != 0) {
                    i--;
                }
                j++;
                System.out.println("S3 = " + list.get(i));
                for (Element e2 : e1.getChildren(list.get(++i))) {
                    if (k != 0) {
                        i--;
                    }
                    k++;
                    System.out.println("S4 = " + list.get(i) + " id = " + i);
                    for (Element e3 : e2.getChildren(list.get(++i))) {
                        if (l != 0) {
                            i--;
                        }
                        l++;
                        System.out.println("S5 = " + list.get(i));
                        for (Element e4 : e3.getChildren(list.get(++i))) {
                            map.put(Doc.Reference, e4.getText());
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void findRecordForTwo(Map<Doc, String> map, Element rootElement, List<String> list) {
        int i = 0;
        int j = 0;
        System.out.println("S1 = " + list.get(i));
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            System.out.println("S2 = " + list.get(i));

            for (Element e1 : e.getChildren(list.get(++i))) {
                map.put(Doc.Cancel, e1.getText());
                return;
            }

        }
    }

    private static void findRecordForThree(Map<Doc, String> map, Element rootElement, List<String> list) {
        int i = 0;
        int j = 0;
        int k = 0;
        System.out.println("S1 = " + list.get(i));
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            System.out.println("S2 = " + list.get(i));
            for (Element e2 : e.getChildren(list.get(++i))) {
                if (k != 0) {
                    i--;
                }
                k++;
                System.out.println("S5 = " + list.get(i));
                for (Element e3 : e2.getChildren(list.get(++i))) {
                    map.put(Doc.Cancel, e3.getText());
                    return;
                }
            }
        }
    }

    private static void findRecordForFour(Map<Doc, String> map, Element rootElement, List<String> list) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        System.out.println("S1 = " + list.get(i));
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            System.out.println("S2 = " + list.get(i));
            for (Element e2 : e.getChildren(list.get(++i))) {
                if (k != 0) {
                    i--;
                }
                k++;
                System.out.println("S3 = " + list.get(i));
                for (Element e3 : e2.getChildren(list.get(++i))) {
                    if (l != 0) {
                        i--;
                    }
                    l++;
                    System.out.println("S4 = " + list.get(i));
                    for (Element e4 : e3.getChildren(list.get(++i))) {
                        map.put(Doc.Cancel, e4.getText());
                        return;
                    }
                }
            }
        }
    }
}

///Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference