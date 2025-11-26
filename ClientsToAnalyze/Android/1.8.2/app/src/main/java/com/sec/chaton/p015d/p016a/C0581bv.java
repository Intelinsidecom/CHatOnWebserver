package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: UnBlockTask.java */
/* renamed from: com.sec.chaton.d.a.bv */
/* loaded from: classes.dex */
public class C0581bv extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ArrayList f2311d;

    /* renamed from: e */
    private String f2312e;

    public C0581bv(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2312e = str;
    }

    public C0581bv(Handler handler, C0798h c0798h, ArrayList arrayList) {
        super(handler, c0798h);
        this.f2311d = arrayList;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        if (this.f2311d == null || this.f2311d.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<param>");
        Iterator it = this.f2311d.iterator();
        while (it.hasNext()) {
            sb.append("<address id=\"" + ((String) it.next()) + "\" isblock=\"false\"></address>");
        }
        sb.append("</param>");
        return sb.toString();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
            new C0633e(null).m2865a(true);
            new C0633e(null).m2854a(-1, -1);
        }
    }
}
