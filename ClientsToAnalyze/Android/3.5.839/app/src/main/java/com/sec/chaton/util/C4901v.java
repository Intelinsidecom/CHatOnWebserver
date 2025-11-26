package com.sec.chaton.util;

import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.EntryField;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONJsonParser.java */
/* renamed from: com.sec.chaton.util.v */
/* loaded from: classes.dex */
public class C4901v extends AbstractC4976a {

    /* renamed from: a */
    private String f17866a;

    /* renamed from: b */
    private Class<?> f17867b;

    public C4901v() {
        this("");
    }

    public C4901v(String str) {
        this.f17866a = str;
    }

    /* renamed from: a */
    public void m18627a(Class<?> cls) {
        this.f17867b = cls;
    }

    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                        }
                        this.f17866a = sb.toString();
                        try {
                            return m18628b(this.f17867b);
                        } catch (Exception e2) {
                            throw C1057b.m6157a(e2);
                        }
                    }
                    if (Thread.interrupted()) {
                        throw new InterruptedException("ChatONJsonParser is interrupted.");
                    }
                    sb.append(line);
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* renamed from: b */
    public Object m18628b(Class<?> cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f17866a);
        Object objNewInstance = cls.newInstance();
        m18624a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m18624a(Class<?> cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fields.length) {
                Field field = fields[i2];
                if (field.getType().toString().equals(ArrayList.class.toString())) {
                    m18625a(((EntryField) field.getAnnotation(EntryField.class)).type(), obj, jSONObject, field.getName());
                } else if (jSONObject.has(field.getName())) {
                    m18626a(obj, field.getName(), jSONObject.get(field.getName()));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m18625a(Class<?> cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM18623a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM18623a = cls.newInstance();
                    m18624a(cls, objM18623a, jSONObject2);
                } catch (JSONException e) {
                    objM18623a = m18623a(cls, jSONArray.get(i));
                }
                arrayList.add(objM18623a);
            }
            m18626a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m18623a(Class<?> cls, Object obj) {
        if (cls.getName().equals(Integer.class.getName())) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        if (cls.getName().equals(Long.class.getName())) {
            return Long.valueOf(Long.parseLong(obj.toString()));
        }
        if (cls.getName().equals(Double.class.getName())) {
            return Double.valueOf(Double.parseDouble(obj.toString()));
        }
        if (cls.getName().equals(Float.class.getName())) {
            return Float.valueOf(Float.parseFloat(obj.toString()));
        }
        if (cls.getName().equals(Boolean.class.getName())) {
            return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
        }
        return obj;
    }

    /* renamed from: a */
    private void m18626a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m18623a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }
}
