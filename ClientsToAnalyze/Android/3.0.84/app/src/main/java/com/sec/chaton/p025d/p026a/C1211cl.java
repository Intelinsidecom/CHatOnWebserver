package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p035io.entry.TranslationAuthEntry;
import com.sec.chaton.util.C3247v;
import com.sec.common.p066d.p067a.AbstractC3314a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GetUserInfoTask.java */
/* renamed from: com.sec.chaton.d.a.cl */
/* loaded from: classes.dex */
public class C1211cl extends AbstractC3314a {
    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            C3247v c3247v = new C3247v();
            c3247v.m11431a(TranslationAuthEntry.class);
            return c3247v.parse(inputStream);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
