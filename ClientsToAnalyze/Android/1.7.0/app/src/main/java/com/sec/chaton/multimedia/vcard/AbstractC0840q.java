package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ContactAccessor.java */
/* renamed from: com.sec.chaton.multimedia.vcard.q */
/* loaded from: classes.dex */
public abstract class AbstractC0840q {

    /* renamed from: a */
    private static AbstractC0840q f2920a;

    /* renamed from: a */
    public abstract Intent mo3355a();

    /* renamed from: a */
    public abstract C0833j mo3356a(ContentResolver contentResolver, Uri uri);

    /* renamed from: a */
    public static AbstractC0840q m3411a(Context context) {
        if (f2920a == null) {
            f2920a = new ContactAccessorSdk5();
        }
        return f2920a;
    }
}
