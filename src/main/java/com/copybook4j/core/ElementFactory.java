package com.copybook4j.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ElementFactory {

    private static final Map<Class<? extends AbstractElement>, Element.Test> tests = new HashMap<>();

    public static void register(Class<? extends AbstractElement> klass, Element.Test test) {
        tests.put(klass, test);
    }

    Element build(int level, String name, String[] typeSpec, int index) {
        Optional<? extends Class<? extends AbstractElement>> elementClass = tests.entrySet()
                .stream()
                .filter(t -> t.getValue().test(typeSpec, index))
                .map(Map.Entry::getKey)
                .findFirst();

        if (elementClass.isPresent()) {
            try {
                AbstractElement element = elementClass.get()
                        .getConstructor(Integer.class, String.class)
                        .newInstance(level, name);
                element.populateTypeSpec(typeSpec, index);

                return element;
            } catch (Exception e) {
                throw new Error("Missing constructor for " + elementClass.get());
            }
        }

        throw new IllegalArgumentException("No Matching Elements found");
    }
}
