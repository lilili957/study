package com.lilili.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @Author LiYuan
 * @Date 2021/8/19
 **/
public class XmlReader {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File f = new File("D:\\Demo\\test\\src\\com\\lilili\\xml\\test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(f);
        NodeList n1 = document.getElementsByTagName("action");
        for (int i = 0; i < n1.getLength(); i++) {
            System.out.println("result:" + document.getElementsByTagName("result")
                    .item(i).getFirstChild().getNodeValue());
        }
    }
}
