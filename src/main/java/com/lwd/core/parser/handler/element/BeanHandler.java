package com.lwd.core.parser.handler.element;

import com.lwd.core.bean.BeanDefinition;
import com.lwd.core.parser.handler.attribute.AttributeHandler;
import com.lwd.core.parser.handler.attribute.ClassAttributeHandler;
import com.lwd.core.parser.handler.attribute.IdAttributeHandler;
import com.lwd.core.parser.handler.attribute.NameAttributeHandler;
import org.xml.sax.Attributes;

import java.util.LinkedList;
import java.util.Map;

//TODO hide linked list behind custom stack implementation
public class BeanHandler implements ElementHandler {

    //TODO Should contain only reference to a single object shared by all manners of handlers.
    private Map<String, AttributeHandler> attributeHandlerMap;

    //TODO configurable list of handlers.
    public BeanHandler() {
        attributeHandlerMap.put("class", new ClassAttributeHandler());
        attributeHandlerMap.put("id", new IdAttributeHandler());
        attributeHandlerMap.put("name", new NameAttributeHandler());
    }

    public void handle(Attributes attributes, LinkedList<Object> stack) {
        BeanDefinition beanDefinition = new BeanDefinition();
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