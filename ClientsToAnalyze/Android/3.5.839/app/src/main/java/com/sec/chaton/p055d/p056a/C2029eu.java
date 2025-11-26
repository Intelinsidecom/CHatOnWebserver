package com.sec.chaton.p055d.p056a;

import com.sec.chaton.chat.translate.C1850c;
import com.sec.chaton.chat.translate.C1865r;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4904y;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.eu */
/* loaded from: classes.dex */
public class C2029eu extends AbstractC1900a {

    /* renamed from: b */
    private String f7432b;

    /* renamed from: c */
    private String f7433c;

    public C2029eu(C2454e c2454e, String str) {
        super(c2454e);
        this.f7432b = C2029eu.class.getSimpleName();
        this.f7433c = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_text", this.f7433c);
        } catch (JSONException e) {
            C4904y.m18635a(e, this.f7432b);
        }
        return jSONObject.toString();
    }

    @Override // com.sec.common.p126d.p127a.p129b.AbstractC4984a, com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                byte[] bArrM9071b = C1865r.m9071b(C1850c.m9024d().m9036c(), m18920j());
                if (bArrM9071b != null && bArrM9071b.length > 0) {
                    outputStream.write(bArrM9071b);
                }
            } catch (Exception e) {
                throw C1057b.m6157a(e);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo9084a(com.sec.chaton.p046a.p047a.C0778b r10) {
        /*
            r9 = this;
            int r2 = r10.m3114i()
            com.sec.chaton.j.o r3 = r10.m3107b()
            boolean r4 = r10.m18954n()
            com.sec.chaton.j.o r0 = com.sec.chaton.p067j.EnumC2464o.SUCCESS
            if (r3 != r0) goto L50
            java.lang.Object r0 = r10.m3110e()
            com.sec.chaton.io.entry.TranslationEntry r0 = (com.sec.chaton.p065io.entry.TranslationEntry) r0
        L16:
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex
            com.sec.chaton.chat.translate.m r5 = com.sec.chaton.chat.translate.EnumC1860m.ERROR_FAILED_ABNORMAL
            r1.<init>(r9, r5, r0)
            boolean r5 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Exception -> L66
            if (r5 == 0) goto L41
            java.lang.String r5 = "afterRequest(), connectionSuccess(%s), httpResultCode(%s), httpStatus(%d)"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L66
            r7 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L66
            r6[r7] = r8     // Catch: java.lang.Exception -> L66
            r7 = 1
            r6[r7] = r3     // Catch: java.lang.Exception -> L66
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L66
            r6[r7] = r8     // Catch: java.lang.Exception -> L66
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch: java.lang.Exception -> L66
            java.lang.String r6 = r9.f7432b     // Catch: java.lang.Exception -> L66
            com.sec.chaton.util.C4904y.m18639b(r5, r6)     // Catch: java.lang.Exception -> L66
        L41:
            com.sec.chaton.j.o r5 = com.sec.chaton.p067j.EnumC2464o.SUCCESS     // Catch: java.lang.Exception -> L66
            if (r3 != r5) goto L57
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex     // Catch: java.lang.Exception -> L66
            com.sec.chaton.chat.translate.m r2 = com.sec.chaton.chat.translate.EnumC1860m.SUCCESS     // Catch: java.lang.Exception -> L66
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L66
            r10.m3106a(r1)     // Catch: java.lang.Exception -> L66
        L4f:
            return
        L50:
            java.lang.Object r0 = r10.mo18927o()
            com.sec.chaton.io.entry.TranslationEntry r0 = (com.sec.chaton.p065io.entry.TranslationEntry) r0
            goto L16
        L57:
            if (r4 == 0) goto L5b
            if (r0 != 0) goto L78
        L5b:
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex     // Catch: java.lang.Exception -> L66
            com.sec.chaton.chat.translate.m r2 = com.sec.chaton.chat.translate.EnumC1860m.ERROR_NOT_REQUESTED     // Catch: java.lang.Exception -> L66
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L66
            r10.m3106a(r1)     // Catch: java.lang.Exception -> L66
            goto L4f
        L66:
            r1 = move-exception
            java.lang.String r2 = r9.f7432b
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex
            com.sec.chaton.chat.translate.m r2 = com.sec.chaton.chat.translate.EnumC1860m.ERROR_LOCAL_EXCEPTION
            r1.<init>(r9, r2, r0)
            r0 = r1
        L74:
            r10.m3106a(r0)
            goto L4f
        L78:
            switch(r2) {
                case 400: goto L7d;
                case 404: goto L92;
                case 408: goto L92;
                case 500: goto L92;
                default: goto L7b;
            }
        L7b:
            r0 = r1
            goto L74
        L7d:
            java.lang.Long r2 = r0.rcode     // Catch: java.lang.Exception -> L66
            long r2 = r2.longValue()     // Catch: java.lang.Exception -> L66
            r4 = 19008(0x4a40, double:9.391E-320)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L7b
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex     // Catch: java.lang.Exception -> L66
            com.sec.chaton.chat.translate.m r2 = com.sec.chaton.chat.translate.EnumC1860m.ERROR_KEY_EXPIRED     // Catch: java.lang.Exception -> L66
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L66
            r0 = r1
            goto L74
        L92:
            com.sec.chaton.d.a.ex r1 = new com.sec.chaton.d.a.ex     // Catch: java.lang.Exception -> L66
            com.sec.chaton.chat.translate.m r2 = com.sec.chaton.chat.translate.EnumC1860m.ERROR_SERVER_ERROR     // Catch: java.lang.Exception -> L66
            r1.<init>(r9, r2, r0)     // Catch: java.lang.Exception -> L66
            r0 = r1
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.C2029eu.mo9084a(com.sec.chaton.a.a.b):void");
    }
}
