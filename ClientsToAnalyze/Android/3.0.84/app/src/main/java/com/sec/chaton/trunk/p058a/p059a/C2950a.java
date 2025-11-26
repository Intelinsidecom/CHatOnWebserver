package com.sec.chaton.trunk.p058a.p059a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.HashMap;

/* compiled from: AddCommentTask.java */
/* renamed from: com.sec.chaton.trunk.a.a.a */
/* loaded from: classes.dex */
public class C2950a extends AbstractC1145a {

    /* renamed from: b */
    private String f10714b;

    /* renamed from: c */
    private String f10715c;

    /* renamed from: e */
    private String f10716e;

    public C2950a(Handler handler, C1580h c1580h, String str, String str2, String str3) {
        super(handler, c1580h);
        this.f10714b = str;
        this.f10715c = str2;
        this.f10716e = str3;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        HashMap map = new HashMap();
        map.put("sessionid", this.f10714b);
        map.put("itemid", this.f10715c);
        map.put("comment", this.f10716e);
        String strM11026a = new C3164af().m11026a((Object) map);
        C3250y.m11456e(strM11026a, this.f11982d);
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() != EnumC1587o.SUCCESS && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000016", "0201", c0267d);
        }
    }
}
