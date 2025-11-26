package com.sec.chaton.p074l;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import com.sec.chaton.util.C4813ae;
import com.sec.chaton.util.C4904y;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: GetContactProfileWorker.java */
/* renamed from: com.sec.chaton.l.h */
/* loaded from: classes.dex */
public class CallableC2490h implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private static final String f8931a = CallableC2487e.class.getSimpleName();

    /* renamed from: b */
    private Context f8932b;

    /* renamed from: c */
    private String f8933c;

    /* renamed from: d */
    private EnumC2508z f8934d;

    public CallableC2490h(Context context, String str, EnumC2508z enumC2508z) {
        this.f8932b = context;
        this.f8933c = str;
        this.f8934d = enumC2508z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() {
        InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f8932b.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(this.f8933c)));
        if (inputStreamOpenContactPhotoInputStream == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("fail to loadContactImage from contactId : " + this.f8933c + ", rawId : " + this.f8933c, f8931a);
            }
            return C2496n.f8946a;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("success to loadContactImage from contactId : " + this.f8933c + ", rawId : " + this.f8933c, f8931a);
        }
        return BitmapFactory.decodeStream(new C4813ae(inputStreamOpenContactPhotoInputStream));
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8934d.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }
}
