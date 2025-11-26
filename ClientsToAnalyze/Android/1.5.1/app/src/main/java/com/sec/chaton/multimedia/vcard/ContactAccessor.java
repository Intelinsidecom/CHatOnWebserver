package com.sec.chaton.multimedia.vcard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class ContactAccessor {

    /* renamed from: a */
    private static ContactAccessor f2280a;

    /* renamed from: a */
    public static ContactAccessor m2612a(Context context) {
        if (f2280a == null) {
            try {
                f2280a = (ContactAccessor) Class.forName(Integer.parseInt(Build.VERSION.SDK) < 5 ? context.getPackageName() + ".multimedia.vcard.contactContactAccessorSdk3_4" : context.getPackageName() + ".multimedia.vcard.ContactAccessorSdk5").asSubclass(ContactAccessor.class).newInstance();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return f2280a;
    }

    /* renamed from: a */
    public abstract Intent mo2613a();

    /* renamed from: a */
    public abstract ContactStruct mo2614a(ContentResolver contentResolver, Uri uri);
}
