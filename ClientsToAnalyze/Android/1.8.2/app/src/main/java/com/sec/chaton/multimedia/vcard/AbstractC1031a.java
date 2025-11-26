package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ContactAccessor.java */
/* renamed from: com.sec.chaton.multimedia.vcard.a */
/* loaded from: classes.dex */
public abstract class AbstractC1031a {

    /* renamed from: a */
    private static AbstractC1031a f3829a;

    /* renamed from: a */
    public abstract Intent mo3994a();

    /* renamed from: a */
    public abstract C1038h mo3995a(ContentResolver contentResolver, Uri uri);

    /* renamed from: a */
    public static AbstractC1031a m4023a(Context context) {
        if (f3829a == null) {
            f3829a = new ContactAccessorSdk5();
        }
        return f3829a;
    }
}
