package com.sec.chaton.util;

import com.sec.chaton.p035io.entry.EntryField;
import com.sec.common.p066d.p067a.AbstractC3314a;
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
public class C3247v extends AbstractC3314a {

    /* renamed from: a */
    private String f11728a;

    /* renamed from: b */
    private Class<?> f11729b;

    public C3247v() {
        this("");
    }

    public C3247v(String str) {
        this.f11728a = str;
    }

    /* renamed from: a */
    public void m11431a(Class<?> cls) {
        this.f11729b = cls;
    }

    @Override // com.sec.common.p066d.p067a.AbstractC3314a
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
                        this.f11728a = sb.toString();
                        try {
                            return m11432b(this.f11729b);
                        } catch (Exception e2) {
                            throw new IOException(e2);
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
    public Object m11432b(Class<?> cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f11728a);
        Object objNewInstance = cls.newInstance();
        m11428a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m11428a(Class<?> cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fields.length) {
                Field field = fields[i2];
                if (field.getType().toString().equals(ArrayList.class.toString())) {
                    m11429a(((EntryField) field.getAnnotation(EntryField.class)).type(), obj, jSONObject, field.getName());
                } else if (jSONObject.has(field.getName())) {
                    m11430a(obj, field.getName(), jSONObject.get(field.getName()));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m11429a(Class<?> cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM11427a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM11427a = cls.newInstance();
                    m11428a(cls, objM11427a, jSONObject2);
                } catch (JSONException e) {
                    objM11427a = m11427a(cls, jSONArray.get(i));
                }
                arrayList.add(objM11427a);
            }
            m11430a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m11427a(Class<?> cls, Object obj) {
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
    private void m11430a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m11427a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }
}
