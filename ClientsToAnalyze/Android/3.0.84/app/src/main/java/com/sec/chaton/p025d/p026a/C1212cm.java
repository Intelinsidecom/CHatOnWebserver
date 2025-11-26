package com.sec.chaton.p025d.p026a;

import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.chat.p024b.C0965p;
import com.sec.chaton.p035io.entry.TranslationAuthEntry;
import com.sec.chaton.util.C3247v;
import com.sec.common.p066d.p067a.AbstractC3314a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GetUserInfoTask.java */
/* renamed from: com.sec.chaton.d.a.cm */
/* loaded from: classes.dex */
public class C1212cm extends AbstractC3314a {
    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            C3247v c3247v = new C3247v();
            c3247v.m11431a(TranslationAuthEntry.class);
            return c3247v.parse(C0965p.m5181a(C0952c.m5143c().m5153b(), inputStream));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
