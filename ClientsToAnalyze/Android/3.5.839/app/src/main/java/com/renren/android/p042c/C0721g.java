package com.renren.android.p042c;

import com.renren.android.C0724f;
import com.renren.android.p040a.AbstractC0709b;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: UsersGetInfoResponseBean.java */
/* renamed from: com.renren.android.c.g */
/* loaded from: classes.dex */
public class C0721g extends AbstractC0709b {

    /* renamed from: a */
    private ArrayList<C0715a> f1680a;

    public C0721g(String str) {
        super(str);
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null) {
                    this.f1680a = new ArrayList<>();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        C0715a c0715a = new C0715a();
                        c0715a.m2275a(jSONArray.optJSONObject(i));
                        if (c0715a != null) {
                            this.f1680a.add(c0715a);
                        }
                    }
                }
            } catch (C0724f e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public ArrayList<C0715a> m2288a() {
        return this.f1680a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f1680a != null) {
            Iterator<C0715a> it = this.f1680a.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append("\r\n");
            }
        }
        return stringBuffer.toString();
    }
}
