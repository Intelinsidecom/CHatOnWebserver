package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* compiled from: AbstractLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1019a {

    /* renamed from: a */
    static final Charset f3316a = Charset.forName("UTF-8");

    /* renamed from: b */
    public static final String f3317b = f3316a.name();

    /* renamed from: a */
    public abstract boolean mo6112a(Activity activity, Intent intent);

    /* renamed from: a */
    public boolean m6111a() {
        return true;
    }

    /* renamed from: a */
    protected String m6110a(Uri uri, String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key");
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return "";
        }
        int length = encodedQuery.length();
        int i = 0;
        while (true) {
            int iIndexOf = encodedQuery.indexOf(38, i);
            int i2 = iIndexOf != -1 ? iIndexOf : length;
            int iIndexOf2 = encodedQuery.indexOf(61, i);
            if (iIndexOf2 > i2 || iIndexOf2 == -1) {
                iIndexOf2 = i2;
            }
            if (iIndexOf2 - i == str.length() && encodedQuery.regionMatches(i, str, 0, str.length())) {
                if (iIndexOf2 == i2) {
                    return "";
                }
                return URLDecoder.decode(encodedQuery.substring(iIndexOf2 + 1, i2), str2);
            }
            if (iIndexOf != -1) {
                i = iIndexOf + 1;
            } else {
                return "";
            }
        }
    }
}
