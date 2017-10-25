package com.trainee.demo;

import org.jdom2.Element;

import java.util.List;
import java.util.Map;

public class Finder {

    public static void findRecordForOne(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        List<Element> element = rootElement.getChildren(list.get(i));
        if (element.size()==0){
            map.put(doc,"");
            return;
        }
        for (Element e1 : rootElement.getChildren(list.get(i))) {
            map.put(doc, e1.getText());
            return;
        }


    }


    public static void findRecordForTwo(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        int j = 0;
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            for (Element e1 : e.getChildren(list.get(++i))) {
                map.put(doc, e1.getText());
                return;
            }

        }
    }


    public static void findRecordForThree(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        int j = 0;
        int k = 0;
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            for (Element e2 : e.getChildren(list.get(++i))) {
                if (k != 0) {
                    i--;
                }
                k++;
                for (Element e3 : e2.getChildren(list.get(++i))) {
                    map.put(doc, e3.getText());
                    return;
                }
            }
        }
    }

    public static void findRecordForFour(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        for (Element e : rootElement.getChildren(list.get(i))) {
            if (j != 0) {
                i--;
            }
            j++;
            for (Element e2 : e.getChildren(list.get(++i))) {
                if (k != 0) {
                    i--;
                }
                k++;
                for (Element e3 : e2.getChildren(list.get(++i))) {
                    if (l != 0) {
                        i--;
                    }
                    l++;
                    for (Element e4 : e3.getChildren(list.get(++i))) {
                        System.out.println(e4.getText());
                        map.put(doc, e4.getText());
                        if (l>2){
                            map.put(doc, "");
                            return;
                        }
//                        return;
                    }
                }
            }
        }
    }

    public static void findRecordForFive(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        for (Element e : rootElement.getChildren(list.get(i))) {
            for (Element e1 : e.getChildren(list.get(++i))) {
                if (j != 0) {
                    i--;
                }
                j++;
                for (Element e2 : e1.getChildren(list.get(++i))) {
                    if (k != 0) {
                        i--;
                    }
                    k++;
                    for (Element e3 : e2.getChildren(list.get(++i))) {
                        if (l != 0) {
                            i--;
                        }
                        l++;
                        for (Element e4 : e3.getChildren(list.get(++i))) {
                            map.put(doc, e4.getText());
                            return;
                        }
                    }
                }
            }
        }
    }

}
