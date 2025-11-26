package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p065io.entry.TranslationEntry;
import com.sec.chaton.util.C4901v;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.ev */
/* loaded from: classes.dex */
public class C2030ev extends AbstractC4976a {
    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws IOException {
        try {
            C4901v c4901v = new C4901v();
            c4901v.m18627a(TranslationEntry.class);
            return c4901v.parse(inputStream);
        } catch (Exception e) {
            throw C1057b.m6157a(e);
        }
    }
}
