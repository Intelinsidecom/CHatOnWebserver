package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetLiveGroupFollowerList;
import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import java.util.Iterator;

/* compiled from: GetLiveGroupFollowerTask.java */
/* renamed from: com.sec.chaton.d.a.bx */
/* loaded from: classes.dex */
public class C1951bx extends AbstractC1900a {
    public C1951bx(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetLiveGroupFollowerList getLiveGroupFollowerList = (GetLiveGroupFollowerList) c0778b.m3110e();
            C4904y.m18646e("timestamp : " + getLiveGroupFollowerList.timestamp.longValue(), getClass().getSimpleName());
            Iterator<LiveGroupFollower> it = getLiveGroupFollowerList.follower.iterator();
            while (it.hasNext()) {
                LiveGroupFollower next = it.next();
                C4904y.m18646e("NO : " + next.chatonid + ", Name : " + next.name + ", msgstatus : " + next.msgstatus, getClass().getSimpleName());
            }
        }
    }
}
