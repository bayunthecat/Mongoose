package com.lwd.core.parser.handler.attribute;

import com.lwd.core.bean.BeanDefinition;

public class NameAttributeHandler implements AttributeHandler {

    public BeanDefinition handle(BeanDefinition beanDefinition, String attributeValue) {
        beanDefinition.setName(attributeValue);
        return beanDefinition;
    }
}
