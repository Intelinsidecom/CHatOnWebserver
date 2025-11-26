package com.sec.chaton.util;

import com.sec.chaton.p000io.entry.EntryField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChatONJsonParser {

    /* renamed from: a */
    private String f3622a;

    public ChatONJsonParser(String str) {
        this.f3622a = str;
    }

    /* renamed from: a */
    private Object m3489a(Class cls, Object obj) {
        return cls.getName().equals(Integer.class.getName()) ? Integer.valueOf(Integer.parseInt(obj.toString())) : cls.getName().equals(Long.class.getName()) ? Long.valueOf(Long.parseLong(obj.toString())) : cls.getName().equals(Double.class.getName()) ? Double.valueOf(Double.parseDouble(obj.toString())) : cls.getName().equals(Float.class.getName()) ? Float.valueOf(Float.parseFloat(obj.toString())) : cls.getName().equals(Boolean.class.getName()) ? Boolean.valueOf(Boolean.parseBoolean(obj.toString())) : obj;
    }

    /* renamed from: a */
    private void m3490a(Class cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fields.length) {
                return;
            }
            Field field = fields[i2];
            if (field.getType().toString().equals(ArrayList.class.toString())) {
                m3491a(((EntryField) field.getAnnotation(EntryField.class)).type(), obj, jSONObject, field.getName());
            } else if (jSONObject.has(field.getName())) {
                m3492a(obj, field.getName(), jSONObject.get(field.getName()));
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private void m3491a(Class cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM3489a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    Object objNewInstance = cls.newInstance();
                    m3490a(cls, objNewInstance, jSONObject2);
                    objM3489a = objNewInstance;
                } catch (JSONException e) {
                    objM3489a = m3489a(cls, jSONArray.get(i));
                }
                arrayList.add(objM3489a);
            }
            m3492a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private void m3492a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m3489a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }

    /* renamed from: a */
    public Object m3493a(Class cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f3622a);
        Object objNewInstance = cls.newInstance();
        m3490a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }
}
