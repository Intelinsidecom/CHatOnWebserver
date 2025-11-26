package com.renren.android.p012c;

import android.os.Bundle;
import com.renren.android.p010a.AbstractC0196a;

/* compiled from: UsersGetInfoRequestParam.java */
/* renamed from: com.renren.android.c.f */
/* loaded from: classes.dex */
public class C0208f extends AbstractC0196a {

    /* renamed from: a */
    private String[] f442a;

    /* renamed from: b */
    private String f443b = "uid,name,tinyurl,headurl,zidou,star";

    public C0208f(String[] strArr) {
        this.f442a = strArr;
    }

    /* renamed from: a */
    public void m555a(String str) {
        this.f443b = str;
    }

    /* renamed from: a */
    public Bundle m554a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "users.getInfo");
        if (this.f443b != null) {
            bundle.putString("fields", this.f443b);
        }
        if (this.f442a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : this.f442a) {
                stringBuffer.append(str).append(",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            bundle.putString("uids", stringBuffer.toString());
        }
        return bundle;
    }
}
