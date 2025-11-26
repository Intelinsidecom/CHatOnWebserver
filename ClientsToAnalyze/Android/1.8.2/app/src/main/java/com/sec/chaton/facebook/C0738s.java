package com.sec.chaton.facebook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.s */
/* loaded from: classes.dex */
class C0738s extends AbstractC0728i {

    /* renamed from: a */
    final /* synthetic */ C0725f f2731a;

    /* renamed from: e */
    private int f2732e;

    /* renamed from: f */
    private Bitmap f2733f;

    /* renamed from: g */
    private String f2734g;

    /* renamed from: h */
    private String[] f2735h;

    /* synthetic */ C0738s(C0725f c0725f, int i, String str, String[] strArr, HandlerC0726g handlerC0726g) {
        this(c0725f, i, str, strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0738s(C0725f c0725f, int i, String str, String[] strArr) {
        super(c0725f, "UploadPhoto");
        this.f2731a = c0725f;
        this.f2732e = i;
        this.f2734g = str;
    }

    @Override // com.sec.chaton.facebook.AbstractC0728i
    /* renamed from: a */
    protected int mo3226a() {
        Bundle bundle = new Bundle();
        if (this.f2732e > 0) {
            this.f2733f = BitmapFactory.decodeResource(this.f2731a.f2703c.getResources(), this.f2732e);
        }
        bundle.putByteArray("picture", m3237a(this.f2733f));
        bundle.putString("message", this.f2734g);
        if (this.f2735h != null) {
            String strM3236a = m3236a(this.f2735h);
            C0725f.m3213c("tags=" + strM3236a);
            bundle.putString("tags", strM3236a);
        }
        return m3229a("me/photos", bundle, "POST", "id");
    }

    /* renamed from: a */
    private byte[] m3237a(Bitmap bitmap) throws IOException {
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
    private String m3236a(String[] strArr) {
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
