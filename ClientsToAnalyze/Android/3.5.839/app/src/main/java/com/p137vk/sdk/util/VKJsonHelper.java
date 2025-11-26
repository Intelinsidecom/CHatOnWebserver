package com.p137vk.sdk.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKJsonHelper {
    public static Object toJSON(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                jSONObject.put(obj2.toString(), toJSON(map.get(obj2)));
            }
            return jSONObject;
        }
        if (obj instanceof Iterable) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray;
        }
        return obj;
    }

    public static boolean isEmptyObject(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public static Map<String, Object> getMap(JSONObject jSONObject, String str) {
        return toMap(jSONObject.getJSONObject(str));
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, fromJson(jSONObject.get(next)));
        }
        return map;
    }

    public static List toList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(fromJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Object fromJson(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return toList((JSONArray) obj);
        }
        return obj;
    }
}
