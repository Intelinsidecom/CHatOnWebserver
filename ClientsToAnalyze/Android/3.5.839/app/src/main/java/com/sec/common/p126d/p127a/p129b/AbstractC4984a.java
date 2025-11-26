package com.sec.common.p126d.p127a.p129b;

import android.text.TextUtils;
import com.sec.common.p126d.p127a.AbstractC4976a;
import com.sec.common.p126d.p127a.AbstractCallableC4983b;
import com.sec.common.p126d.p127a.p129b.C4985b;
import com.sec.common.p126d.p127a.p129b.C4986c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: AbstractHttpTextTask.java */
/* renamed from: com.sec.common.d.a.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC4984a<ReqType extends C4985b, ResType extends C4986c> extends AbstractCallableC4983b<String, ReqType, ResType> {
    public AbstractC4984a(ReqType reqtype) {
        super(reqtype);
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b */
    protected void mo10418b(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (inputStream != null) {
            ReqType reqtypeH = m18918h();
            ResType restypeI = m18919i();
            AbstractC4976a abstractC4976aM18924o = reqtypeH.m18924o();
            if (restypeI.m18953m() != 204 && abstractC4976aM18924o != null) {
                restypeI.m18926c(abstractC4976aM18924o.parse(inputStream));
            }
        }
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws InterruptedException, IOException {
        if (!TextUtils.isEmpty(m18920j())) {
            int i = 0;
            byte[] bytes = m18920j().getBytes();
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
