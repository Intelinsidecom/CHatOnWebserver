package com.sec.chaton.facebook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.sec.chaton.facebook.n */
/* loaded from: classes.dex */
class C0232n extends AbstractC0231m {

    /* renamed from: a */
    final /* synthetic */ FacebookManager f1869a;

    /* renamed from: e */
    private int f1870e;

    /* renamed from: f */
    private Bitmap f1871f;

    /* renamed from: g */
    private String f1872g;

    /* renamed from: h */
    private String[] f1873h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0232n(FacebookManager facebookManager, int i, String str, String[] strArr) {
        super(facebookManager, "UploadPhoto");
        this.f1869a = facebookManager;
        this.f1870e = i;
        this.f1872g = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0232n(FacebookManager facebookManager, Bitmap bitmap, String str, String[] strArr) {
        super(facebookManager, "UploadPhoto");
        this.f1869a = facebookManager;
        this.f1871f = bitmap;
        this.f1872g = str;
    }

    /* renamed from: a */
    private String m2371a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("{");
            sb.append("'tag_uid':");
            sb.append(strArr[i]);
            sb.append(",'x':0,'y':0");
            sb.append("}");
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private byte[] m2372a(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    @Override // com.sec.chaton.facebook.AbstractC0231m
    /* renamed from: a */
    protected int mo2365a() {
        Bundle bundle = new Bundle();
        if (this.f1870e > 0) {
            this.f1871f = BitmapFactory.decodeResource(this.f1869a.f1837b.getResources(), this.f1870e);
        }
        bundle.putByteArray("picture", m2372a(this.f1871f));
        bundle.putString("message", this.f1872g);
        if (this.f1873h != null) {
            String strM2371a = m2371a(this.f1873h);
            FacebookManager.m2348c("tags=" + strM2371a);
            bundle.putString("tags", strM2371a);
        }
        return m2370a("me/photos", bundle, "POST", "id");
    }
}
