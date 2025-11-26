package com.renren.android.p041b;

import com.renren.android.p040a.AbstractC0709b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FriendsGetFriendsResponseBean.java */
/* renamed from: com.renren.android.b.b */
/* loaded from: classes.dex */
public class C0712b extends AbstractC0709b {

    /* renamed from: a */
    private ArrayList<C0713c> f1642a;

    public C0712b(String str) {
        super(str);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null) {
                    this.f1642a = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            this.f1642a.add(new C0713c(this, jSONObjectOptJSONObject));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public ArrayList<C0713c> m2267a() {
        return this.f1642a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f1642a != null) {
            Iterator<C0713c> it = this.f1642a.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append("\r\n");
            }
        }
        return stringBuffer.toString();
    }
}
