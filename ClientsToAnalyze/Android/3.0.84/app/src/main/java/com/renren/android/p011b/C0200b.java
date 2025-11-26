package com.renren.android.p011b;

import com.renren.android.p010a.AbstractC0197b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: FriendsGetFriendsResponseBean.java */
/* renamed from: com.renren.android.b.b */
/* loaded from: classes.dex */
public class C0200b extends AbstractC0197b {

    /* renamed from: a */
    private ArrayList<C0201c> f406a;

    public C0200b(String str) {
        super(str);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null) {
                    this.f406a = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            this.f406a.add(new C0201c(this, jSONObjectOptJSONObject));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public ArrayList<C0201c> m535a() {
        return this.f406a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f406a != null) {
            Iterator<C0201c> it = this.f406a.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append(HTTP.CRLF);
            }
        }
        return stringBuffer.toString();
    }
}
