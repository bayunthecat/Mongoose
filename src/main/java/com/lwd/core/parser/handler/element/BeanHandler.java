package com.lwd.core.parser.handler.element;

import com.lwd.core.bean.BeanDefinition;
import com.lwd.core.parser.handler.attribute.AttributeHandler;
import com.lwd.core.parser.handler.attribute.ClassAttributeHandler;
import com.lwd.core.parser.handler.attribute.IdAttributeHandler;
import com.lwd.core.parser.handler.attribute.NameAttributeHandler;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BeanHandler implements ElementHandler {

    private Map<String, AttributeHandler> attributeHandlerMap;

    public BeanHandler() {
        attributeHandlerMap = new HashMap<>();
        attributeHandlerMap.put("class", new ClassAttributeHandler());
        attributeHandlerMap.put("id", new IdAttributeHandler());
        attributeHandlerMap.put("name", new NameAttributeHandler());
    }

    public void BeanHandler(Map<String, AttributeHandler> attributeHandlerMap) {
        this.attributeHandlerMap = attributeHandlerMap;
    }

    @SuppressWarnings("unchecked")
    public void handleStart(Attributes attributes, LinkedList<Object> stack) {
        BeanDefinition beanDefinition = new BeanDefinition();
        ((List<BeanDefinition>)stack.peek()).add(beanDefinition);
        for(int i = 0; i < attributes.getLength(); i++) {
            AttributeHandler attributeHandler = attributeHandlerMap.get(attributes.getQName(i));
            processAttribute(attributeHandler, attributes.getValue(i), beanDefinition);
        }
    }

    private void processAttribute(AttributeHandler attributeHandler, String attributeValue ,BeanDefinition beanDefinition) {
        if(attributeHandler != null) {
            attributeHandler.handle(beanDefinition, attributeValue);
        }
    }
}