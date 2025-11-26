package com.sec.chaton.p042k.p043a;

import com.sec.chaton.p035io.entry.EntryField;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONJsonParser2.java */
/* renamed from: com.sec.chaton.k.a.a */
/* loaded from: classes.dex */
public class C1600a {

    /* renamed from: a */
    private String f5938a;

    public C1600a(String str) {
        this.f5938a = str;
    }

    /* renamed from: a */
    public Object m6782a(Class<?> cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f5938a);
        Object objNewInstance = cls.newInstance();
        m6779a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m6779a(Class<?> cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Class clsType;
        for (Field field : cls.getFields()) {
            if (field.getType().toString().equals(ArrayList.class.toString())) {
                EntryField entryField = (EntryField) field.getAnnotation(EntryField.class);
                if (entryField == null) {
                    clsType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                } else {
                    clsType = entryField.type();
                }
                m6780a(clsType, obj, jSONObject, field.getName());
            } else if (jSONObject.has(field.getName())) {
                m6781a(obj, field.getName(), jSONObject.get(field.getName()));
            }
        }
    }

    /* renamed from: a */
    private void m6780a(Class<?> cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM6778a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM6778a = cls.newInstance();
                    m6779a(cls, objM6778a, jSONObject2);
                } catch (JSONException e) {
                    objM6778a = m6778a(cls, jSONArray.get(i));
                }
                arrayList.add(objM6778a);
            }
            m6781a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m6778a(Class<?> cls, Object obj) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
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
        if (cls.getName().equals(String.class.getName())) {
            return obj.toString();
        }
        if (obj instanceof JSONObject) {
            Object objNewInstance = cls.newInstance();
            m6779a(cls, objNewInstance, (JSONObject) obj);
            return cls.cast(objNewInstance);
        }
        return cls.cast(obj);
    }

    /* renamed from: a */
    private void m6781a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m6778a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }
}
