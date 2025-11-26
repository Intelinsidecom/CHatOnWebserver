package com.sec.chaton.chat;

import android.os.Handler;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.util.C4904y;

/* compiled from: ForwardMessageHandler.java */
/* renamed from: com.sec.chaton.chat.hc */
/* loaded from: classes.dex */
class RunnableC1757hc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC2214ab f6588a;

    /* renamed from: b */
    final /* synthetic */ long f6589b;

    /* renamed from: c */
    final /* synthetic */ Handler f6590c;

    /* renamed from: d */
    final /* synthetic */ String f6591d;

    /* renamed from: e */
    final /* synthetic */ String f6592e;

    /* renamed from: f */
    final /* synthetic */ EnumC2300t f6593f;

    /* renamed from: g */
    final /* synthetic */ String f6594g;

    /* renamed from: h */
    final /* synthetic */ String f6595h;

    /* renamed from: i */
    final /* synthetic */ String f6596i;

    /* renamed from: j */
    final /* synthetic */ C1756hb f6597j;

    RunnableC1757hc(C1756hb c1756hb, EnumC2214ab enumC2214ab, long j, Handler handler, String str, String str2, EnumC2300t enumC2300t, String str3, String str4, String str5) {
        this.f6597j = c1756hb;
        this.f6588a = enumC2214ab;
        this.f6589b = j;
        this.f6590c = handler;
        this.f6591d = str;
        this.f6592e = str2;
        this.f6593f = enumC2300t;
        this.f6594g = str3;
        this.f6595h = str4;
        this.f6596i = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6588a == EnumC2214ab.IMAGE) {
            if (!C2434a.m10540a().m10543a(this.f6589b, true)) {
                C2434a.m10540a().m10541a(null, null, this.f6590c, 0, this.f6591d, true, this.f6592e, this.f6589b, this.f6588a, this.f6593f, this.f6594g);
            }
        } else if (C2726b.m11429a().m11444b(this.f6592e) && !C2434a.m10540a().m10542a(this.f6589b)) {
            C2434a.m10540a().m10541a(null, null, this.f6590c, 0, this.f6591d, false, this.f6592e, this.f6589b, this.f6588a, this.f6593f, this.f6594g);
        }
        C4904y.m18639b("[Download (URL)] " + this.f6595h, getClass().getName());
        C4904y.m18639b("[Download (FileName)] " + this.f6596i, getClass().getName());
    }
}
