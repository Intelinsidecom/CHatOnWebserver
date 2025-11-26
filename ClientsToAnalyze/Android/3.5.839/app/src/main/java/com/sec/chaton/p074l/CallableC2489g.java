package com.sec.chaton.p074l;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.util.C4813ae;
import com.sec.chaton.util.C4904y;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: GetContactMyProfileWorker.java */
/* renamed from: com.sec.chaton.l.g */
/* loaded from: classes.dex */
public class CallableC2489g implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private static final String f8928a = CallableC2489g.class.getSimpleName();

    /* renamed from: b */
    private Context f8929b;

    /* renamed from: c */
    private EnumC2508z f8930c;

    public CallableC2489g(Context context, EnumC2508z enumC2508z) {
        this.f8929b = context;
        this.f8930c = enumC2508z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws Throwable {
        long jM6054a = C1002i.m6054a();
        InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f8929b.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, jM6054a));
        if (inputStreamOpenContactPhotoInputStream == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("fail to GetContactMyProfileWorker from contactId : " + jM6054a + ", rawId : " + jM6054a, f8928a);
            }
            return C2496n.f8946a;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("success to GetContactMyProfileWorker from contactId : " + jM6054a + ", rawId : " + jM6054a, f8928a);
        }
        return BitmapFactory.decodeStream(new C4813ae(inputStreamOpenContactPhotoInputStream));
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8930c.m10808a();
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
