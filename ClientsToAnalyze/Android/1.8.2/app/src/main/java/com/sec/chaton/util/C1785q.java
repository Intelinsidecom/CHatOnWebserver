package com.sec.chaton.util;

import com.sec.chaton.p028io.entry.EntryField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONJsonParser.java */
/* renamed from: com.sec.chaton.util.q */
/* loaded from: classes.dex */
public class C1785q {

    /* renamed from: a */
    private String f6450a;

    public C1785q(String str) {
        this.f6450a = str;
    }

    /* renamed from: a */
    public Object m6046a(Class cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f6450a);
        Object objNewInstance = cls.newInstance();
        m6043a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m6043a(Class cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fields.length) {
                Field field = fields[i2];
                if (field.getType().toString().equals(ArrayList.class.toString())) {
                    m6044a(((EntryField) field.getAnnotation(EntryField.class)).type(), obj, jSONObject, field.getName());
                } else if (jSONObject.has(field.getName())) {
                    m6045a(obj, field.getName(), jSONObject.get(field.getName()));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m6044a(Class cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM6042a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM6042a = cls.newInstance();
                    m6043a(cls, objM6042a, jSONObject2);
                } catch (JSONException e) {
                    objM6042a = m6042a(cls, jSONArray.get(i));
                }
                arrayList.add(objM6042a);
            }
            m6045a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m6042a(Class cls, Object obj) {
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
    private void m6045a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m6042a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }
}
