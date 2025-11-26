package com.sec.chaton.settings.tellfriends;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TellFriendsImageDownloader.java */
/* renamed from: com.sec.chaton.settings.tellfriends.by */
/* loaded from: classes.dex */
class C1397by extends FilterInputStream {
    public C1397by(InputStream inputStream) {
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
