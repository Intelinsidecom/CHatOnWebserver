package com.sec.chaton.util;

import com.sec.chaton.p028io.entry.Entry;
import com.sec.chaton.p028io.entry.EntryField;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: ChatOnXmlParser.java */
/* renamed from: com.sec.chaton.util.y */
/* loaded from: classes.dex */
public class C1793y {

    /* renamed from: b */
    private static XmlPullParserFactory f6465b;

    /* renamed from: a */
    private Entry f6466a;

    /* renamed from: a */
    private static XmlPullParser m6104a(InputStream inputStream) throws XmlPullParserException {
        if (f6465b == null) {
            f6465b = XmlPullParserFactory.newInstance();
            f6465b.setNamespaceAware(true);
        }
        XmlPullParser xmlPullParserNewPullParser = f6465b.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    public Object m6111a(InputStream inputStream, Class cls) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, IllegalArgumentException {
        XmlPullParser xmlPullParserM6104a = m6104a(inputStream);
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.newInstance();
        m6108a(xmlPullParserM6104a, cls, objNewInstance);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m6108a(XmlPullParser xmlPullParser, Class cls, Object obj) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        String name = "";
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f6466a != null) {
                    m6105a(obj, name);
                }
                name = xmlPullParser.getName();
                if (xmlPullParser.getAttributeCount() > 0) {
                    m6107a(obj, name, xmlPullParser);
                }
            } else if (eventType == 3) {
                if (name == xmlPullParser.getName()) {
                    if (this.f6466a != null) {
                        m6105a(obj, name);
                    }
                    name = "";
                    this.f6466a = null;
                }
            } else if (eventType == 4 && name != null && !name.equals("")) {
                m6106a(obj, name, xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private void m6105a(Object obj, String str) {
        try {
            ((ArrayList) obj.getClass().getField(str).get(obj)).add(this.f6466a);
            this.f6466a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m6107a(Object obj, String str, XmlPullParser xmlPullParser) {
        try {
            this.f6466a = (Entry) ((EntryField) obj.getClass().getField(str).getAnnotation(EntryField.class)).type().newInstance();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                m6106a(this.f6466a, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m6106a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            if (field.getType() == ArrayList.class) {
                if (this.f6466a == null) {
                    this.f6466a = (Entry) ((EntryField) field.getAnnotation(EntryField.class)).type().newInstance();
                }
                if (this.f6466a != null) {
                    this.f6466a.value = (String) obj2;
                    return;
                }
                return;
            }
            field.set(obj, m6101a(field.getType(), obj2));
        } catch (Exception e) {
            C1786r.m6065d("runtime fail [fieldName]" + str + " [value]" + obj2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private Object m6101a(Class cls, Object obj) {
        String string = obj.toString();
        if (cls.getName().equals(Integer.class.getName())) {
            return Integer.valueOf(Integer.parseInt(string));
        }
        if (cls.getName().equals(Long.class.getName())) {
            return Long.valueOf(Long.parseLong(string));
        }
        if (cls.getName().equals(Double.class.getName())) {
            return Double.valueOf(Double.parseDouble(string));
        }
        if (cls.getName().equals(Float.class.getName())) {
            return Float.valueOf(Float.parseFloat(string));
        }
        if (cls.getName().equals(Boolean.class.getName())) {
            return Boolean.valueOf(Boolean.parseBoolean(string));
        }
        return string;
    }

    /* renamed from: a */
    public String m6112a(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m6109c(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m6103a((HashMap) obj));
        } else {
            sb.append(m6109c(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: b */
    public String m6113b(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m6110d(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m6103a((HashMap) obj));
        } else {
            sb.append(m6109c(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: a */
    private String m6103a(HashMap map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append(m6102a((String) map.get(str)));
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        return sb.toString();
    }

    /* renamed from: c */
    private String m6109c(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        Class<?> cls = obj.getClass();
        sb.append("<");
        sb.append(cls.getSimpleName().toLowerCase());
        for (Field field : cls.getFields()) {
            String name = field.getName();
            if (cls.getField(name).get(obj) != null && !"value".equals(name)) {
                sb.append(" ");
                sb.append(name);
                sb.append("=\"");
                sb.append(m6102a(cls.getField(name).get(obj).toString()));
                sb.append("\"");
            }
        }
        sb.append(">");
        Object obj2 = cls.getField("value").get(obj);
        if (obj2 != null) {
            sb.append(m6102a(obj2.toString()));
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: d */
    private String m6110d(Object obj) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        Class<?> cls = obj.getClass();
        sb.append("<");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        for (Field field : cls.getFields()) {
            sb.append("<");
            String name = field.getName();
            sb.append(name);
            sb.append(">");
            sb.append(m6102a(cls.getField(name).get(obj).toString()));
            sb.append("</");
            sb.append(name);
            sb.append(">\n");
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m6102a(String str) {
        return str == null ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }
}
