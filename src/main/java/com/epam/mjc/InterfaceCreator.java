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
        return x -> {
            for (String s : x) {
                if (!(s.charAt(0) > 64 && s.charAt(0) < 91)) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return (x) -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) x.add(x.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String s : values) {
                if (!(s.charAt(0) > 64 && s.charAt(0) < 91)) list.add(s);
                else if ((s.charAt(s.length() - 1)) != '.') list.add(s);
                else if (s.split(" ").length < 4) list.add(s);
            }
            values.removeAll(list);
            return values;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return (x) -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s: x){
                map.put(s, s.length());
            }
            return map;
        };

    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y)->{
            List<Integer>list = new ArrayList<>();
            list.addAll(x);
            list.addAll(y);
            return list;
        };

    }
}
