package com.trainee.demo;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parse(String string){
        string = string.replaceAll("[^A-Za-zА-Яа-я0-9]", " ").trim();
        string = string.substring(7).trim();
        String[] str = string.split(" ");
        return Arrays.asList(str);
    }
}
