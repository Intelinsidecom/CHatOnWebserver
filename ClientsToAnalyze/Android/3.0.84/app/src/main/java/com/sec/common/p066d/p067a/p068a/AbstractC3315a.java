package com.sec.common.p066d.p067a.p068a;

import android.text.TextUtils;
import com.sec.common.p066d.p067a.AbstractC3314a;
import com.sec.common.p066d.p067a.AbstractCallableC3318b;
import com.sec.common.p066d.p067a.p068a.C3316b;
import com.sec.common.p066d.p067a.p068a.C3317c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: AbstractHttpTextTask.java */
/* renamed from: com.sec.common.d.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC3315a<ReqType extends C3316b, ResType extends C3317c> extends AbstractCallableC3318b<String, ReqType, ResType> {
    public AbstractC3315a(ReqType reqtype) {
        super(reqtype);
    }

    @Override // com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: a */
    protected void mo11661a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (inputStream != null) {
            ReqType reqtypeJ = m11674j();
            ResType restypeK = m11675k();
            AbstractC3314a abstractC3314aM11663q = reqtypeJ.m11663q();
            if (restypeK.m11703m() != 204 && abstractC3314aM11663q != null) {
                restypeK.m11665c(abstractC3314aM11663q.parse(inputStream));
            }
        }
    }

    @Override // com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: a */
    protected void mo5565a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws InterruptedException, IOException {
        if (!TextUtils.isEmpty(m11676l())) {
            int i = 0;
            byte[] bytes = m11676l().getBytes();
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
