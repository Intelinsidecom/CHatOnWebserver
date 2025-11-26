package com.sec.chaton.p021g;

import android.content.Intent;
import com.sec.chaton.multimedia.vcalendar.C1023c;
import com.sec.chaton.multimedia.vcalendar.C1030j;
import com.sec.chaton.util.C1786r;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: InterlockedCalendar.java */
/* renamed from: com.sec.chaton.g.c */
/* loaded from: classes.dex */
public class C0754c implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2769a;

    public C0754c(Intent intent) {
        this.f2769a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0836m mo3250a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p021g.C0754c.mo3250a():com.sec.chaton.m");
    }

    /* renamed from: a */
    private String m3251a(String str) throws IOException {
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
                C1786r.m6056a(e, getClass().getSimpleName());
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
                return ((C1030j) new C1023c().m3983a(sb.toString()).f3772a.get(0)).f3781i;
            }
        }
    }
}
