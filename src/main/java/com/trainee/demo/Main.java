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
import java.util.List;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException {
        File inputFile = new File("example.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        System.out.println("document = " + document);
        Element rootElement = document.getRootElement();
        List<Element> contractSection = rootElement.getChildren("ContractSection");
        for (Element aContractSection : contractSection) {
            List<Element> contractMarket = aContractSection.getChildren("ContractMarket");
            for (Element aContractMarket : contractMarket) {
                List<Element> premiumRegulatoryAllocationScheme = aContractMarket.getChildren("PremiumRegulatoryAllocationScheme");
                if (!premiumRegulatoryAllocationScheme.isEmpty()) {
                    for (Element element : premiumRegulatoryAllocationScheme) {
                        List<Element> allocation = element.getChildren("Allocation");
                        for (Element element1 : allocation) {
                            List<Element> allocationReference = element1.getChildren("AllocationReference");
                            for (Element element2 : allocationReference) {
                                System.out.println(element2.getTextNormalize());
                            }
                        }
                    }
                }
            }
        }
    }
}
///Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference