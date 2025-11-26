package com.p137vk.sdk.api.model;

import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.api.model.VKApiModel;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class VKApiArray<T extends VKApiModel> extends VKApiModel {
    private int count;
    private List<T> items;

    @Override // com.p137vk.sdk.api.model.VKApiModel
    public void parse(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        try {
            if (jSONObject.has("response")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("response");
                if (jSONArrayOptJSONArray == null) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response");
                    this.count = jSONObject2.getInt(VKApiConst.COUNT);
                    jSONArray = jSONObject2.getJSONArray("items");
                } else {
                    this.count = jSONArrayOptJSONArray.length();
                    jSONArray = jSONArrayOptJSONArray;
                }
                this.items = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.items.add(parseNextObject(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p137vk.sdk.api.model.VKApiModel
    public JSONObject serialize() {
        return null;
    }

    protected T parseNextObject(JSONObject jSONObject) {
        try {
            T t = (T) Class.forName(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].toString().split("\\s")[1]).newInstance();
            t.parse(jSONObject);
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    public T get(int i) {
        if (this.items == null) {
            return null;
        }
        return this.items.get(i);
    }

    public int size() {
        return this.count;
    }
}
