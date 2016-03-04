package com.lwd.core.parser.handler.attribute;

import com.lwd.core.bean.BeanDefinition;
import com.lwd.core.parser.exception.ClassDoesNotExistException;

public class ClassAttributeHandler implements AttributeHandler {

    public BeanDefinition handle(BeanDefinition beanDefinition, String attributeValue) {
        checkIfExists(attributeValue);
        beanDefinition.setFullQualifiedNameOfTheClass(attributeValue);
        return beanDefinition;
    }

    private void checkIfExists(String className) {
        try {
            Class.forName(className, false, this.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new ClassDoesNotExistException("Class with following name: " +
                    className + " cannot be found within classpath");
        }
    }
}
