package com.sec.chaton.util;

import com.sec.chaton.p033io.entry.Entry;
import com.sec.chaton.p033io.entry.EntryField;
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
/* renamed from: com.sec.chaton.util.x */
/* loaded from: classes.dex */
public class C1349x {

    /* renamed from: b */
    private static XmlPullParserFactory f4601b;

    /* renamed from: a */
    private Entry f4602a;

    /* renamed from: a */
    private static XmlPullParser m4707a(InputStream inputStream) throws XmlPullParserException {
        if (f4601b == null) {
            f4601b = XmlPullParserFactory.newInstance();
            f4601b.setNamespaceAware(true);
        }
        XmlPullParser xmlPullParserNewPullParser = f4601b.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    public Object m4713a(InputStream inputStream, Class cls) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, IllegalArgumentException {
        XmlPullParser xmlPullParserM4707a = m4707a(inputStream);
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.newInstance();
        m4711a(xmlPullParserM4707a, cls, objNewInstance);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m4711a(XmlPullParser xmlPullParser, Class cls, Object obj) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        String name = "";
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f4602a != null) {
                    m4708a(obj, name);
                }
                name = xmlPullParser.getName();
                if (xmlPullParser.getAttributeCount() > 0) {
                    m4710a(obj, name, xmlPullParser);
                }
            } else if (eventType == 3) {
                if (name == xmlPullParser.getName()) {
                    if (this.f4602a != null) {
                        m4708a(obj, name);
                    }
                    name = "";
                    this.f4602a = null;
                }
            } else if (eventType == 4 && name != null && !name.equals("")) {
                m4709a(obj, name, xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private void m4708a(Object obj, String str) {
        try {
            ((ArrayList) obj.getClass().getField(str).get(obj)).add(this.f4602a);
            this.f4602a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4710a(Object obj, String str, XmlPullParser xmlPullParser) {
        try {
            this.f4602a = (Entry) ((EntryField) obj.getClass().getField(str).getAnnotation(EntryField.class)).type().newInstance();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                m4709a(this.f4602a, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m4709a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            if (field.getType() == ArrayList.class) {
                if (this.f4602a == null) {
                    this.f4602a = (Entry) ((EntryField) field.getAnnotation(EntryField.class)).type().newInstance();
                }
                if (this.f4602a != null) {
                    this.f4602a.value = (String) obj2;
                    return;
                }
                return;
            }
            field.set(obj, m4704a(field.getType(), obj2));
        } catch (Exception e) {
            C1341p.m4661d("runtime fail [fieldName]" + str + " [value]" + obj2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private Object m4704a(Class cls, Object obj) {
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
    public String m4714a(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m4712b(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m4706a((HashMap) obj));
        } else {
            sb.append(m4712b(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: a */
    private String m4706a(HashMap map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append(m4705a((String) map.get(str)));
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m4712b(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
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
                sb.append(m4705a(cls.getField(name).get(obj).toString()));
                sb.append("\"");
            }
        }
        sb.append(">");
        Object obj2 = cls.getField("value").get(obj);
        if (obj2 != null) {
            sb.append(m4705a(obj2.toString()));
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m4705a(String str) {
        return str == null ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }
}
