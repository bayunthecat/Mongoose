package com.lwd.core.parser.handler.attribute;

import com.lwd.core.bean.BeanDefinition;

public interface AttributeHandler {

    BeanDefinition handle(BeanDefinition beanDefinition, String attributeValue);

}
