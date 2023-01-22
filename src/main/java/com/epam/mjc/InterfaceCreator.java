package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collections;
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
        return x -> {
            for (String str : x) {
                if (str.charAt(0) < 65 ||  str.charAt(0) > 90) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int listSize = x.size();
            for (int i = 0; i < listSize; i++) {
                int el = x.get(i);
                if (el % 2 == 0) {
                    x.add(el);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> filteredList = new ArrayList<>();
        return () -> {
            int startIndex = 0;
                for (String value : values) {
                    if (value.charAt(startIndex) >= 65 && value.charAt(startIndex) <= 90
                            && value.endsWith(".")) {
                        Predicate<String> isHaveMore3Word = x -> {
                            return x.split(" ").length > 3;
                        };
                        if (isHaveMore3Word.test(value)) {
                            filteredList.add(value);
                        }
                    }
                }
            return filteredList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String, Integer> letterScore = new HashMap<>();
        return x -> {
            for (String str : x) {
                letterScore.put(str, str.length());
            }
            return letterScore;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        List<Integer> newList = new ArrayList<>();
        return (x, y) -> {
            newList.addAll(x);
            newList.addAll(y);
            return newList;
        };
    }
}
