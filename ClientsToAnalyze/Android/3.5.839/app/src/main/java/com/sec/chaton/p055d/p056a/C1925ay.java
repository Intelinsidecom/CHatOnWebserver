package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: FollowSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ay */
/* loaded from: classes.dex */
public class C1925ay extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7174b = C1925ay.class.getSimpleName();

    /* renamed from: c */
    private String f7175c;

    /* renamed from: d */
    private boolean f7176d;

    /* renamed from: e */
    private Handler f7177e;

    public C1925ay(Handler handler, C2454e c2454e, String str, boolean z) {
        this(handler, c2454e, str);
        this.f7176d = z;
        this.f7177e = handler;
    }

    public C1925ay(Handler handler, C2454e c2454e, String str) {
        super(c2454e);
        this.f7176d = false;
        this.f7175c = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("specialuserid", this.f7175c);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4904y.m18639b("success() Livepartner ID : " + this.f7175c, f7174b);
            if (this.f7176d) {
                new C2128i(this.f7177e).m9515c();
                return;
            } else {
                new C2128i(null).m9515c();
                return;
            }
        }
        C4904y.m18639b("fail() Livepartner ID  : " + this.f7175c, f7174b);
    }
}
