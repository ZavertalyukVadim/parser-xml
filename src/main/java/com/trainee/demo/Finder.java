package com.trainee.demo;

import org.jdom2.Element;

import java.util.List;
import java.util.Map;

public class Finder {

    public static void findRecordForOne(Map<Doc, String> map, Element rootElement, List<String> list, Doc doc) {
        int i = 0;
        for (Element e1 : rootElement.getChildren(list.get(i))) {
            String text =  e1.getText();
            if (text.isEmpty())
            map.put(doc,"");
            else
                map.put(doc,text);
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
                String text =  e1.getText();
                if (text.isEmpty())
                    map.put(doc,"!!!!!!");
                else
                    map.put(doc,text);
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
                    String text =  e3.getText();
                    if (text.isEmpty())
                        map.put(doc,"!!!!!!");
                    else
                        map.put(doc,text);
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
                        String text =  e4.getText();
                        if (text.isEmpty())
                            map.put(doc,"!!!!!!");
                        else
                            map.put(doc,text);
                        return;
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
                            String text =  e4.getText();
                            if (text.isEmpty())
                                map.put(doc,"!!!!!!");
                            else
                                map.put(doc,text);
                            return;
                        }
                    }
                }
            }
        }
    }

}
