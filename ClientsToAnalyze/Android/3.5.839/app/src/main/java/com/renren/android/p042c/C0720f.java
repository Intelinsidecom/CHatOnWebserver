package com.renren.android.p042c;

import android.os.Bundle;
import com.p137vk.sdk.api.VKApiConst;
import com.renren.android.p040a.AbstractC0708a;

/* compiled from: UsersGetInfoRequestParam.java */
/* renamed from: com.renren.android.c.f */
/* loaded from: classes.dex */
public class C0720f extends AbstractC0708a {

    /* renamed from: a */
    private String[] f1678a;

    /* renamed from: b */
    private String f1679b = "uid,name,tinyurl,headurl,zidou,star";

    public C0720f(String[] strArr) {
        this.f1678a = strArr;
    }

    /* renamed from: a */
    public void m2287a(String str) {
        this.f1679b = str;
    }

    /* renamed from: a */
    public Bundle m2286a() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "users.getInfo");
        if (this.f1679b != null) {
            bundle.putString(VKApiConst.FIELDS, this.f1679b);
        }
        if (this.f1678a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : this.f1678a) {
                stringBuffer.append(str).append(",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            bundle.putString("uids", stringBuffer.toString());
        }
        return bundle;
    }
}
