package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.inner.MsgTid;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.List;

/* compiled from: SetAnsNotiReadMessage.java */
/* renamed from: com.sec.chaton.d.a.do */
/* loaded from: classes.dex */
public class C1241do extends AbstractC1145a {

    /* renamed from: b */
    private List<MsgTid> f4804b;

    /* renamed from: c */
    private long f4805c;

    /* renamed from: e */
    private String f4806e;

    public C1241do(Handler handler, C1580h c1580h, List<MsgTid> list, long j, String str) {
        super(handler, c1580h);
        this.f4804b = list;
        this.f4805c = j;
        this.f4806e = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        if (this.f4804b == null || this.f4804b.size() == 0) {
            m11680p();
            return "";
        }
        String strM11026a = new C3164af().m11026a(this.f4804b);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            if (this.f4805c != 0) {
                C3159aa.m10965a("get_all_unread_message_timestamp", Long.valueOf(this.f4805c));
            }
            C3159aa.m10966a("get_all_unread_message_nextstartkey", this.f4806e);
            if (C3250y.f11734b) {
                C3250y.m11450b("get_all_unread_message_timestamp : " + Long.toString(this.f4805c) + ", get_all_unread_message_nextstartkey : " + this.f4806e, getClass().getSimpleName());
            }
            if (!TextUtils.isEmpty(this.f4806e)) {
                C1335m.m5781a((Handler) null);
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000006", "1003", c0267d);
        }
    }
}
