package com.trainee.demo;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
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
        Map<Doc, String> map = new HashMap();

        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);

        XPathFactory xFactory = XPathFactory.instance();

        XPathExpression<Element>expr = xFactory.compile("/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference", Filters.element());
        List<Element>links = expr.evaluate(document);
        for (Element linkElement : links) {
            System.out.println(linkElement.getText());
        }


//        Element el = new Element("parent").addContent(new Element("child").setAttribute("name", "value"));
//        System.out.println(XPath.selectSingleNode(new Attribute("foo", "bar"), "position()"));

//        XPath path = XPath.newInstance("/schedule/@name");
//        System.out.println(path.valueOf(document));

//        getChild(localName, namespaceUri)
//        for (Doc doc : Doc.values()) {
//            for (int j = 0; j < doc.getxPath().size(); ++j) {
//                List<String> list = Parser.parse(doc.getxPath().get(j));
//                switch (list.size()) {
//                    case 1: {
//                        findRecordForOne(map, rootElement, list, doc);
//                        break;
//                    }
//                    case 2: {
//                        findRecordForTwo(map, rootElement, list, doc);
//                        break;
//                    }
//                    case 3: {
//                        findRecordForThree(map, rootElement, list, doc);
//                        break;
//                    }
//                    case 4: {
//                        findRecordForFour(map, rootElement, list, doc);
//                        break;
//                    }
//                    case 5: {
//                        findRecordForFive(map, rootElement, list, doc);
//                        break;
//                    }
//                }
//
//            }
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println(map.size());
//        System.out.println();
//        System.out.println();
//        map.forEach((key, value) -> System.out.println("key = " + key + " value =  " + value + " path = " + key.getxPath()));
    }
}