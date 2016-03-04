package com.lwd.core.parser.handler.attribute;

import com.lwd.core.bean.BeanDefinition;

public class IdAttributeHandler implements AttributeHandler {

    public BeanDefinition handle(BeanDefinition beanDefinition, String attributeValue) {
        if(attributeValue != null) {
            beanDefinition.setId(attributeValue);
        }
        //TODO add unique id generation
        return beanDefinition;
    }
}
