package com.example.unmodifyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.unmodifiable1();
        main.unmodifiable2();
        main.unmodifiable3();
    }

    private void unmodifiable1() {
        System.out.println("unmodifiable1: created by Arrays.asList(...)");
        
        try {
            List<String> list = Arrays.asList("somewhere", "over", "the", "rainbow");
            list.add("hello"); // throws java.lang.UnsupportedOperationException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unmodifiable2() {
        System.out.println("unmodifiable2: created by Arrays.asList(...) and opened");
        
        //construct a new, modifiable list with the elements of the original
        List<String> list = new ArrayList<>(Arrays.asList("somewhere", "over", "the", "rainbow"));
        
        list.add("hello"); // OK
        System.out.println(list);
    }

    private void unmodifiable3() {
        System.out.println("unmodifiable3: created by Collections.unmodifiableList(list), "
                + "but new element added to the original");
        
        List<String> list = new ArrayList<>(Arrays.asList("somewhere", "over", "the", "rainbow"));
        List<String> ul = Collections.unmodifiableList(list);
        
        list.add("hello"); //also changes ul
        System.out.println(ul);
    }
}
