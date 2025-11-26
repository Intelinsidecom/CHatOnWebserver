package com.sec.chaton.p021g;

import android.content.Intent;
import com.sec.chaton.multimedia.vcard.C1048r;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: InterlockedContact.java */
/* renamed from: com.sec.chaton.g.d */
/* loaded from: classes.dex */
public class C0755d implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2770a;

    public C0755d(Intent intent) {
        this.f2770a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0836m mo3250a() {
        /*
            r7 = this;
            android.content.Intent r0 = r7.f2770a
            java.lang.String r1 = "content_type"
            com.sec.chaton.e.n r2 = com.sec.chaton.p017e.EnumC0699n.CONTACT
            int r2 = r2.m3162a()
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r7.f2770a
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "android.intent.extra.STREAM"
            java.lang.Object r1 = r0.get(r1)
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.String r6 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.SecurityException -> L74
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.SecurityException -> L74
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.SecurityException -> L74
            if (r2 == 0) goto L9b
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L9b
            r0 = 0
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L78
        L3a:
            if (r2 == 0) goto L3f
            r2.close()
        L3f:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L98
            android.content.Intent r2 = r7.f2770a
            java.lang.String r3 = "callForward"
            r4 = 1
            r2.putExtra(r3, r4)
            android.content.Intent r2 = r7.f2770a     // Catch: java.lang.StringIndexOutOfBoundsException -> L7f
            java.lang.String r3 = "sub_content"
            r4 = 0
            java.lang.String r5 = "."
            int r5 = r0.lastIndexOf(r5)     // Catch: java.lang.StringIndexOutOfBoundsException -> L7f
            java.lang.String r4 = r0.substring(r4, r5)     // Catch: java.lang.StringIndexOutOfBoundsException -> L7f
            r2.putExtra(r3, r4)     // Catch: java.lang.StringIndexOutOfBoundsException -> L7f
        L5f:
            java.lang.String r2 = "vcf"
            android.net.Uri r0 = com.sec.chaton.p021g.C0757f.m3253a(r1, r0, r2)
            if (r0 == 0) goto L98
            java.lang.String r1 = r0.toString()
            boolean r1 = r7.m3252a(r1)
            if (r1 == 0) goto L8a
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME
        L73:
            return r0
        L74:
            r0 = move-exception
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME
            goto L73
        L78:
            r0 = move-exception
            if (r2 == 0) goto L7e
            r2.close()
        L7e:
            throw r0
        L7f:
            r2 = move-exception
            android.content.Intent r2 = r7.f2770a
            java.lang.String r3 = "sub_content"
            java.lang.String r4 = ""
            r2.putExtra(r3, r4)
            goto L5f
        L8a:
            android.content.Intent r1 = r7.f2770a
            java.lang.String r2 = "download_uri"
            java.lang.String r0 = r0.toString()
            r1.putExtra(r2, r0)
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.FORWARD
            goto L73
        L98:
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME
            goto L73
        L9b:
            r0 = r6
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p021g.C0755d.mo3250a():com.sec.chaton.m");
    }

    /* renamed from: a */
    private boolean m3252a(String str) throws IOException {
        C1048r c1048r = new C1048r();
        if (str == null) {
            str = null;
        } else {
            String[] strArrSplit = str.split("file://");
            if (strArrSplit.length != 1) {
                if (strArrSplit.length != 2) {
                    return false;
                }
                str = strArrSplit[1];
            }
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line + "\n");
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        c1048r.m4044a(sb.toString());
        return c1048r.m4046a();
    }
}
