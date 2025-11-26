package com.sec.chaton.facebook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.q */
/* loaded from: classes.dex */
class C0702q extends AbstractC0701p {

    /* renamed from: a */
    final /* synthetic */ C0700o f2382a;

    /* renamed from: e */
    private int f2383e;

    /* renamed from: f */
    private Bitmap f2384f;

    /* renamed from: g */
    private String f2385g;

    /* renamed from: h */
    private String[] f2386h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0702q(C0700o c0700o, int i, String str, String[] strArr) {
        super(c0700o, "UploadPhoto");
        this.f2382a = c0700o;
        this.f2383e = i;
        this.f2385g = str;
    }

    @Override // com.sec.chaton.facebook.AbstractC0701p
    /* renamed from: a */
    protected int mo3065a() {
        Bundle bundle = new Bundle();
        if (this.f2383e > 0) {
            this.f2384f = BitmapFactory.decodeResource(this.f2382a.f2376b.getResources(), this.f2383e);
        }
        bundle.putByteArray("picture", m3090a(this.f2384f));
        bundle.putString("message", this.f2385g);
        if (this.f2386h != null) {
            String strM3089a = m3089a(this.f2386h);
            C0700o.m3078c("tags=" + strM3089a);
            bundle.putString("tags", strM3089a);
        }
        return m3088a("me/photos", bundle, "POST", "id");
    }

    /* renamed from: a */
    private byte[] m3090a(Bitmap bitmap) throws IOException {
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

    /* renamed from: a */
    private String m3089a(String[] strArr) {
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
}
