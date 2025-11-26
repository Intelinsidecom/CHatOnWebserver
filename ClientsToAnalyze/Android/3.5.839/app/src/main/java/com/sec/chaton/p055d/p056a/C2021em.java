package com.sec.chaton.p055d.p056a;

import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.inner.MsgTid;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.List;

/* compiled from: SetAnsNotiReadMessage.java */
/* renamed from: com.sec.chaton.d.a.em */
/* loaded from: classes.dex */
public class C2021em extends AbstractC1900a {

    /* renamed from: b */
    private List<MsgTid> f7419b;

    /* renamed from: c */
    private long f7420c;

    /* renamed from: d */
    private String f7421d;

    public C2021em(C2454e c2454e, List<MsgTid> list, long j, String str) {
        super(c2454e);
        this.f7419b = list;
        this.f7420c = j;
        this.f7421d = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        if (this.f7419b == null || this.f7419b.size() == 0) {
            m18922l();
            return "";
        }
        String strM18172a = new C4815ag().m18172a(this.f7419b);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            if (this.f7420c != 0) {
                C4809aa.m18107a("get_all_unread_message_timestamp", Long.valueOf(this.f7420c));
            }
            C4809aa.m18108a("get_all_unread_message_nextstartkey", this.f7421d);
            if (C4904y.f17872b) {
                C4904y.m18639b("get_all_unread_message_timestamp : " + Long.toString(this.f7420c) + ", get_all_unread_message_nextstartkey : " + this.f7421d, getClass().getSimpleName());
            }
            if (!TextUtils.isEmpty(this.f7421d)) {
                C2134o.m9567a(null);
                return;
            }
            return;
        }
        C2404a.m10430a("01000006", "1003", c0778b);
    }
}
