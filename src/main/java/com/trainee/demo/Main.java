package com.trainee.demo;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException {
        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element classElement = document.getRootElement();
        System.out.println(classElement);
    }
}
