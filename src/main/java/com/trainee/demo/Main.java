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

import static com.trainee.demo.Finder.*;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException {
        List<String> list = Parser.parse(Doc.Reference.getxPath().get(0));

        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element rootElement = document.getRootElement();


        Map<Doc, String> map = new HashMap();

        findRecordForOne(map, rootElement, list);
        findRecordForTwo(map, rootElement, list);
        findRecordForThree(map, rootElement, list);
        findRecordForFour(map, rootElement, list);
        findRecordForFive(map, rootElement, list);

        System.out.println();
        System.out.println();
        map.forEach((key, value) -> System.out.println("key = " + key + " value =  " + value + " path = " + key.getxPath()));
    }
}