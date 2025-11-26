package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.p032b.C0470m;
import com.facebook.p032b.C0476s;
import com.facebook.p032b.C0477t;
import com.p137vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SharedPreferencesTokenCachingStrategy.java */
/* renamed from: com.facebook.bw */
/* loaded from: classes.dex */
public class C0500bw extends AbstractC0501bx {

    /* renamed from: a */
    private static final String f1247a = C0500bw.class.getSimpleName();

    /* renamed from: b */
    private String f1248b;

    /* renamed from: c */
    private SharedPreferences f1249c;

    public C0500bw(Context context) {
        this(context, null);
    }

    public C0500bw(Context context, String str) {
        C0477t.m1721a(context, "context");
        this.f1248b = C0476s.m1717a(str) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        Context applicationContext = context.getApplicationContext();
        this.f1249c = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.f1248b, 0);
    }

    @Override // com.facebook.AbstractC0501bx
    /* renamed from: a */
    public Bundle mo1815a() {
        Bundle bundle = new Bundle();
        for (String str : this.f1249c.getAll().keySet()) {
            try {
                m1813a(str, bundle);
            } catch (JSONException e) {
                C0470m.m1687a(EnumC0441ak.CACHE, 5, f1247a, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    @Override // com.facebook.AbstractC0501bx
    /* renamed from: a */
    public void mo1816a(Bundle bundle) {
        C0477t.m1721a(bundle, "bundle");
        SharedPreferences.Editor editorEdit = this.f1249c.edit();
        for (String str : bundle.keySet()) {
            try {
                m1814a(str, bundle, editorEdit);
            } catch (JSONException e) {
                C0470m.m1687a(EnumC0441ak.CACHE, 5, f1247a, "Error processing value for key: '" + str + "' -- " + e);
                return;
            }
        }
        if (!editorEdit.commit()) {
            C0470m.m1687a(EnumC0441ak.CACHE, 5, f1247a, "SharedPreferences.Editor.commit() was not successful");
        }
    }

    @Override // com.facebook.AbstractC0501bx
    /* renamed from: b */
    public void mo1817b() {
        this.f1249c.edit().clear().commit();
    }

    /* renamed from: a */
    private void m1814a(String str, Bundle bundle, SharedPreferences.Editor editor) throws JSONException {
        JSONArray jSONArray;
        String str2 = null;
        int i = 0;
        Object obj = bundle.get(str);
        if (obj != null) {
            JSONObject jSONObject = new JSONObject();
            if (obj instanceof Byte) {
                jSONObject.put("value", ((Byte) obj).intValue());
                jSONArray = null;
                str2 = "byte";
            } else if (obj instanceof Short) {
                jSONObject.put("value", ((Short) obj).intValue());
                jSONArray = null;
                str2 = "short";
            } else if (obj instanceof Integer) {
                jSONObject.put("value", ((Integer) obj).intValue());
                jSONArray = null;
                str2 = "int";
            } else if (obj instanceof Long) {
                jSONObject.put("value", ((Long) obj).longValue());
                jSONArray = null;
                str2 = VKApiConst.LONG;
            } else if (obj instanceof Float) {
                jSONObject.put("value", ((Float) obj).doubleValue());
                jSONArray = null;
                str2 = "float";
            } else if (obj instanceof Double) {
                jSONObject.put("value", ((Double) obj).doubleValue());
                jSONArray = null;
                str2 = "double";
            } else if (obj instanceof Boolean) {
                jSONObject.put("value", ((Boolean) obj).booleanValue());
                jSONArray = null;
                str2 = "bool";
            } else if (obj instanceof Character) {
                jSONObject.put("value", obj.toString());
                jSONArray = null;
                str2 = "char";
            } else if (obj instanceof String) {
                jSONObject.put("value", (String) obj);
                jSONArray = null;
                str2 = "string";
            } else if (obj instanceof Enum) {
                jSONObject.put("value", obj.toString());
                jSONObject.put("enumType", obj.getClass().getName());
                jSONArray = null;
                str2 = "enum";
            } else {
                JSONArray jSONArray2 = new JSONArray();
                if (obj instanceof byte[]) {
                    str2 = "byte[]";
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    while (i < length) {
                        jSONArray2.put((int) bArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof short[]) {
                    str2 = "short[]";
                    short[] sArr = (short[]) obj;
                    int length2 = sArr.length;
                    while (i < length2) {
                        jSONArray2.put((int) sArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof int[]) {
                    str2 = "int[]";
                    int[] iArr = (int[]) obj;
                    int length3 = iArr.length;
                    while (i < length3) {
                        jSONArray2.put(iArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof long[]) {
                    str2 = "long[]";
                    long[] jArr = (long[]) obj;
                    int length4 = jArr.length;
                    while (i < length4) {
                        jSONArray2.put(jArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof float[]) {
                    str2 = "float[]";
                    int length5 = ((float[]) obj).length;
                    while (i < length5) {
                        jSONArray2.put(r0[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof double[]) {
                    str2 = "double[]";
                    double[] dArr = (double[]) obj;
                    int length6 = dArr.length;
                    while (i < length6) {
                        jSONArray2.put(dArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof boolean[]) {
                    str2 = "bool[]";
                    boolean[] zArr = (boolean[]) obj;
                    int length7 = zArr.length;
                    while (i < length7) {
                        jSONArray2.put(zArr[i]);
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof char[]) {
                    str2 = "char[]";
                    char[] cArr = (char[]) obj;
                    int length8 = cArr.length;
                    while (i < length8) {
                        jSONArray2.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    jSONArray = jSONArray2;
                } else if (obj instanceof List) {
                    str2 = "stringList";
                    for (Object obj2 : (List) obj) {
                        if (obj2 == null) {
                            obj2 = JSONObject.NULL;
                        }
                        jSONArray2.put(obj2);
                    }
                    jSONArray = jSONArray2;
                } else {
                    jSONArray = null;
                }
            }
            if (str2 != null) {
                jSONObject.put("valueType", str2);
                if (jSONArray != null) {
                    jSONObject.putOpt("value", jSONArray);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    /* renamed from: a */
    private void m1813a(String str, Bundle bundle) throws JSONException {
        int i = 0;
        JSONObject jSONObject = new JSONObject(this.f1249c.getString(str, "{}"));
        String string = jSONObject.getString("valueType");
        if (string.equals("bool")) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            return;
        }
        if (string.equals("bool[]")) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < zArr.length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        if (string.equals("byte")) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
            return;
        }
        if (string.equals("byte[]")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[jSONArray2.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) jSONArray2.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
            return;
        }
        if (string.equals("short")) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
            return;
        }
        if (string.equals("short[]")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
            short[] sArr = new short[jSONArray3.length()];
            while (i < sArr.length) {
                sArr[i] = (short) jSONArray3.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
            return;
        }
        if (string.equals("int")) {
            bundle.putInt(str, jSONObject.getInt("value"));
            return;
        }
        if (string.equals("int[]")) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
            int[] iArr = new int[jSONArray4.length()];
            while (i < iArr.length) {
                iArr[i] = jSONArray4.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
            return;
        }
        if (string.equals(VKApiConst.LONG)) {
            bundle.putLong(str, jSONObject.getLong("value"));
            return;
        }
        if (string.equals("long[]")) {
            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
            long[] jArr = new long[jSONArray5.length()];
            while (i < jArr.length) {
                jArr[i] = jSONArray5.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        if (string.equals("float")) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
            return;
        }
        if (string.equals("float[]")) {
            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
            float[] fArr = new float[jSONArray6.length()];
            while (i < fArr.length) {
                fArr[i] = (float) jSONArray6.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
            return;
        }
        if (string.equals("double")) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
            return;
        }
        if (string.equals("double[]")) {
            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
            double[] dArr = new double[jSONArray7.length()];
            while (i < dArr.length) {
                dArr[i] = jSONArray7.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
            return;
        }
        if (string.equals("char")) {
            String string2 = jSONObject.getString("value");
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
                return;
            }
            return;
        }
        if (string.equals("char[]")) {
            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
            char[] cArr = new char[jSONArray8.length()];
            for (int i2 = 0; i2 < cArr.length; i2++) {
                String string3 = jSONArray8.getString(i2);
                if (string3 != null && string3.length() == 1) {
                    cArr[i2] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
            return;
        }
        if (string.equals("string")) {
            bundle.putString(str, jSONObject.getString("value"));
            return;
        }
        if (string.equals("stringList")) {
            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
            int length = jSONArray9.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray9.get(i3);
                arrayList.add(i3, obj == JSONObject.NULL ? null : (String) obj);
            }
            bundle.putStringArrayList(str, arrayList);
            return;
        }
        if (string.equals("enum")) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
