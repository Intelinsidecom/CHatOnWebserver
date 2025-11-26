package com.sec.chaton.trunk.p041a;

import java.io.InputStream;
import java.lang.reflect.Field;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: AbstractXmlParser.java */
/* renamed from: com.sec.chaton.trunk.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1098b {

    /* renamed from: a */
    protected XPath f3859a = XPathFactory.newInstance().newXPath();

    /* renamed from: a */
    public abstract Object mo2725a(InputStream inputStream);

    /* renamed from: a */
    protected void m4090a(Object obj, NamedNodeMap namedNodeMap) throws Exception {
        Class<?> cls = obj.getClass();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            String nodeName = namedNodeMap.item(i).getNodeName();
            m4089a(obj, cls.getField(nodeName), namedNodeMap.item(i).getNodeValue());
        }
    }

    /* renamed from: a */
    protected void m4089a(Object obj, Field field, String str) throws Exception {
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
    protected String m4088a(Node node, String str) {
        Node nodeM4091b = m4091b(node, str);
        if (nodeM4091b != null) {
            return nodeM4091b.getFirstChild().getNodeValue();
        }
        return null;
    }

    /* renamed from: b */
    protected Node m4091b(Node node, String str) {
        return (Node) this.f3859a.evaluate(str, node, XPathConstants.NODE);
    }
}
