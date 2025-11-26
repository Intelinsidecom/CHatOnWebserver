package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ContactAccessor.java */
/* renamed from: com.sec.chaton.multimedia.vcard.a */
/* loaded from: classes.dex */
public abstract class AbstractC1927a {

    /* renamed from: a */
    private static AbstractC1927a f7390a;

    /* renamed from: a */
    public abstract Intent mo7831a();

    /* renamed from: a */
    public abstract C1928b mo7832a(ContentResolver contentResolver, Uri uri);

    /* renamed from: a */
    public static AbstractC1927a m7863a(Context context) {
        if (f7390a == null) {
            f7390a = new ContactAccessorSdk5();
        }
        return f7390a;
    }
}
