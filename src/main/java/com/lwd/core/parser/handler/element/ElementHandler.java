package com.lwd.core.parser.handler.element;

import org.xml.sax.Attributes;

import java.util.LinkedList;

public interface ElementHandler {

    void handleStart(Attributes attributes, LinkedList<Object> stack);
}
