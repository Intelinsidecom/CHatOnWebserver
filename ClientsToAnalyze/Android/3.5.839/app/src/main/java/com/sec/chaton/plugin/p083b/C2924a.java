package com.sec.chaton.plugin.p083b;

import com.sec.chaton.plugin.p087f.C2946a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ErrorStringReader.java */
/* renamed from: com.sec.chaton.plugin.b.a */
/* loaded from: classes.dex */
public class C2924a extends C2930g {

    /* renamed from: a */
    private static final String f10796a = C2930g.class.getSimpleName();

    /* renamed from: b */
    private InputStream f10797b;

    @Override // com.sec.chaton.plugin.p083b.C2930g, com.sec.chaton.plugin.p083b.AbstractC2929f
    /* renamed from: a */
    public String mo12156a(HttpURLConnection httpURLConnection) {
        this.f10797b = httpURLConnection.getErrorStream();
        return m12162a(this.f10797b).trim();
    }

    @Override // com.sec.chaton.plugin.p083b.C2930g, com.sec.chaton.plugin.p083b.AbstractC2929f
    /* renamed from: a */
    public void mo12157a() throws IOException {
        try {
            if (this.f10797b != null) {
                this.f10797b.close();
            }
        } catch (IOException e) {
            C2946a.m12187a(e, f10796a);
        }
    }
}
