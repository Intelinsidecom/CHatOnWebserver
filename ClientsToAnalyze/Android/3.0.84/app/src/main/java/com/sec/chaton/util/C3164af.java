package com.sec.chaton.util;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryField;
import com.sec.common.p066d.p067a.AbstractC3314a;
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
/* renamed from: com.sec.chaton.util.af */
/* loaded from: classes.dex */
public class C3164af extends AbstractC3314a {

    /* renamed from: c */
    private static XmlPullParserFactory f11477c;

    /* renamed from: a */
    private Entry f11478a;

    /* renamed from: b */
    private Class<?> f11479b;

    /* renamed from: a */
    private static XmlPullParser m11018a(InputStream inputStream) throws XmlPullParserException {
        if (f11477c == null) {
            f11477c = XmlPullParserFactory.newInstance();
            f11477c.setNamespaceAware(true);
        }
        XmlPullParser xmlPullParserNewPullParser = f11477c.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: a */
    public void m11027a(Class<?> cls) {
        this.f11479b = cls;
    }

    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            return m11025a(inputStream, this.f11479b);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    public Object m11025a(InputStream inputStream, Class<?> cls) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException, IllegalArgumentException {
        XmlPullParser xmlPullParserM11018a = m11018a(inputStream);
        if (cls == null) {
            return null;
        }
        Object objNewInstance = cls.newInstance();
        m11022a(xmlPullParserM11018a, cls, objNewInstance);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m11022a(XmlPullParser xmlPullParser, Class<?> cls, Object obj) throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        String name = "";
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f11478a != null) {
                    m11019a(obj, name);
                }
                name = xmlPullParser.getName();
                if (xmlPullParser.getAttributeCount() > 0) {
                    m11021a(obj, name, xmlPullParser);
                }
            } else if (eventType == 3) {
                if (name == xmlPullParser.getName()) {
                    if (this.f11478a != null) {
                        m11019a(obj, name);
                    }
                    name = "";
                    this.f11478a = null;
                }
            } else if (eventType == 4 && name != null && !name.equals("")) {
                m11020a(obj, name, xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private void m11019a(Object obj, String str) {
        if (str != null) {
            try {
                ((ArrayList) obj.getClass().getField(str).get(obj)).add(this.f11478a);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f11478a = null;
    }

    /* renamed from: a */
    private void m11021a(Object obj, String str, XmlPullParser xmlPullParser) {
        try {
            this.f11478a = (Entry) ((EntryField) obj.getClass().getField(str).getAnnotation(EntryField.class)).type().newInstance();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                m11020a(this.f11478a, xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m11020a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            if (field.getType() == ArrayList.class) {
                if (this.f11478a == null) {
                    this.f11478a = (Entry) ((EntryField) field.getAnnotation(EntryField.class)).type().newInstance();
                }
                if (this.f11478a != null) {
                    this.f11478a.value = (String) obj2;
                    return;
                }
                return;
            }
            field.set(obj, m11015a(field.getType(), obj2));
        } catch (Exception e) {
            C3250y.m11455d("runtime fail [fieldName]" + str + " [value]" + obj2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private Object m11015a(Class<?> cls, Object obj) {
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
    public String m11026a(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m11023e(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m11017a((HashMap<String, String>) obj));
        } else {
            sb.append(m11023e(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: b */
    public String m11028b(Object obj) {
        StringBuilder sb = new StringBuilder("<param>\n");
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m11024f(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m11017a((HashMap<String, String>) obj));
        } else {
            sb.append(m11023e(obj));
        }
        sb.append("</param>");
        return sb.toString();
    }

    /* renamed from: c */
    public String m11029c(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m11023e(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m11017a((HashMap<String, String>) obj));
        } else {
            sb.append(m11023e(obj));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public String m11030d(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(m11024f(arrayList.get(i)));
            }
        } else if (obj instanceof Map) {
            sb.append(m11017a((HashMap<String, String>) obj));
        } else {
            sb.append(m11023e(obj));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m11017a(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append("<");
            sb.append(str);
            sb.append(">");
            sb.append(m11016a(map.get(str)));
            sb.append("</");
            sb.append(str);
            sb.append(">\n");
        }
        return sb.toString();
    }

    /* renamed from: e */
    private String m11023e(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
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
                sb.append(m11016a(cls.getField(name).get(obj).toString()));
                sb.append("\"");
            }
        }
        sb.append(">");
        Object obj2 = cls.getField("value").get(obj);
        if (obj2 != null) {
            sb.append(m11016a(obj2.toString()));
        }
        sb.append("</");
        sb.append(cls.getSimpleName().toLowerCase());
        sb.append(">\n");
        return sb.toString();
    }

    /* renamed from: f */
    private String m11024f(Object obj) throws SecurityException {
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
            sb.append(m11016a(cls.getField(name).get(obj).toString()));
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
    private static String m11016a(String str) {
        return str == null ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");
    }
}
