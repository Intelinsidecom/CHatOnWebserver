package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: OkIOUtil.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.d */
/* loaded from: classes.dex */
public class C4498d {
    /* renamed from: a */
    public static void m17037a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static final String m17036a(InputStream inputStream) throws IOException {
        int i;
        char[] cArr = new char[65536];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        do {
            try {
                i = inputStreamReader.read(cArr, 0, cArr.length);
                if (i > 0) {
                    sb.append(cArr, 0, i);
                }
            } catch (Throwable th) {
                m17037a(inputStreamReader);
                throw th;
            }
        } while (i >= 0);
        m17037a(inputStreamReader);
        return sb.toString();
    }
}
