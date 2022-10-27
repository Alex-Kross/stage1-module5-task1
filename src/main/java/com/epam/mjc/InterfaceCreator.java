package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            boolean result = true;
            for (String elList : list) {
                char firstLetter = elList.charAt(0);
                if (firstLetter < 65 || firstLetter > 90) {
                    result = false;
                    break;
                }
            }
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> newList = new ArrayList<>();
            for (int elList : list) {
                if (elList % 2 == 0) {
                    newList.add(elList);
                }
            }
            list.addAll(newList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String sequence: values) {
                if (sequence.endsWith(".") && sequence.charAt(0) >= 65 && sequence.charAt(0) <= 90) {
                    String[] words = sequence.split(" ");
                    int countWord = 0;
                    for (String word : words) {
                        char firstLetter = word.charAt(0);
                        if (firstLetter >= 65 && firstLetter <= 90 || firstLetter >= 97 && firstLetter <= 122) {
                            countWord++;
                        }
                    }
                    if (countWord > 3) {
                        list.add(sequence);
                    }
                }
            }
            return list;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : list) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list1);
            newList.addAll(list2);
            return  newList;
        };
    }
}
