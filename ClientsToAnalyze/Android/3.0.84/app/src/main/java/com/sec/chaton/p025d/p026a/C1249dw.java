package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.chat.p024b.C0965p;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3250y;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.dw */
/* loaded from: classes.dex */
public class C1249dw extends AbstractC1145a {

    /* renamed from: b */
    private String f4817b;

    /* renamed from: c */
    private String f4818c;

    public C1249dw(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4817b = C1249dw.class.getSimpleName();
        this.f4818c = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_text", this.f4818c);
        } catch (JSONException e) {
            C3250y.m11443a(e, this.f4817b);
        }
        return jSONObject.toString();
    }

    @Override // com.sec.common.p066d.p067a.p068a.AbstractC3315a, com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: a */
    protected void mo5565a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws IOException {
        try {
            outputStream.write(C0965p.m5184b(C0952c.m5143c().m5153b(), m11676l()));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo5488a(com.sec.chaton.p016a.p017a.C0267d r10) {
        /*
            r9 = this;
            int r2 = r10.m1358i()
            com.sec.chaton.j.o r3 = r10.m1351b()
            boolean r4 = r10.m11704n()
            com.sec.chaton.j.o r0 = com.sec.chaton.p037j.EnumC1587o.SUCCESS
            if (r3 != r0) goto L4f
            java.lang.Object r0 = r10.m1354e()
            com.sec.chaton.io.entry.TranslationEntry r0 = (com.sec.chaton.p035io.entry.TranslationEntry) r0
        L16:
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz
            com.sec.chaton.chat.b.m r5 = com.sec.chaton.chat.p024b.EnumC0962m.ERROR_FAILED_ABNORMAL
            r1.<init>(r9, r5, r0)
            boolean r5 = com.sec.chaton.util.C3250y.f11734b     // Catch: java.lang.Exception -> L65
            if (r5 == 0) goto L40
            java.lang.String r5 = "afterRequest(), connectionSuccess(%s), httpResultCode(%s), httpStatus(%d)"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L65
            r7 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L65
            r6[r7] = r8     // Catch: java.lang.Exception -> L65
            r7 = 1
            r6[r7] = r3     // Catch: java.lang.Exception -> L65
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L65
            r6[r7] = r8     // Catch: java.lang.Exception -> L65
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch: java.lang.Exception -> L65
            java.lang.String r6 = r9.f4817b     // Catch: java.lang.Exception -> L65
            com.sec.chaton.util.C3250y.m11450b(r5, r6)     // Catch: java.lang.Exception -> L65
        L40:
            com.sec.chaton.j.o r5 = com.sec.chaton.p037j.EnumC1587o.SUCCESS     // Catch: java.lang.Exception -> L65
            if (r3 != r5) goto L56
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz     // Catch: java.lang.Exception -> L65
            com.sec.chaton.chat.b.m r2 = com.sec.chaton.chat.p024b.EnumC0962m.SUCCESS     // Catch: java.lang.Exception -> L65
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L65
            r10.m1349a(r1)     // Catch: java.lang.Exception -> L65
        L4e:
            return
        L4f:
            java.lang.Object r0 = r10.mo11666o()
            com.sec.chaton.io.entry.TranslationEntry r0 = (com.sec.chaton.p035io.entry.TranslationEntry) r0
            goto L16
        L56:
            if (r4 == 0) goto L5a
            if (r0 != 0) goto L77
        L5a:
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz     // Catch: java.lang.Exception -> L65
            com.sec.chaton.chat.b.m r2 = com.sec.chaton.chat.p024b.EnumC0962m.ERROR_NOT_REQUESTED     // Catch: java.lang.Exception -> L65
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L65
            r10.m1349a(r1)     // Catch: java.lang.Exception -> L65
            goto L4e
        L65:
            r1 = move-exception
            java.lang.String r2 = r9.f4817b
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz
            com.sec.chaton.chat.b.m r2 = com.sec.chaton.chat.p024b.EnumC0962m.ERROR_LOCAL_EXCEPTION
            r1.<init>(r9, r2, r0)
            r0 = r1
        L73:
            r10.m1349a(r0)
            goto L4e
        L77:
            switch(r2) {
                case 400: goto L7c;
                case 404: goto L91;
                case 408: goto L91;
                case 500: goto L91;
                default: goto L7a;
            }
        L7a:
            r0 = r1
            goto L73
        L7c:
            java.lang.Long r2 = r0.rcode     // Catch: java.lang.Exception -> L65
            long r2 = r2.longValue()     // Catch: java.lang.Exception -> L65
            r4 = 19008(0x4a40, double:9.391E-320)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L7a
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz     // Catch: java.lang.Exception -> L65
            com.sec.chaton.chat.b.m r2 = com.sec.chaton.chat.p024b.EnumC0962m.ERROR_KEY_EXPIRED     // Catch: java.lang.Exception -> L65
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L65
            r0 = r1
            goto L73
        L91:
            com.sec.chaton.d.a.dz r1 = new com.sec.chaton.d.a.dz     // Catch: java.lang.Exception -> L65
            com.sec.chaton.chat.b.m r2 = com.sec.chaton.chat.p024b.EnumC0962m.ERROR_SERVER_ERROR     // Catch: java.lang.Exception -> L65
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L65
            r0 = r1
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.C1249dw.mo5488a(com.sec.chaton.a.a.d):void");
    }
}
