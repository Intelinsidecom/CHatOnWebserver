package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.util.C4904y;

/* compiled from: DeliveryChatTask.java */
/* renamed from: com.sec.chaton.d.a.as */
/* loaded from: classes.dex */
class RunnableC1919as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC2214ab f7156a;

    /* renamed from: b */
    final /* synthetic */ long f7157b;

    /* renamed from: c */
    final /* synthetic */ Handler f7158c;

    /* renamed from: d */
    final /* synthetic */ String f7159d;

    /* renamed from: e */
    final /* synthetic */ String f7160e;

    /* renamed from: f */
    final /* synthetic */ EnumC2300t f7161f;

    /* renamed from: g */
    final /* synthetic */ String f7162g;

    /* renamed from: h */
    final /* synthetic */ String f7163h;

    /* renamed from: i */
    final /* synthetic */ String f7164i;

    /* renamed from: j */
    final /* synthetic */ C1917aq f7165j;

    RunnableC1919as(C1917aq c1917aq, EnumC2214ab enumC2214ab, long j, Handler handler, String str, String str2, EnumC2300t enumC2300t, String str3, String str4, String str5) {
        this.f7165j = c1917aq;
        this.f7156a = enumC2214ab;
        this.f7157b = j;
        this.f7158c = handler;
        this.f7159d = str;
        this.f7160e = str2;
        this.f7161f = enumC2300t;
        this.f7162g = str3;
        this.f7163h = str4;
        this.f7164i = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7156a == EnumC2214ab.IMAGE) {
            if (!C2434a.m10540a().m10543a(this.f7157b, true)) {
                C2434a.m10540a().m10541a(null, null, this.f7158c, 0, this.f7159d, true, this.f7160e, this.f7157b, this.f7156a, this.f7161f, this.f7162g);
            }
        } else if (C2726b.m11429a().m11444b(this.f7160e) && !C2434a.m10540a().m10542a(this.f7157b)) {
            C2434a.m10540a().m10541a(null, null, this.f7158c, 0, this.f7159d, false, this.f7160e, this.f7157b, this.f7156a, this.f7161f, this.f7162g);
        }
        C4904y.m18639b("[Download (URL)] " + this.f7163h, getClass().getName());
        C4904y.m18639b("[Download (FileName)] " + this.f7164i, getClass().getName());
    }
}
