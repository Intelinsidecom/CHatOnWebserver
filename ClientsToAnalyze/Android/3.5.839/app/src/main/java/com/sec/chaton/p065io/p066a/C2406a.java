package com.sec.chaton.p065io.p066a;

import com.sec.chaton.p046a.p047a.C0780d;
import com.sec.chaton.p067j.p069b.C2431a;
import com.sec.chaton.p067j.p069b.C2432b;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.AbstractC4976a;
import com.sec.common.util.C5052r;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: ChatONFaultCodeParser.java */
/* renamed from: com.sec.chaton.io.a.a */
/* loaded from: classes.dex */
public class C2406a extends AbstractC4976a {

    /* renamed from: a */
    private static final String f8546a = C2406a.class.getSimpleName();

    @Override // com.sec.common.p126d.p127a.AbstractC4976a
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
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Fault message: ", sb.toString()), f8546a);
                    }
                    String strM10533a = C2432b.m10533a(sb.toString());
                    return new C0780d(strM10533a, C2431a.m10532a(strM10533a));
                }
            }
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8546a);
            }
            throw e;
        }
    }
}
