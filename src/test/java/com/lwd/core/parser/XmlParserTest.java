package com.lwd.core.parser;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class XmlParserTest {

    private static final String RESOURCE_NAME = "test.xml";

    private XmlParser parser;

    private SAXParser saxParser;

    private InputStream resource;

    @Before
    public void init() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        saxParser = factory.newSAXParser();
        parser = new XmlParser();
        resource = this.getClass().getClassLoader().getResourceAsStream(RESOURCE_NAME);
    }

    @Test
    public void testParse() throws IOException, SAXException {
        saxParser.parse(resource, parser);
        System.out.println(parser.getBeanDefinitionList());
    }
}