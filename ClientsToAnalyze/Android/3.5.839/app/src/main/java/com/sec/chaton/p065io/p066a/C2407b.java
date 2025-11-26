package com.sec.chaton.p065io.p066a;

import android.text.TextUtils;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.p065io.entry.EntryParserInfo;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.AbstractC4976a;
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
public class C2407b extends AbstractC4976a {

    /* renamed from: a */
    private static final String f8547a = C2407b.class.getSimpleName();

    /* renamed from: b */
    private static XmlPullParserFactory f8548b;

    /* renamed from: c */
    private XmlPullParser f8549c;

    /* renamed from: d */
    private Class<?> f8550d;

    public C2407b() {
        synchronized (C2407b.class) {
            if (f8548b == null) {
                f8548b = XmlPullParserFactory.newInstance();
                f8548b.setNamespaceAware(true);
            }
        }
        this.f8549c = f8548b.newPullParser();
    }

    /* renamed from: a */
    public void m10438a(Class<?> cls) {
        this.f8550d = cls;
    }

    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            return m10436a(inputStream, this.f8550d);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw C1057b.m6157a(e2);
        }
    }

    /* renamed from: a */
    public final Entry m10436a(InputStream inputStream, Class<?> cls) throws XmlPullParserException, IOException {
        this.f8549c.setInput(inputStream, null);
        boolean z = false;
        if (this.f8549c.getEventType() != 1 && this.f8549c.next() == 2) {
            String name = this.f8549c.getName();
            if (name.equals("return") || name.equals("result")) {
                z = true;
            }
        }
        if (z) {
            return m10437a((Class<? extends Entry>) cls, true);
        }
        throw new IOException("Can't find <return> or <result> element.");
    }

    /* renamed from: a */
    protected Entry m10437a(Class<? extends Entry> cls, boolean z) throws XmlPullParserException, IllegalAccessException, InterruptedException, InstantiationException, SecurityException, IOException, IllegalArgumentException {
        Entry entryNewInstance = cls.newInstance();
        if (z) {
            for (int i = 0; i < this.f8549c.getAttributeCount(); i++) {
                String attributeName = this.f8549c.getAttributeName(i);
                String attributeValue = this.f8549c.getAttributeValue(i);
                try {
                    Field fieldM10433a = m10433a(cls, attributeName);
                    fieldM10433a.set(entryNewInstance, m10435b(fieldM10433a.getType(), attributeValue));
                } catch (NoSuchFieldException e) {
                    if (C4904y.f17874d) {
                        C4904y.m18645d("Can't find variable for attribute: " + attributeName, f8547a);
                    }
                }
            }
            this.f8549c.next();
        }
        int eventType = this.f8549c.getEventType();
        while (eventType != 3) {
            if (Thread.interrupted()) {
                throw new InterruptedException("ChatONXmlParser is interrupted.");
            }
            if (eventType == 2) {
                String name = this.f8549c.getName();
                try {
                    Field fieldM10433a2 = m10433a(cls, name);
                    if (List.class.isAssignableFrom(fieldM10433a2.getType())) {
                        ((List) fieldM10433a2.get(entryNewInstance)).add(m10437a((Class<? extends Entry>) ((ParameterizedType) fieldM10433a2.getGenericType()).getActualTypeArguments()[0], true));
                    } else if (Entry.class.isAssignableFrom(fieldM10433a2.getType())) {
                        fieldM10433a2.set(entryNewInstance, m10437a((Class<? extends Entry>) fieldM10433a2.getType(), true));
                    } else {
                        fieldM10433a2.set(entryNewInstance, m10434b(fieldM10433a2.getType()));
                    }
                } catch (NoSuchFieldException e2) {
                    if (C4904y.f17874d) {
                        C4904y.m18645d("Can't find variable for tag: " + name, f8547a);
                    }
                    int next = eventType;
                    while (next != 3) {
                        next = this.f8549c.next();
                    }
                }
            } else if (eventType == 4) {
                entryNewInstance.value = this.f8549c.getText();
            }
            eventType = this.f8549c.next();
        }
        return entryNewInstance;
    }

    /* renamed from: a */
    private Field m10433a(Class<? extends Entry> cls, String str) throws NoSuchFieldException, SecurityException {
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
    private Object m10434b(Class<?> cls) throws XmlPullParserException, IOException {
        String str = new String();
        String text = str;
        int eventType = this.f8549c.getEventType();
        while (eventType != 3) {
            if (eventType == 4) {
                text = this.f8549c.getText();
            }
            eventType = this.f8549c.next();
        }
        return m10435b(cls, text);
    }

    /* renamed from: b */
    private Object m10435b(Class<?> cls, String str) {
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
