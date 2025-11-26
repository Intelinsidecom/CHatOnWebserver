package com.sec.chaton.p035io.p036a;

import android.text.TextUtils;
import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import com.sec.chaton.util.C3250y;
import com.sec.common.p066d.p067a.AbstractC3314a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: ChatONXmlParser2.java */
/* renamed from: com.sec.chaton.io.a.b */
/* loaded from: classes.dex */
public class C1537b extends AbstractC3314a {

    /* renamed from: a */
    private static final String f5626a = C1537b.class.getSimpleName();

    /* renamed from: b */
    private static XmlPullParserFactory f5627b;

    /* renamed from: c */
    private XmlPullParser f5628c;

    /* renamed from: d */
    private Class<?> f5629d;

    public C1537b() {
        synchronized (C1537b.class) {
            if (f5627b == null) {
                f5627b = XmlPullParserFactory.newInstance();
                f5627b.setNamespaceAware(true);
            }
        }
        this.f5628c = f5627b.newPullParser();
    }

    /* renamed from: a */
    public void m6534a(Class<?> cls) {
        this.f5629d = cls;
    }

    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            return m6532a(inputStream, this.f5629d);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    /* renamed from: a */
    public final Entry m6532a(InputStream inputStream, Class<?> cls) throws XmlPullParserException, IOException {
        this.f5628c.setInput(inputStream, null);
        boolean z = false;
        if (this.f5628c.getEventType() != 1 && this.f5628c.next() == 2) {
            String name = this.f5628c.getName();
            if (name.equals("return") || name.equals("result")) {
                z = true;
            }
        }
        if (z) {
            return m6533a((Class<? extends Entry>) cls, true);
        }
        throw new IOException("Can't find <return> or <result> element.");
    }

    /* renamed from: a */
    protected Entry m6533a(Class<? extends Entry> cls, boolean z) throws XmlPullParserException, IllegalAccessException, InterruptedException, InstantiationException, SecurityException, IOException, IllegalArgumentException {
        Entry entryNewInstance = cls.newInstance();
        if (z) {
            for (int i = 0; i < this.f5628c.getAttributeCount(); i++) {
                String attributeName = this.f5628c.getAttributeName(i);
                String attributeValue = this.f5628c.getAttributeValue(i);
                try {
                    Field fieldM6529a = m6529a(cls, attributeName);
                    fieldM6529a.set(entryNewInstance, m6531b(fieldM6529a.getType(), attributeValue));
                } catch (NoSuchFieldException e) {
                    if (C3250y.f11736d) {
                        C3250y.m11455d("Can't find variable for attribute: " + attributeName, f5626a);
                    }
                }
            }
            this.f5628c.next();
        }
        int eventType = this.f5628c.getEventType();
        while (eventType != 3) {
            if (Thread.interrupted()) {
                throw new InterruptedException("ChatONXmlParser is interrupted.");
            }
            if (eventType == 2) {
                String name = this.f5628c.getName();
                try {
                    Field fieldM6529a2 = m6529a(cls, name);
                    if (List.class.isAssignableFrom(fieldM6529a2.getType())) {
                        ((List) fieldM6529a2.get(entryNewInstance)).add(m6533a((Class<? extends Entry>) ((ParameterizedType) fieldM6529a2.getGenericType()).getActualTypeArguments()[0], true));
                    } else if (Entry.class.isAssignableFrom(fieldM6529a2.getType())) {
                        fieldM6529a2.set(entryNewInstance, m6533a((Class<? extends Entry>) fieldM6529a2.getType(), true));
                    } else {
                        fieldM6529a2.set(entryNewInstance, m6530b(fieldM6529a2.getType()));
                    }
                } catch (NoSuchFieldException e2) {
                    if (C3250y.f11736d) {
                        C3250y.m11455d("Can't find variable for tag: " + name, f5626a);
                    }
                    int next = eventType;
                    while (next != 3) {
                        next = this.f5628c.next();
                    }
                }
            } else if (eventType == 4) {
                entryNewInstance.value = this.f5628c.getText();
            }
            eventType = this.f5628c.next();
        }
        return entryNewInstance;
    }

    /* renamed from: a */
    private Field m6529a(Class<? extends Entry> cls, String str) throws NoSuchFieldException, SecurityException {
        try {
            if ("value".equals(str)) {
                throw new NoSuchFieldException("'value' should be found by EntryParserInfo.");
            }
            return cls.getField(str);
        } catch (NoSuchFieldException e) {
            Field[] fields = cls.getFields();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < fields.length) {
                    Field field = fields[i2];
                    EntryParserInfo entryParserInfo = (EntryParserInfo) field.getAnnotation(EntryParserInfo.class);
                    if (entryParserInfo != null) {
                        String strName = entryParserInfo.name();
                        if (!TextUtils.isEmpty(strName) && strName.equals(str)) {
                            return field;
                        }
                    }
                    i = i2 + 1;
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: b */
    private Object m6530b(Class<?> cls) throws XmlPullParserException, IOException {
        String str = new String();
        String text = str;
        int eventType = this.f5628c.getEventType();
        while (eventType != 3) {
            if (eventType == 4) {
                text = this.f5628c.getText();
            }
            eventType = this.f5628c.next();
        }
        return m6531b(cls, text);
    }

    /* renamed from: b */
    private Object m6531b(Class<?> cls, String str) {
        if (cls.getName().equals(Integer.class.getName())) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                if (TextUtils.isEmpty(str)) {
                    throw e;
                }
                if (Boolean.TRUE.toString().equalsIgnoreCase(str)) {
                    return 1;
                }
                if (Boolean.FALSE.toString().equalsIgnoreCase(str)) {
                    return 0;
                }
                throw e;
            }
        }
        if (cls.getName().equals(Long.class.getName())) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (cls.getName().equals(Double.class.getName())) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (cls.getName().equals(Float.class.getName())) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (cls.getName().equals(Boolean.class.getName())) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        return str;
    }
}
