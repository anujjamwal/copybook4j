package com.copybook4j.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anujjamwal on 13/07/17.
 */
public class TypeDefinition {
    private List<Pair<DataType, Integer>> typeDef;

    public List<Pair<DataType, Integer>> getTypeDef() {
        return typeDef;
    }

    private TypeDefinition() {
        typeDef = new ArrayList<>();
    }

    static TypeDefinition build(String spec) {
        TypeDefinition def = new TypeDefinition();

        for (int i = 0; i < spec.length(); ) {
            char lastChar = spec.charAt(i);
            int firstIndex = i;

            while (i < spec.length() && lastChar == spec.charAt(i))
                i++;

            if (i < spec.length() && spec.charAt(i) == '(') {
                int count = 0;
                while (spec.charAt(++i) != ')') {
                    count = count * 10 + (spec.charAt(i) - '0');
                }
                i++;
                def.typeDef.add(new Pair<>(DataType.lookup(lastChar), count));
            } else {
                def.typeDef.add(new Pair<>(DataType.lookup(lastChar), i - firstIndex));
            }
        }

        return def;
    }
}
