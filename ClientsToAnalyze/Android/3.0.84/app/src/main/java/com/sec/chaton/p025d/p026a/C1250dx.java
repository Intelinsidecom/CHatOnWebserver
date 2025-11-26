package com.sec.chaton.p025d.p026a;

import com.sec.chaton.p035io.entry.TranslationEntry;
import com.sec.chaton.util.C3247v;
import com.sec.common.p066d.p067a.AbstractC3314a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.dx */
/* loaded from: classes.dex */
public class C1250dx extends AbstractC3314a {
    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            C3247v c3247v = new C3247v();
            c3247v.m11431a(TranslationEntry.class);
            return c3247v.parse(inputStream);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
