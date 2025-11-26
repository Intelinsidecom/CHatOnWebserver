package com.sec.chaton.util;

import com.sec.chaton.p033io.entry.EntryField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONJsonParser.java */
/* renamed from: com.sec.chaton.util.n */
/* loaded from: classes.dex */
public class C1339n {

    /* renamed from: a */
    private String f4572a;

    public C1339n(String str) {
        this.f4572a = str;
    }

    /* renamed from: a */
    public Object m4643a(Class cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f4572a);
        Object objNewInstance = cls.newInstance();
        m4640a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m4640a(Class cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fields.length) {
                Field field = fields[i2];
                if (field.getType().toString().equals(ArrayList.class.toString())) {
                    m4641a(((EntryField) field.getAnnotation(EntryField.class)).type(), obj, jSONObject, field.getName());
                } else if (jSONObject.has(field.getName())) {
                    m4642a(obj, field.getName(), jSONObject.get(field.getName()));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m4641a(Class cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM4639a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM4639a = cls.newInstance();
                    m4640a(cls, objM4639a, jSONObject2);
                } catch (JSONException e) {
                    objM4639a = m4639a(cls, jSONArray.get(i));
                }
                arrayList.add(objM4639a);
            }
            m4642a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m4639a(Class cls, Object obj) {
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
    private void m4642a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m4639a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }
}
