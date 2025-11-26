package com.sec.chaton.trunk.parser;

import java.io.InputStream;
import java.lang.reflect.Field;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public abstract class AbstractXmlParser {
    protected XPath xpath = XPathFactory.newInstance().newXPath();

    protected Node findNode(Node node, String str) {
        return (Node) this.xpath.evaluate(str, node, XPathConstants.NODE);
    }

    protected String getValueOfNode(Node node, String str) {
        Node nodeFindNode = findNode(node, str);
        if (nodeFindNode != null) {
            return nodeFindNode.getFirstChild().getNodeValue();
        }
        return null;
    }

    public abstract Object parse(InputStream inputStream);

    protected void setAttributeToObject(Object obj, NamedNodeMap namedNodeMap) throws Exception {
        Class<?> cls = obj.getClass();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            String nodeName = namedNodeMap.item(i).getNodeName();
            setAttributeValue(obj, cls.getField(nodeName), namedNodeMap.item(i).getNodeValue());
        }
    }

    protected void setAttributeValue(Object obj, Field field, String str) throws Exception {
        Class<?> type = field.getType();
        if (type == Integer.TYPE) {
            field.set(obj, Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (type == Long.TYPE) {
            field.set(obj, Long.valueOf(Long.parseLong(str)));
            return;
        }
        if (type == Float.TYPE) {
            field.set(obj, Float.valueOf(Float.parseFloat(str)));
            return;
        }
        if (type == Double.TYPE) {
            field.set(obj, Double.valueOf(Double.parseDouble(str)));
        } else if (type == Boolean.TYPE) {
            field.set(obj, Boolean.valueOf(Boolean.parseBoolean(str)));
        } else {
            if (type != String.class) {
                throw new Exception("Unknown type");
            }
            field.set(obj, str);
        }
    }
}
