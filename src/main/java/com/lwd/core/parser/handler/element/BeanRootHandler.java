package com.lwd.core.parser.handler.element;

import com.lwd.core.bean.BeanDefinition;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.LinkedList;

public class BeanRootHandler implements ElementHandler {

    public void handleStart(Attributes attributes, LinkedList<Object> stack) {
        stack.push(new ArrayList<BeanDefinition>());
    }
}
