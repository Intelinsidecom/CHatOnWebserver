package com.renren.android.p012c;

import com.renren.android.C0212f;
import com.renren.android.p010a.AbstractC0197b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import weibo4android.org.json.HTTP;

/* compiled from: UsersGetInfoResponseBean.java */
/* renamed from: com.renren.android.c.g */
/* loaded from: classes.dex */
public class C0209g extends AbstractC0197b {

    /* renamed from: a */
    private ArrayList<C0203a> f444a;

    public C0209g(String str) {
        super(str);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null) {
                    this.f444a = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        C0203a c0203a = new C0203a();
                        c0203a.m543a(jSONArray.optJSONObject(i));
                        if (c0203a != null) {
                            this.f444a.add(c0203a);
                        }
                    }
                }
            } catch (C0212f e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public ArrayList<C0203a> m556a() {
        return this.f444a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f444a != null) {
            Iterator<C0203a> it = this.f444a.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append(HTTP.CRLF);
            }
        }
        return stringBuffer.toString();
    }
}
