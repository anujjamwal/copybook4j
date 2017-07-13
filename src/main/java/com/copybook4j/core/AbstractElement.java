package com.copybook4j.core;

/**
 * Created by anujjamwal on 11/07/17.
 */

public abstract class AbstractElement implements Element {
    private final Integer level;
    private final String name;

    public AbstractElement(Integer level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public Integer level() {
        return level;
    }

    @Override
    public String name() {
        return name;
    }

    public abstract void populateTypeSpec(String[] typeSpec, int index);

    static {
        try {
            Class.forName(AlphanumericElement.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class NumericElement {
}

class AlphanumericElement extends AbstractElement {

    private TypeDefinition typeDef;

    static {
        ElementFactory.register(AlphanumericElement.class, (tokens, start) -> true);
    }

    public AlphanumericElement(Integer level, String name) {
        super(level, name);
    }

    @Override
    public void populateTypeSpec(String[] typeSpec, int index) {
        typeDef = TypeDefinition.build(typeSpec[index]);
    }
}

class DBCSElement {

}

class FloatElement {

}
