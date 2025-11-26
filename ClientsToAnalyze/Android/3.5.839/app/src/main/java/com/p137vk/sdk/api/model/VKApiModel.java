package com.p137vk.sdk.api.model;

import com.p137vk.sdk.VKObject;
import com.p137vk.sdk.util.VKJsonHelper;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class VKApiModel extends VKObject {
    public Map<String, Object> fields;

    public void parse(JSONObject jSONObject) throws IllegalAccessException, JSONException, IllegalArgumentException {
        if (jSONObject.has("response")) {
            jSONObject = jSONObject.optJSONObject("response");
        }
        if (jSONObject != null) {
            for (Field field : getClass().getDeclaredFields()) {
                if (jSONObject.has(field.getName())) {
                    try {
                        String name = field.getName();
                        Class<?> type = field.getType();
                        if (type.isPrimitive() || type.equals(String.class)) {
                            Object obj = jSONObject.get(name);
                            if (obj.getClass().equals(type)) {
                                field.set(this, jSONObject.get(name));
                            } else {
                                String strValueOf = String.valueOf(obj);
                                if (type.equals(Integer.TYPE)) {
                                    field.setInt(this, Integer.parseInt(strValueOf));
                                } else if (type.equals(Long.TYPE)) {
                                    field.setLong(this, Long.parseLong(strValueOf));
                                } else if (type.equals(Float.TYPE)) {
                                    field.setFloat(this, Float.parseFloat(strValueOf));
                                } else if (type.equals(Double.TYPE)) {
                                    field.setDouble(this, Double.parseDouble(strValueOf));
                                }
                            }
                        } else if (type.isAssignableFrom(Map.class)) {
                            field.set(this, VKJsonHelper.getMap(jSONObject, name));
                        } else if (type.isAssignableFrom(List.class)) {
                            field.set(this, VKJsonHelper.toList(jSONObject.getJSONArray(name)));
                        } else if (type.isAssignableFrom(VKApiModel.class)) {
                            VKApiModel vKApiModel = (VKApiModel) field.getType().newInstance();
                            vKApiModel.parse(jSONObject.getJSONObject(name));
                            field.set(this, vKApiModel);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                this.fields = VKJsonHelper.toMap(jSONObject);
            } catch (JSONException e2) {
            }
        }
    }

    public JSONObject serialize() throws JSONException {
        Field[] declaredFields = getClass().getDeclaredFields();
        JSONObject jSONObject = new JSONObject();
        for (Field field : declaredFields) {
            if (field.getType().isPrimitive()) {
                try {
                    jSONObject.put(field.getName(), field.get(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (field.getType().isAssignableFrom(VKApiModel.class)) {
                try {
                    jSONObject.put(field.getName(), ((VKApiModel) field.get(this)).serialize());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }
}
