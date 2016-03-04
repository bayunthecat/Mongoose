package com.lwd.core.parser;


import com.lwd.core.parser.handler.element.BeanHandler;
import com.lwd.core.parser.handler.element.BeanRootHandler;
import com.lwd.core.parser.handler.element.ElementHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.Map;

public class XmlParser extends DefaultHandler {

    private LinkedList<Object> stack;

    private Map<String, ElementHandler> elementHandlerMap;

    //TODO configurable handlers list
    public XmlParser() {
        elementHandlerMap.put("beans", new BeanRootHandler());
        elementHandlerMap.put("bean", new BeanHandler());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementHandlerMap.get(qName).handle(attributes, stack);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}
