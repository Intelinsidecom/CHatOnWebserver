package com.sec.chaton.interlocked;

import android.content.Intent;
import com.sec.chaton.multimedia.vcalendar.VCalParser;
import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class InterlockedCalendar implements InterlockWithNative {

    /* renamed from: a */
    private Intent f1910a;

    public InterlockedCalendar(Intent intent) {
        this.f1910a = intent;
    }

    /* renamed from: a */
    private String m2392a(String str) throws IOException {
        String str2 = null;
        if (str != null) {
            try {
                String[] strArrSplit = str.split("file://");
                if (strArrSplit.length == 1) {
                    str2 = str;
                } else {
                    if (strArrSplit.length != 2) {
                        return "";
                    }
                    str2 = strArrSplit[1];
                }
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                return "";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str2)));
        String str3 = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return ((VCalendarStruct.EventStruct) new VCalParser().m2560a(str3).f2235a.get(0)).f2244i;
            }
            str3 = str3 + line + "\n";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0100  */
    @Override // com.sec.chaton.interlocked.InterlockWithNative
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.HandleIntent.IntentDest mo2391a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.interlocked.InterlockedCalendar.mo2391a():com.sec.chaton.HandleIntent$IntentDest");
    }
}
