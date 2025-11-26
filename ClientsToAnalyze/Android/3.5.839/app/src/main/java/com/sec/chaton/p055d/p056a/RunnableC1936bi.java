package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.util.C4904y;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.bi */
/* loaded from: classes.dex */
class RunnableC1936bi implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC2214ab f7212a;

    /* renamed from: b */
    final /* synthetic */ long f7213b;

    /* renamed from: c */
    final /* synthetic */ Handler f7214c;

    /* renamed from: d */
    final /* synthetic */ String f7215d;

    /* renamed from: e */
    final /* synthetic */ String f7216e;

    /* renamed from: f */
    final /* synthetic */ EnumC2300t f7217f;

    /* renamed from: g */
    final /* synthetic */ String f7218g;

    /* renamed from: h */
    final /* synthetic */ String f7219h;

    /* renamed from: i */
    final /* synthetic */ String f7220i;

    /* renamed from: j */
    final /* synthetic */ C1934bg f7221j;

    RunnableC1936bi(C1934bg c1934bg, EnumC2214ab enumC2214ab, long j, Handler handler, String str, String str2, EnumC2300t enumC2300t, String str3, String str4, String str5) {
        this.f7221j = c1934bg;
        this.f7212a = enumC2214ab;
        this.f7213b = j;
        this.f7214c = handler;
        this.f7215d = str;
        this.f7216e = str2;
        this.f7217f = enumC2300t;
        this.f7218g = str3;
        this.f7219h = str4;
        this.f7220i = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7212a == EnumC2214ab.IMAGE) {
            if (!C2434a.m10540a().m10543a(this.f7213b, true)) {
                C2434a.m10540a().m10541a(null, null, this.f7214c, 0, this.f7215d, true, this.f7216e, this.f7213b, this.f7212a, this.f7217f, this.f7218g);
            }
        } else if (C2726b.m11429a().m11444b(this.f7216e) && !C2434a.m10540a().m10542a(this.f7213b)) {
            C2434a.m10540a().m10541a(null, null, this.f7214c, 0, this.f7215d, false, this.f7216e, this.f7213b, this.f7212a, this.f7217f, this.f7218g);
        }
        C4904y.m18639b("[Download (URL)] " + this.f7219h, getClass().getName());
        C4904y.m18639b("[Download (FileName)] " + this.f7220i, getClass().getName());
    }
}
