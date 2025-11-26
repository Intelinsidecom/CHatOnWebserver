package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1753gz;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.C0927f;
import com.sec.chaton.p046a.C0935fh;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.C2096bb;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: AllowChatTask.java */
/* renamed from: com.sec.chaton.d.a.h */
/* loaded from: classes.dex */
public class C2049h extends C2055n {

    /* renamed from: h */
    long f7497h;

    /* renamed from: i */
    EnumC2300t f7498i;

    /* renamed from: j */
    String f7499j;

    /* renamed from: k */
    String f7500k;

    /* renamed from: l */
    String f7501l;

    public C2049h(Handler handler, EnumC2300t enumC2300t, String str, String str2, long j, String str3) {
        this(handler, enumC2300t, str, str2, j, str3, EnumC2706n.f9699d);
    }

    public C2049h(Handler handler, EnumC2300t enumC2300t, String str, String str2, long j, String str3, EnumC2706n enumC2706n) {
        super(handler, enumC2706n);
        this.f7498i = enumC2300t;
        this.f7500k = str2;
        this.f7497h = j;
        this.f7499j = str3;
        this.f7501l = str;
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        super.mo9093b();
        C2684ab.m11290a(getClass().getSimpleName(), "onPreExecute()", new Object[0]);
        return C2096bb.m9360a().m9363a(this.f7498i, this.f7501l, this.f7500k, this.f7497h, this.f7499j);
    }

    @Override // com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws Throwable {
        String strM8701a;
        super.mo9092a(i, obj, obj2);
        C2684ab.m11290a(getClass().getSimpleName(), "onPostExecute()", new Object[0]);
        Message message = new Message();
        message.what = 2;
        if (obj2 != null) {
            C0927f c0927f = (C0927f) ((C2426ao) obj2).m10513c();
            if (this.f7498i == EnumC2300t.TOPIC) {
                C2176ab.m9679a(c0927f, this.f7501l, this.f7499j);
            } else {
                C2176ab.m9686b(c0927f, this.f7501l, this.f7499j);
            }
            C1734gg.m8603a(this.f7501l, c0927f, getClass().getSimpleName());
            int iM5229d = c0927f.m5085f().m5229d();
            if (iM5229d == 1000 || iM5229d == 3003) {
                message.obj = new C0788l(true, iM5229d, this.f7501l, this.f7497h);
            } else {
                if (iM5229d == 2006 || iM5229d == 3008) {
                    C2198l.m9909a(CommonApplication.m18732r().getContentResolver(), this.f7501l, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                    strM8701a = null;
                } else if (iM5229d == 3006) {
                    strM8701a = null;
                } else if (iM5229d == 7001) {
                    C1753gz.m8698a().m8706a(this.f7501l, this.f7500k, 0L);
                    strM8701a = null;
                } else {
                    strM8701a = iM5229d == 7002 ? C1753gz.m8698a().m8701a(this.f7186b, this.f7501l, c0927f.m5085f()) : iM5229d == 7003 ? C1753gz.m8698a().m8702a(this.f7501l, c0927f.m5085f()) : null;
                }
                if (!TextUtils.isEmpty(strM8701a)) {
                    this.f7500k = strM8701a;
                }
                message.obj = new C0788l(false, iM5229d, this.f7501l, this.f7497h);
                C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7501l}));
            }
            this.f7186b.sendMessage(message);
            return;
        }
        if (!mo9104a() || i == 11 || i == 22 || i == 3) {
            m9192a(i, this.f7501l);
        }
        if (C4904y.f17873c) {
            C1734gg.m8603a(this.f7501l, C0927f.newBuilder().m5518a(this.f7497h).m5522a(C0935fh.newBuilder().m5252a(i).m5257a("Fail to send allowChat message")).build(), getClass().getSimpleName());
        }
        message.obj = new C0788l(false, i, this.f7501l);
        this.f7186b.sendMessage(message);
    }
}
