package com.sec.chaton.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ChatOnGraphics.java */
/* renamed from: com.sec.chaton.util.ae */
/* loaded from: classes.dex */
public class C4813ae extends FilterInputStream {
    public C4813ae(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            long jSkip = this.in.skip(j - j2);
            if (jSkip == 0) {
                if (read() < 0) {
                    break;
                }
                jSkip = 1;
            }
            j2 = jSkip + j2;
        }
        return j2;
    }
}
