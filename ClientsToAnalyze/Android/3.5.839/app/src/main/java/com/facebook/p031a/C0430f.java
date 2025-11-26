package com.facebook.p031a;

import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: Util.java */
/* renamed from: com.facebook.a.f */
/* loaded from: classes.dex */
public final class C0430f {
    @Deprecated
    /* renamed from: a */
    public static Bundle m1552a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                try {
                    if (strArrSplit.length == 2) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                    } else if (strArrSplit.length == 1) {
                        bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return bundle;
    }

    @Deprecated
    /* renamed from: b */
    public static Bundle m1553b(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle bundleM1552a = m1552a(url.getQuery());
            bundleM1552a.putAll(m1552a(url.getRef()));
            return bundleM1552a;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }
}
