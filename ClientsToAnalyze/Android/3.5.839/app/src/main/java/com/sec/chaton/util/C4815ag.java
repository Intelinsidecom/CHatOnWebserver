package com.sec.chaton.util;

import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryField;
import com.sec.common.p126d.p127a.AbstractC4976a;
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
/* renamed from: com.sec.chaton.util.ag */
/* loaded from: classes.dex */
public class C4815ag extends AbstractC4976a {

    /* renamed from: c */
    private static XmlPullParserFactory f17580c;

    /* renamed from: a */
    private Entry f17581a;

    /* renamed from: b */
    private Class<?> f17582b;

    /* renamed from: a */
    private static XmlPullParser m18164a(InputStream inputStream) throws XmlPullParserException {
        if (f17580c == null) {
            f17580c = XmlPullParserFactory.newInstance();
            f17580c.setNamespaceAware(true);
        }
        XmlPullParser xmlPullParserNewPullParser = f17580c.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    public void m18173a(Class<?> cls) {
        this.f17582b = cls;
    }

    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            return m18171a(inputStream, this.f17582b);
        } catch (Exception e) {
            throw C1057b.m6157a(e);
        }
    }

    /* renamed from: a */
    public Object m18171a(InputStream inputStream, Class<?> cls) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, IllegalArgumentException {
        XmlPullParser xmlPullParserM18164a = m18164a(inputStream);
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.newInstance();
        m18168a(xmlPullParserM18164a, cls, objNewInstance);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m18168a(XmlPullParser xmlPullParser, Class<?> cls, Object obj) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        String name = "";
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f17581a != null) {
                    m18165a(obj, name);
                }
                name = xmlPullParser.getName();
                if (xmlPullParser.getAttributeCount() > 0) {
                    m18167a(obj, name, xmlPullParser);
                }
            } else if (eventType == 3) {
                if (name == xmlPullParser.getName()) {
                    if (this.f17581a != null) {
                        m18165a(obj, name);
                    }
                    name = "";
                    this.f17581a = null;
                }
            } else if (eventType == 4 && name != null && !name.equals("")) {
                m18166a(obj, name, xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private void m18165a(Object obj, String str) {
        if (str != null) {
            try {
                ((ArrayList) obj.getClass().getField(str).get(obj)).add(this.f17581a);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f17581a = null;
    }

    /* renamed from: a */
    private void m18167a(Object obj, String str, XmlPullParser xmlPullParser) {
        try {
            this.f17581a = (Entry) ((EntryField) obj.getClass().getField(str).getAnnotation(EntryField.class)).type().newInstance();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                m18166a(this.f17581a, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m18166a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            if (field.getType() == ArrayList.class) {
                if (this.f17581a == null) {
                    this.f17581a = (Entry) ((EntryField) field.getAnnotation(EntryField.class)).type().newInstance();
                }
                if (this.f17581a != null) {
                    this.f17581a.value = (String) obj2;
                    return;
                }
                return;
            }
            field.set(obj, m18161a(field.getType(), obj2));
        } catch (Exception e) {
            C4904y.m18645d("runtime fail [fieldName]" + str + " [value]" + obj2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private Object m18161a(Class<?> cls, Object obj) {
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
    public String m18172a(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m18169e(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m18163a((HashMap<String, String>) obj));
        } else {
            sb.append(m18169e(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: b */
    public String m18174b(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m18170f(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m18163a((HashMap<String, String>) obj));
        } else {
            sb.append(m18169e(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: c */
    public String m18175c(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m18169e(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m18163a((HashMap<String, String>) obj));
        } else {
            sb.append(m18169e(obj));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public String m18176d(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m18170f(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m18163a((HashMap<String, String>) obj));
        } else {
            sb.append(m18169e(obj));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m18163a(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append(m18162a(map.get(str)));
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        return sb.toString();
    }

    /* renamed from: e */
    private String m18169e(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
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
                sb.append(m18162a(cls.getField(name).get(obj).toString()));
                sb.append("\"");
            }
        }
        sb.append(">");
        Object obj2 = cls.getField("value").get(obj);
        if (obj2 != null) {
            sb.append(m18162a(obj2.toString()));
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: f */
    private String m18170f(Object obj) throws SecurityException {
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
            sb.append(m18162a(cls.getField(name).get(obj).toString()));
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
    private static String m18162a(String str) {
        return str == null ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }
}
