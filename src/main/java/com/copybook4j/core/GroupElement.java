package com.copybook4j.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by anujjamwal on 11/07/17.
 */
public class GroupElement extends AbstractElement {
    private List<? super Element> elements;

    public GroupElement(Integer level, String name) {
        super(level, name);
        elements = new ArrayList<>();
    }

    @Override
    public void populateTypeSpec(String[] typeSpec, int index) {

    }

    public Collection<? super Element> elements() {
        return elements;
    }

    public <T extends Element> void append(T element) {
        elements.add(element);
    }
}
