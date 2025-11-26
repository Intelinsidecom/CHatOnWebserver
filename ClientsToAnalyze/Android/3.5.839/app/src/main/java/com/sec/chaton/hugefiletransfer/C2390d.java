package com.sec.chaton.hugefiletransfer;

import com.sec.chaton.p065io.entry.HugeFileUploadErrorEntry;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.InputStream;

/* compiled from: HugeFileErrorParser.java */
/* renamed from: com.sec.chaton.hugefiletransfer.d */
/* loaded from: classes.dex */
public class C2390d extends AbstractC4976a {
    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) {
        try {
            C4901v c4901v = new C4901v();
            c4901v.m18627a(HugeFileUploadErrorEntry.class);
            return c4901v.parse(inputStream);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
            return null;
        }
    }
}
