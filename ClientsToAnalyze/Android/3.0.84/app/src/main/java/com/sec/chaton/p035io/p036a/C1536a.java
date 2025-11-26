package com.sec.chaton.p035io.p036a;

import com.sec.chaton.p016a.p017a.C0269f;
import com.sec.chaton.p037j.p039b.C1552a;
import com.sec.chaton.p037j.p039b.C1553b;
import com.sec.chaton.util.C3250y;
import com.sec.common.p066d.p067a.AbstractC3314a;
import com.sec.common.util.C3364o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: ChatONFaultCodeParser.java */
/* renamed from: com.sec.chaton.io.a.a */
/* loaded from: classes.dex */
public class C1536a extends AbstractC3314a {

    /* renamed from: a */
    private static final String f5625a = C1536a.class.getSimpleName();

    @Override // com.sec.common.p066d.p067a.AbstractC3314a
    public Object parse(InputStream inputStream) throws InterruptedException, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException("ChatONFaultCodeParser is interrupted.");
                    }
                    sb.append(line);
                    sb.append("\n");
                } else {
                    if (C3250y.f11737e) {
                        C3250y.m11442a(C3364o.m11849a("Fault message: ", sb.toString()), f5625a);
                    }
                    String strM6588a = C1553b.m6588a(sb.toString());
                    return new C0269f(strM6588a, C1552a.m6587a(strM6588a));
                }
            }
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5625a);
            }
            throw e;
        }
    }
}
