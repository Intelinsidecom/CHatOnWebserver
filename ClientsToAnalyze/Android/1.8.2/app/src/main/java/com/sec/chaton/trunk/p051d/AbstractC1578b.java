package com.sec.chaton.trunk.p051d;

import java.io.InputStream;
import java.lang.reflect.Field;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: AbstractXmlParser.java */
/* renamed from: com.sec.chaton.trunk.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC1578b {

    /* renamed from: q */
    protected XPath f5683q = XPathFactory.newInstance().newXPath();

    /* renamed from: a */
    public abstract Object mo2369a(InputStream inputStream);

    /* renamed from: a */
    protected void m5454a(Object obj, NamedNodeMap namedNodeMap) throws Exception {
        Class<?> cls = obj.getClass();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            String nodeName = namedNodeMap.item(i).getNodeName();
            m5453a(obj, cls.getField(nodeName), namedNodeMap.item(i).getNodeValue());
        }
    }

    /* renamed from: a */
    protected void m5453a(Object obj, Field field, String str) throws Exception {
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
            if (type == String.class) {
                field.set(obj, str);
                return;
            }
            throw new Exception("Unknown type");
        }
    }

    /* renamed from: a */
    protected String m5452a(Node node, String str) {
        Node nodeM5455b = m5455b(node, str);
        if (nodeM5455b != null) {
            return nodeM5455b.getFirstChild().getNodeValue();
        }
        return null;
    }

    /* renamed from: b */
    protected Node m5455b(Node node, String str) {
        return (Node) this.f5683q.evaluate(str, node, XPathConstants.NODE);
    }
}
