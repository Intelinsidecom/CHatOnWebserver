package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.content.Intent;
import java.io.OutputStream;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ProgressCallbackEntity.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.u */
/* loaded from: classes.dex */
public class C4085u extends ByteArrayEntity {

    /* renamed from: a */
    private final Context f14705a;

    /* renamed from: b */
    private final byte[] f14706b;

    /* renamed from: c */
    private final long f14707c;

    public C4085u(Context context, long j, byte[] bArr) {
        super(bArr);
        this.f14705a = context;
        this.f14706b = bArr;
        this.f14707c = j;
    }

    @Override // org.apache.http.entity.ByteArrayEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            m15698a(-1);
            int length = this.f14706b.length;
            int i = 0;
            while (i < length) {
                int i2 = length - i;
                if (i2 > 4096) {
                    i2 = 4096;
                }
                outputStream.write(this.f14706b, i, i2);
                outputStream.flush();
                int i3 = i2 + i;
                m15698a((i3 * 100) / length);
                i = i3;
            }
            m15698a(100);
        } catch (Throwable th) {
            m15698a(-2);
            throw th;
        }
    }

    /* renamed from: a */
    private void m15698a(int i) {
        if (this.f14707c > 0) {
            Intent intent = new Intent("com.sec.chaton.smsplugin.PROGRESS_STATUS");
            intent.putExtra("progress", i);
            intent.putExtra("token", this.f14707c);
            this.f14705a.sendBroadcast(intent);
        }
    }
}
