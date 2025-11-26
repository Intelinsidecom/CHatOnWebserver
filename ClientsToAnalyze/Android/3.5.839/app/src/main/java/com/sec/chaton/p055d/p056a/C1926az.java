package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.C1066bf;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1739gl;
import com.sec.chaton.chat.C1756hb;
import com.sec.chaton.chat.C1758hd;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.C0852cf;
import com.sec.chaton.p046a.C0855ci;
import com.sec.chaton.p046a.C0856cj;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.C0867cu;
import com.sec.chaton.p046a.p047a.C0786j;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p063i.p064a.C2405b;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.qmlog.C3122d;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ForwardOnlineMessageTask.java */
/* renamed from: com.sec.chaton.d.a.az */
/* loaded from: classes.dex */
public class C1926az extends AbstractC1927b {

    /* renamed from: h */
    C0864cr f7178h;

    /* renamed from: i */
    private String f7179i;

    /* renamed from: j */
    private String f7180j;

    /* renamed from: k */
    private EnumC2300t f7181k;

    /* renamed from: l */
    private C0852cf f7182l;

    /* renamed from: m */
    private ContentResolver f7183m;

    /* renamed from: n */
    private int f7184n;

    public C1926az(Handler handler, String str, C0852cf c0852cf, C2142w c2142w) {
        super(handler);
        this.f7184n = 0;
        this.f7179i = str;
        this.f7182l = c0852cf;
        this.f7183m = CommonApplication.m18732r().getContentResolver();
        this.f7191g = c2142w;
        this.f7184n = 0;
        this.f7178h = null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws JSONException {
        String strM9657p = this.f7191g.m9654m() ? this.f7191g.m9657p() : this.f7179i;
        C2201o c2201oM9951e = C2198l.m9951e(this.f7183m, strM9657p);
        if (c2201oM9951e == null) {
            C4904y.m18634a("Error - InBoxData does not exist.", "ForwardOnlineMessageTask");
            return null;
        }
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3122d.m12732a().m12747a(EnumC3124f.RECEIVE, this.f7182l.m3934f().m4154h(), this.f7182l.m3934f().m4156j().length(), this.f7182l.m3934f().m4158l(), System.currentTimeMillis());
        }
        this.f7181k = EnumC2300t.m10207a(c2201oM9951e.f7840c);
        this.f7180j = this.f7182l.m3932d();
        ArrayList<C0867cu> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<C0864cr> arrayList3 = new ArrayList<>();
        ArrayList<C0864cr> arrayList4 = new ArrayList<>();
        ArrayList<C1739gl> arrayList5 = new ArrayList<>();
        ArrayList<Long> arrayList6 = new ArrayList<>();
        C1734gg.m8593a(this.f7179i, this.f7182l, "ForwardOnlineMessageTask");
        C0856cj c0856cjM4012c = C0855ci.newBuilder().m4005a(C4809aa.m18104a().m18121a("uid", "")).m4009b(C4822an.m18228d()).m4012c(this.f7180j);
        C2405b c2405b = new C2405b();
        c2405b.m19139c(String.format("%04d%s", 34, "0001"));
        StringBuilder sb = new StringBuilder();
        arrayList2.add(this.f7182l.m3934f());
        sb.append(this.f7182l.m3934f().m4154h()).append(", ");
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        c2405b.m10432a(sb.toString());
        Log.wtf("CH", c2405b.toString());
        C1736gi.m8648b(arrayList2);
        if (C2349a.m10301a("active_connection_feature")) {
            if (C4904y.f17873c) {
                C4904y.m18641c("ForwardOnlineMessage.hasIsActiveForward() : " + this.f7182l.m3935g(), "ForwardOnlineMessageTask");
            }
            if (this.f7182l.m3935g()) {
                C1756hb.m8715a().m8722a(this.f7182l.m3936h());
                if (C4904y.f17873c) {
                    C4904y.m18641c("ForwardOnlineMessage.getIsActiveForward() : " + this.f7182l.m3936h(), "ForwardOnlineMessageTask");
                }
            }
        }
        C0864cr c0864crM3934f = this.f7182l.m3934f();
        C1758hd c1758hdM8716a = C1756hb.m8715a().m8716a(false, c0864crM3934f, strM9657p, this.f7180j, this.f7181k, arrayList3, arrayList4, arrayList, arrayList5, arrayList6);
        if (c1758hdM8716a.f6600c) {
            this.f7184n++;
        }
        if (0 != 0 || c1758hdM8716a.f6598a) {
        }
        if (c1758hdM8716a.f6599b) {
            this.f7178h = c0864crM3934f;
        }
        int i = c1758hdM8716a.f6601d + 0;
        C1736gi.m8647b(this.f7179i, arrayList5);
        C1756hb.m8715a().m8718a(strM9657p, i, this.f7178h, c2201oM9951e);
        if (this.f7184n > 0) {
            C1756hb.m8715a().m8719a(strM9657p, this.f7181k, this.f7180j, this.f7178h);
        }
        C1756hb.m8715a().m8723a(true, arrayList3, strM9657p);
        C1756hb.m8715a().m8724a(false, arrayList, this.f7181k, this.f7180j, this.f7179i);
        C2405b c2405b2 = new C2405b();
        c2405b2.m19139c(String.format("%04d%s", 35, "0001"));
        StringBuilder sb2 = new StringBuilder();
        for (C0867cu c0867cu : arrayList) {
            c0856cjM4012c.m4004a(c0867cu);
            sb2.append(c0867cu.m4208h()).append(", ");
        }
        if (sb2.length() > 2) {
            sb2.setLength(sb2.length() - 2);
        }
        c2405b2.m10432a(sb2.toString());
        Log.wtf("CH", c2405b2.toString());
        C1734gg.m8594a(this.f7179i, c0856cjM4012c.build(), "ForwardOnlineMessageTask");
        C2417af.m10449a(this.f7187c, new C2427ap().m10517a(35).m10519a(c0856cjM4012c.build()).m10522b());
        if (this.f7191g.m9654m()) {
            new Handler().postDelayed(new RunnableC1928ba(this), 2000L);
        }
        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7179i}));
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0855ci c0855ci = (C0855ci) ((C2426ao) obj2).m10513c();
            StringBuilder sb = new StringBuilder();
            sb.append("MsgID : " + c0855ci.m3986j().m4208h()).append(", MsgType : " + c0855ci.m3986j().m4212l()).append(", Receiver : " + c0855ci.m3986j().m4206f()).append(", Sender : " + c0855ci.m3986j().m4204d());
            C4904y.m18641c("[ForwardOnlineMessageReply]InboxNO : " + this.f7179i + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + sb.toString(), getClass().getSimpleName());
        } else {
            C4904y.m18641c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 34;
        message.obj = new C0786j().m3145a(true).m3144a(this.f7182l.m3932d()).m3142a(EnumC0791o.SUCCESS).m3141a(this.f7184n).m3148c(this.f7178h == null ? null : this.f7178h.m4156j()).m3146b(this.f7178h == null ? null : C2176ab.m9697g(CommonApplication.m18732r().getContentResolver(), this.f7178h.m4150d())).m3143a(this.f7178h != null ? C2204r.m10020a(this.f7178h.m4156j(), this.f7178h.m4160n().getNumber()) : null).m3140a();
        this.f7186b.sendMessage(message);
    }
}
