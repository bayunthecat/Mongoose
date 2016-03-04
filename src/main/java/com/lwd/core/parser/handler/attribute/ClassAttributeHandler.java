package com.lwd.core.parser.handler.attribute;

import com.lwd.core.bean.BeanDefinition;

//TODO add class existence check and throw exception
public class ClassAttributeHandler implements AttributeHandler {

    public BeanDefinition handle(BeanDefinition beanDefinition, String attributeValue) {
        beanDefinition.setFullQualifiedNameOfTheClass(attributeValue);
        return beanDefinition;
    }
}
