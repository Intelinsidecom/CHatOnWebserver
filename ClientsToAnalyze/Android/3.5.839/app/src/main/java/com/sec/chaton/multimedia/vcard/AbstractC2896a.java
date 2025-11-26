package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ContactAccessor.java */
/* renamed from: com.sec.chaton.multimedia.vcard.a */
/* loaded from: classes.dex */
public abstract class AbstractC2896a {

    /* renamed from: a */
    private static AbstractC2896a f10711a;

    /* renamed from: a */
    public abstract Intent mo12060a();

    /* renamed from: a */
    public abstract C2897b mo12061a(ContentResolver contentResolver, Uri uri);

    /* renamed from: a */
    public static AbstractC2896a m12090a(Context context) {
        if (f10711a == null) {
            f10711a = new ContactAccessorSdk5();
        }
        return f10711a;
    }
}
