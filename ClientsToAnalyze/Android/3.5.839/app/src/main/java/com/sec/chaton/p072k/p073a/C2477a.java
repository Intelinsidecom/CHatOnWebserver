package com.sec.chaton.p072k.p073a;

import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.EntryField;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONJsonParser2.java */
/* renamed from: com.sec.chaton.k.a.a */
/* loaded from: classes.dex */
public class C2477a extends AbstractC4976a {

    /* renamed from: a */
    private String f8883a;

    /* renamed from: b */
    private Class<?> f8884b;

    public C2477a() {
        this("");
    }

    public C2477a(String str) {
        this.f8883a = str;
    }

    /* renamed from: a */
    public Object m10709a(Class<?> cls) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject(this.f8883a);
        Object objNewInstance = cls.newInstance();
        m10705a(cls, objNewInstance, jSONObject);
        return objNewInstance;
    }

    /* renamed from: a */
    private void m10705a(Class<?> cls, Object obj, JSONObject jSONObject) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Class clsType;
        for (Field field : cls.getFields()) {
            if (field.getType().toString().equals(ArrayList.class.toString())) {
                EntryField entryField = (EntryField) field.getAnnotation(EntryField.class);
                if (entryField == null) {
                    clsType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                } else {
                    clsType = entryField.type();
                }
                m10706a(clsType, obj, jSONObject, field.getName());
            } else if (jSONObject.has(field.getName())) {
                m10707a(obj, field.getName(), jSONObject.get(field.getName()));
            }
        }
    }

    /* renamed from: a */
    private void m10706a(Class<?> cls, Object obj, JSONObject jSONObject, String str) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
        Object objM10703a;
        if (jSONObject.has(str)) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString(str));
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                    objM10703a = cls.newInstance();
                    m10705a(cls, objM10703a, jSONObject2);
                } catch (JSONException e) {
                    objM10703a = m10703a(cls, jSONArray.get(i));
                }
                arrayList.add(objM10703a);
            }
            m10707a(obj, str, arrayList);
        }
    }

    /* renamed from: a */
    private Object m10703a(Class<?> cls, Object obj) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException {
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
        if (!cls.getName().equals(Integer.TYPE.getName()) && !cls.getName().equals(Long.TYPE.getName())) {
            if (obj instanceof JSONObject) {
                Object objNewInstance = cls.newInstance();
                m10705a(cls, objNewInstance, (JSONObject) obj);
                return cls.cast(objNewInstance);
            }
            return cls.cast(obj);
        }
        return obj;
    }

    /* renamed from: a */
    private void m10707a(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = obj.getClass().getField(str);
            field.set(obj, m10703a(field.getType(), obj2));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("runtime fail [fieldName]" + str + " [value]" + obj2);
        }
    }

    /* renamed from: a */
    public String m10710a(Object obj) {
        return m10708b(obj).toString();
    }

    /* renamed from: b */
    private JSONObject m10708b(Object obj) throws JSONException, SecurityException {
        Field[] fields = obj.getClass().getFields();
        JSONObject jSONObject = new JSONObject();
        for (Field field : fields) {
            if (field != null) {
                try {
                    if (field.get(obj) != null && !Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        if (field.getType().toString().equals(ArrayList.class.toString())) {
                            jSONObject.put(field.getName(), m10704a(field.get(obj), field));
                        } else if (((EntryField) field.getAnnotation(EntryField.class)) == null) {
                            jSONObject.put(field.getName(), field.get(obj));
                        } else {
                            jSONObject.put(field.getName(), m10708b(field.get(obj)));
                        }
                    }
                } catch (IllegalAccessException e) {
                    C4904y.m18634a("makeJSONfromObject() IllegalAccessException", getClass().getSimpleName());
                } catch (IllegalArgumentException e2) {
                    C4904y.m18634a("makeJSONfromObject() IllegalArgumentException", getClass().getSimpleName());
                } catch (JSONException e3) {
                    C4904y.m18634a("makeJSONfromObject() JSONException", getClass().getSimpleName());
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private JSONArray m10704a(Object obj, Field field) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        EntryField entryField = (EntryField) field.getAnnotation(EntryField.class);
        if (entryField == null) {
        } else {
            entryField.type();
        }
        ArrayList arrayList = (ArrayList) obj;
        for (int i = 0; i < arrayList.size(); i++) {
            if (entryField == null) {
                try {
                    jSONArray.put(i, m10708b(arrayList.get(i)));
                } catch (IllegalArgumentException e) {
                    C4904y.m18634a("makeJSONarray() IllegalArgumentException", getClass().getSimpleName());
                } catch (JSONException e2) {
                    C4904y.m18634a("makeJSONarray() JSONException", getClass().getSimpleName());
                }
            } else {
                jSONArray.put(i, arrayList.get(i));
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    public void m10711b(Class<?> cls) {
        this.f8884b = cls;
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
                        this.f8883a = sb.toString();
                        try {
                            return m10709a(this.f8884b);
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
}
