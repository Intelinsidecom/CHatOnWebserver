package com.sec.chaton.qmlog;

import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.AbstractC1900a;
import com.sec.chaton.p067j.C2454e;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: QMLogSendingTask.java */
/* renamed from: com.sec.chaton.qmlog.i */
/* loaded from: classes.dex */
public class C3127i extends AbstractC1900a {

    /* renamed from: b */
    private String f11505b;

    public C3127i(C2454e c2454e, String str) {
        super(c2454e);
        this.f11505b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        return this.f11505b;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) {
    }

    @Override // com.sec.common.p126d.p127a.p129b.AbstractC4984a, com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws InterruptedException, IOException {
        if (!TextUtils.isEmpty(m18920j())) {
            int i = 0;
            byte[] bytes = m18920j().getBytes("UTF-8");
            int length = 256;
            while (!Thread.interrupted()) {
                if (i + length > bytes.length) {
                    length = bytes.length - i;
                }
                outputStream.write(bytes, i, length);
                outputStream.flush();
                i += length;
                if (length != 256) {
                    return;
                }
            }
            throw new InterruptedException("writeToOutputStream is interrupted.");
        }
    }
}
