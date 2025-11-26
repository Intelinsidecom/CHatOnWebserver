package com.sec.chaton.p074l;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.p126d.p127a.p128a.C4977a;
import com.sec.common.p126d.p127a.p128a.C4979c;
import com.sec.common.p131f.C4999c;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

/* compiled from: GetChatProfileWorker.java */
/* renamed from: com.sec.chaton.l.f */
/* loaded from: classes.dex */
class CallableC2488f implements InterfaceC2493k, Callable<Bitmap> {

    /* renamed from: a */
    private Context f8924a;

    /* renamed from: b */
    private String f8925b;

    /* renamed from: c */
    private String f8926c;

    /* renamed from: d */
    private EnumC2508z f8927d;

    public CallableC2488f(Context context, String str, String str2, EnumC2508z enumC2508z) {
        this.f8924a = context;
        this.f8925b = str;
        this.f8926c = str2;
        this.f8927d = enumC2508z;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws Throwable {
        File fileM10771b = C2496n.m10771b(this.f8924a, this.f8925b);
        if (fileM10771b.exists()) {
            if (fileM10771b.length() == 0) {
                return C2496n.f8946a;
            }
            return new C4999c().m18976a(fileM10771b).m18969a();
        }
        if (!TextUtils.isEmpty(this.f8926c)) {
            String strM10731a = m10731a(this.f8926c);
            if (!TextUtils.isEmpty(strM10731a)) {
                File file = new File(C2496n.m10755a(this.f8924a), strM10731a);
                if (file.exists() && file.length() != 0) {
                    return new C4999c().m18976a(file).m18969a();
                }
            }
        }
        String strM10733c = m10733c();
        String strM10732b = m10732b(strM10733c);
        if (!TextUtils.isEmpty(strM10732b)) {
            String strM18450b = C4865cc.m18450b(EnumC4868cf.FILE);
            if (TextUtils.isEmpty(strM18450b)) {
                throw new IOException("contact server address is invalid.");
            }
            String str = strM18450b + "/file/image/" + m10734c(strM10733c);
            String strM19199a = C5052r.m19199a("imei", "=", C4822an.m18228d(), "&", "filename", "=", strM10732b);
            C4977a c4977a = new C4977a();
            c4977a.m18930a(EnumC4988d.GET);
            c4977a.mo10630a(str);
            c4977a.m18935b("uid", C4809aa.m18104a().m18121a("uid", ""));
            c4977a.m18935b("param", m10735d(strM19199a));
            c4977a.m18935b("r", String.valueOf(System.currentTimeMillis()));
            c4977a.m18898a(fileM10771b);
            c4977a.m18899c(true);
            if (new C4979c(c4977a).call().m18953m() == 204) {
                return C2496n.f8946a;
            }
            return new C4999c().m18976a(fileM10771b).m18975a(Bitmap.Config.RGB_565).m18969a();
        }
        return null;
    }

    @Override // com.sec.chaton.p074l.InterfaceC2493k
    /* renamed from: b */
    public int mo10714b() {
        return this.f8927d.m10808a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(InterfaceC2493k interfaceC2493k) {
        long jMo10714b = mo10714b() - interfaceC2493k.mo10714b();
        if (jMo10714b < 0) {
            return -1;
        }
        if (jMo10714b == 0) {
            return 0;
        }
        return 1;
    }

    /* renamed from: a */
    private String m10731a(String str) {
        return URLEncoder.encode(C2191e.m9868e(this.f8924a.getContentResolver(), this.f8926c) + "_group_profile.png_", "UTF-8");
    }

    /* renamed from: b */
    private String m10732b(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("&filename=")) == null || strArrSplit.length <= 1) ? "" : strArrSplit[1];
    }

    /* renamed from: c */
    private String m10734c(String str) {
        String[] strArrSplit = str.split("/");
        if (strArrSplit != null) {
            for (int i = 0; i < strArrSplit.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].equals(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) && strArrSplit.length > i) {
                    return strArrSplit[i + 1];
                }
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002c A[DONT_GENERATE, PHI: r2
  0x002c: PHI (r2v2 java.lang.String) = (r2v0 java.lang.String), (r2v3 java.lang.String) binds: [B:13:0x0037, B:6:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m10733c() {
        /*
            r7 = this;
            r2 = 0
            android.content.Context r0 = r7.f8924a
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.f8209a
            java.lang.String r3 = "inbox_no=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = r7.f8925b
            r4[r5] = r6
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L37
            java.lang.String r0 = "profile_url"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L2f
        L2c:
            r1.close()
        L2f:
            return r2
        L30:
            r0 = move-exception
            if (r1 == 0) goto L36
            r1.close()
        L36:
            throw r0
        L37:
            if (r1 == 0) goto L2f
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p074l.CallableC2488f.m10733c():java.lang.String");
    }

    /* renamed from: d */
    private String m10735d(String str) throws IOException {
        try {
            String strM18595a = GlobalApplication.m10284c().m18595a();
            if (TextUtils.isEmpty(strM18595a)) {
                throw new IOException("Fail in getting a key");
            }
            String strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(str.getBytes()));
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("paramBefore: " + str, ", paramAfter: ", strM18098a), "GetChatProfileWorker");
            }
            return strM18098a;
        } catch (Exception e) {
            throw new IOException("Encryption Error");
        }
    }
}
