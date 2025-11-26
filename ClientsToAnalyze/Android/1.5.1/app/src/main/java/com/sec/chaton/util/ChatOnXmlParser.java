package com.sec.chaton.util;

import com.sec.chaton.p000io.entry.Entry;
import com.sec.chaton.p000io.entry.EntryField;
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

/* loaded from: classes.dex */
public class ChatOnXmlParser {

    /* renamed from: b */
    private static XmlPullParserFactory f3637b;

    /* renamed from: a */
    private Entry f3638a;

    /* renamed from: a */
    private Object m3542a(Class cls, Object obj) {
        String string = obj.toString();
        return cls.getName().equals(Integer.class.getName()) ? Integer.valueOf(Integer.parseInt(string)) : cls.getName().equals(Long.class.getName()) ? Long.valueOf(Long.parseLong(string)) : cls.getName().equals(Double.class.getName()) ? Double.valueOf(Double.parseDouble(string)) : cls.getName().equals(Float.class.getName()) ? Float.valueOf(Float.parseFloat(string)) : cls.getName().equals(Boolean.class.getName()) ? Boolean.valueOf(Boolean.parseBoolean(string)) : string;
    }

    /* renamed from: a */
    private static String m3543a(String str) {
        return str == null ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }

    /* renamed from: a */
    private String m3544a(HashMap map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append(m3543a((String) map.get(str)));
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static XmlPullParser m3545a(InputStream inputStream) throws XmlPullParserException {
        if (f3637b == null) {
            f3637b = XmlPullParserFactory.newInstance();
            f3637b.setNamespaceAware(true);
        }
        XmlPullParser xmlPullParserNewPullParser = f3637b.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    private void m3546a(Object obj, String str) {
        try {
            ((ArrayList) obj.getClass().getField(str).get(obj)).add(this.f3638a);
            this.f3638a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3547a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            if (field.getType() != ArrayList.class) {
                field.set(obj, m3542a(field.getType(), obj2));
                return;
            }
            if (this.f3638a == null) {
                this.f3638a = (Entry) ((EntryField) field.getAnnotation(EntryField.class)).type().newInstance();
            }
            if (this.f3638a != null) {
                this.f3638a.value = (String) obj2;
            }
        } catch (Exception e) {
            ChatONLogWriter.m3499a("runtime fail [fieldName]" + str + " [value]" + obj2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m3548a(Object obj, String str, XmlPullParser xmlPullParser) {
        try {
            this.f3638a = (Entry) ((EntryField) obj.getClass().getField(str).getAnnotation(EntryField.class)).type().newInstance();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                m3547a(this.f3638a, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m3549a(XmlPullParser xmlPullParser, Class cls, Object obj) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        String name = "";
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            String str = name;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                if (this.f3638a != null) {
                    m3546a(obj, str);
                }
                name = xmlPullParser.getName();
                if (xmlPullParser.getAttributeCount() > 0) {
                    m3548a(obj, name, xmlPullParser);
                }
            } else {
                if (i == 3) {
                    if (str == xmlPullParser.getName()) {
                        if (this.f3638a != null) {
                            m3546a(obj, str);
                        }
                        name = "";
                        this.f3638a = null;
                    }
                } else if (i == 4 && str != null && !str.equals("")) {
                    m3547a(obj, str, xmlPullParser.getText());
                }
                name = str;
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    private String m3550b(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        Class<?> cls = obj.getClass();
        sb.append("<");
        sb.append(cls.getSimpleName().toLowerCase());
        for (Field field : cls.getFields()) {
            String name = field.getName();
            if (cls.getField(name).get(obj) != null && !name.equals("value")) {
                sb.append(" ");
                sb.append(name);
                sb.append("=\"");
                sb.append(m3543a(cls.getField(name).get(obj).toString()));
                sb.append("\"");
            }
        }
        sb.append(">");
        Object obj2 = cls.getField("value").get(obj);
        if (obj2 != null) {
            sb.append(m3543a(obj2.toString()));
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: a */
    public Object m3551a(InputStream inputStream, Class cls) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, IllegalArgumentException {
        XmlPullParser xmlPullParserM3545a = m3545a(inputStream);
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.newInstance();
        m3549a(xmlPullParserM3545a, cls, objNewInstance);
        return objNewInstance;
    }

    /* renamed from: a */
    public String m3552a(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m3550b(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m3544a((HashMap) obj));
        } else {
            sb.append(m3550b(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }
}
