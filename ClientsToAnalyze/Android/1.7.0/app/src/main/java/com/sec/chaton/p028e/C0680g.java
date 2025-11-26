package com.sec.chaton.p028e;

import android.content.Intent;
import com.sec.chaton.multimedia.vcalendar.C0811a;
import com.sec.chaton.multimedia.vcalendar.C0823m;
import com.sec.chaton.util.C1341p;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: InterlockedCalendar.java */
/* renamed from: com.sec.chaton.e.g */
/* loaded from: classes.dex */
public class C0680g implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2326a;

    public C0680g(Intent intent) {
        this.f2326a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0107  */
    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0250am mo3045a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p028e.C0680g.mo3045a():com.sec.chaton.am");
    }

    /* renamed from: a */
    private String m3046a(String str) throws IOException {
        if (str == null) {
            str = null;
        } else {
            try {
                String[] strArrSplit = str.split("file://");
                if (strArrSplit.length != 1) {
                    if (strArrSplit.length == 2) {
                        str = strArrSplit[1];
                    } else {
                        return "";
                    }
                }
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
                return "";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line).append("\n");
            } else {
                bufferedReader.close();
                return ((C0811a) new C0823m().m3353a(sb.toString()).f2800a.get(0)).f2795i;
            }
        }
    }
}
