package com.sec.chaton.plugin.p083b;

import com.sec.chaton.plugin.p087f.C2946a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: StringReader.java */
/* renamed from: com.sec.chaton.plugin.b.g */
/* loaded from: classes.dex */
public class C2930g extends AbstractC2929f {

    /* renamed from: a */
    private static final String f10811a = C2930g.class.getSimpleName();

    /* renamed from: b */
    private InputStream f10812b = null;

    @Override // com.sec.chaton.plugin.p083b.AbstractC2929f
    /* renamed from: a */
    public String mo12156a(HttpURLConnection httpURLConnection) {
        this.f10812b = httpURLConnection.getInputStream();
        return m12162a(this.f10812b).trim();
    }

    /* renamed from: a */
    protected String m12162a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append("\n");
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    C2946a.m12187a(e2, f10811a);
                }
            }
        }
        return sb.toString();
    }

    @Override // com.sec.chaton.plugin.p083b.AbstractC2929f
    /* renamed from: a */
    public void mo12157a() throws IOException {
        try {
            if (this.f10812b != null) {
                this.f10812b.close();
            }
        } catch (IOException e) {
            C2946a.m12187a(e, f10811a);
        }
    }
}
