package com.trainee.demo;

import org.jdom2.JDOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException, SAXException, ParserConfigurationException, URISyntaxException, XPathExpressionException {
        Map<Doc, String> map = new HashMap();
        List<String> parse = Parser.parse(Doc.REFERENCE.getxPath().get(0));
        File fXmlFile = new File("example.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc =dBuilder.parse(fXmlFile);
        XPathExpression xp = XPathFactory.newInstance().newXPath().compile("/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference");
        NodeList links = (NodeList) xp.evaluate(doc, XPathConstants.NODESET);
        System.out.println(links.item(0).getChildNodes().item(0).getNodeValue());
    }

    private static void showDocument(Document doc) {
        StringBuffer content = new StringBuffer();
        NodeList childNodes = doc.getChildNodes();
//        NamedNodeMap attributes = childNodes.getAttributes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            System.out.println("= "+childNodes.item(i));
        }
        Node node = doc.getChildNodes().item(0);
        ApplicationNode appNode = new ApplicationNode(node);

        content.append("Application \n");

        List<ClassNode> classes = appNode.getClasses();

        for (int i = 0; i < classes.size(); i++) {
            ClassNode classNode = classes.get(i);

            List<MethodNode> methods = classNode.getMethods();

            for (int j = 0; j < methods.size(); j++) {
                MethodNode methodNode = methods.get(j);
                content.append("Method: " + methodNode.getSome() + " \n");
            }
        }
        System.out.println(content);
    }

    public static class ClassNode {

        Node node;

        /**
         * Создаем новый экземпляр объекта на основе Node узла.
         */
        public ClassNode(Node node) {
            this.node = node;
        }

        /**
         * Возвращает список методов класса.
         */
        public List<MethodNode> getMethods() {
            ArrayList<MethodNode> methods = new ArrayList<MethodNode>();

            /**
             * Получаем список дочерних узлов для данного узла XML,
             * который соответствует классу class. Здесь будут располагаться
             * все узлы Node, каждый из которых является объектным
             * представлением тега method для текущего тега class.
             */

            NodeList methodNodes = node.getChildNodes();

            for (int i = 0; i < methodNodes.getLength(); i++) {
                node = methodNodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    /**
                     * Создаем на основе Node узла своё объектное представление
                     * метода.
                     */
                    MethodNode methodNode = new MethodNode(node);
                    methods.add(methodNode);
                }
            }

            return methods;
        }

        /**
         * Возвращае имя класса.
         */
//        public String getName() {
//
//            /**
//             * Получаем атрибуты узла метода.
//             */
//            NamedNodeMap attributes = node.getAttributes();
//
//            /**
//             * Получаем узел аттрибута.
//             */
//            Node nameAttrib = attributes.getNamedItem("Agency");
//
//            /**
//             * Возвращаем значение атрибута.
//             */
//            return nameAttrib.getNodeValue();
//        }
    }

    public static class MethodNode {

        Node node;

        /**
         * Создаем новый экземпляр объекта на основе Node узла.
         */
        public MethodNode(Node node) {
            this.node = node;
        }

        public String getSome() {
            return this.node.getNodeName();
        }

        /**
         * Возвращает имя метода.
         */
//        public String getName() {
//
//            /**
//             * Получаем атрибуты узла метода.
//             */
//            NamedNodeMap attributes = node.getAttributes();
//
//            /**
//             * Получаем узел аттрибута.
//             */
//            Node nameAttrib = attributes.getNamedItem("ContractSection");
//
//            /**
//             * Возвращаем значение атрибута.
//             */
//            return nameAttrib.getNodeValue();
//        }
    }

    public static class ApplicationNode {

        Node node;

        public ApplicationNode(Node node) {
            this.node = node;
        }

        public List<ClassNode> getClasses() {
            ArrayList<ClassNode> classes = new ArrayList<ClassNode>();

            /**
             * Получаем список дочерних узлов для данного узла XML, который
             * соответствует приложению application. Здесь будут располагаться
             * все узлы Node, каждый из которых является объектным
             * представлением тега class для текущего тега application.
             */
            NodeList classNodes = node.getChildNodes();

            for (int i = 0; i < classNodes.getLength(); i++) {
                Node node = classNodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    /**
                     * Создаем на основе Node узла своё объектное
                     * представление класса.
                     */
                    ClassNode classNode = new ClassNode(node);
                    classes.add(classNode);
                }
            }

            return classes;
        }

    }


}