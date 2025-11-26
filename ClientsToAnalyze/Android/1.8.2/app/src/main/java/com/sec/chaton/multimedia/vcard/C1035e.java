package com.sec.chaton.multimedia.vcard;

import android.content.ContentUris;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sec.chaton.global.GlobalApplication;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.e */
/* loaded from: classes.dex */
class C1035e implements Comparator {

    /* renamed from: a */
    long f3833a;

    /* renamed from: b */
    int f3834b = 2;

    /* renamed from: c */
    String f3835c;

    /* renamed from: d */
    Bitmap f3836d;

    /* renamed from: e */
    Uri f3837e;

    /* renamed from: f */
    final /* synthetic */ ContactPicker f3838f;

    public C1035e(ContactPicker contactPicker, char c) {
        this.f3838f = contactPicker;
        this.f3835c = ("" + c).toUpperCase();
    }

    public C1035e(ContactPicker contactPicker) {
        this.f3838f = contactPicker;
    }

    /* renamed from: a */
    public void m4025a(long j) throws IOException {
        try {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(GlobalApplication.m3256a().getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j));
            if (inputStreamOpenContactPhotoInputStream != null) {
                this.f3836d = BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream);
                inputStreamOpenContactPhotoInputStream.close();
            }
        } catch (Exception e) {
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1035e c1035e, C1035e c1035e2) {
        if (c1035e == null || c1035e.f3835c == null) {
            if (c1035e2 == null || c1035e2.f3835c == null) {
                return 0;
            }
            return 1;
        }
        if (c1035e2 == null || c1035e2.f3835c == null) {
            return -1;
        }
        return c1035e.f3835c.compareToIgnoreCase(c1035e2.f3835c);
    }
}
