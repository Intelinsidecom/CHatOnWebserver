package com.sec.chaton.p055d.p056a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.sec.chaton.p046a.C0858cl;
import com.sec.chaton.p046a.C0861co;
import com.sec.chaton.p046a.C0862cp;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.C0867cu;
import com.sec.chaton.p046a.p047a.C0786j;
import com.sec.chaton.p046a.p047a.EnumC0791o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p063i.p064a.C2405b;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ForwardStoredMessageTask.java */
/* renamed from: com.sec.chaton.d.a.bb */
/* loaded from: classes.dex */
public class C1929bb extends AbstractC1927b {

    /* renamed from: h */
    C0864cr f7195h;

    /* renamed from: i */
    private String f7196i;

    /* renamed from: j */
    private String f7197j;

    /* renamed from: k */
    private EnumC2300t f7198k;

    /* renamed from: l */
    private C0858cl f7199l;

    /* renamed from: m */
    private ContentResolver f7200m;

    /* renamed from: n */
    private int f7201n;

    /* renamed from: o */
    private boolean f7202o;

    /* renamed from: p */
    private boolean f7203p;

    public C1929bb(Handler handler, String str, C0858cl c0858cl, C2142w c2142w) {
        super(handler);
        this.f7201n = 0;
        this.f7202o = false;
        this.f7203p = false;
        this.f7196i = str;
        this.f7199l = c0858cl;
        this.f7200m = CommonApplication.m18732r().getContentResolver();
        this.f7191g = c2142w;
        this.f7201n = 0;
        this.f7195h = null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() throws JSONException {
        boolean z;
        String strM9657p = this.f7196i;
        if (this.f7191g.m9654m()) {
            strM9657p = this.f7191g.m9657p();
        }
        C2201o c2201oM9951e = C2198l.m9951e(this.f7200m, strM9657p);
        if (c2201oM9951e == null) {
            C4904y.m18634a("Error - InBoxData does not exist.", "ForwardStoredMessageTask");
            return null;
        }
        this.f7198k = EnumC2300t.m10207a(c2201oM9951e.f7840c);
        this.f7197j = this.f7199l.m4034d();
        ArrayList<C0867cu> arrayList = new ArrayList();
        ArrayList<C0864cr> arrayList2 = new ArrayList();
        ArrayList<C0864cr> arrayList3 = new ArrayList<>();
        ArrayList<C0864cr> arrayList4 = new ArrayList<>();
        ArrayList<C1739gl> arrayList5 = new ArrayList<>();
        C0864cr c0864cr = null;
        ArrayList<Long> arrayList6 = new ArrayList<>();
        this.f7203p = this.f7199l.m4038h();
        C1734gg.m8595a(this.f7196i, this.f7199l, "ForwardStoredMessageTask");
        C0862cp c0862cpM4114a = C0861co.newBuilder().m4119a(C4809aa.m18104a().m18121a("uid", "")).m4122b(C4822an.m18228d()).m4125c(this.f7197j).m4114a(100);
        if (!TextUtils.isEmpty(this.f7199l.m4040j())) {
            c0862cpM4114a.m4127d(this.f7199l.m4040j());
            this.f7202o = true;
        }
        if (this.f7202o || this.f7203p) {
            z = false;
        } else {
            C4904y.m18639b("isFirstMsgOfFullMsg == true : isNeedNextPagination(" + this.f7202o + "), hasMoreResult(" + this.f7203p + ")", getClass().getSimpleName());
            z = true;
        }
        C2405b c2405b = new C2405b();
        c2405b.m19139c(String.format("%04d%s", 36, "0001"));
        StringBuilder sb = new StringBuilder();
        for (C0864cr c0864cr2 : this.f7199l.m4035e()) {
            arrayList2.add(c0864cr2);
            if (c0864cr2.m4160n().getNumber() == 6) {
                arrayList6.add(Long.valueOf(c0864cr2.m4154h()));
                if (C4904y.f17872b) {
                    C4904y.m18639b("withdraw message : id(" + c0864cr2.m4154h() + ")", "ForwardStoredMessageTask");
                }
            }
            sb.append(c0864cr2.m4154h()).append(", ");
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        c2405b.m10432a(sb.toString());
        Log.wtf("CH", c2405b.toString());
        C1736gi.m8648b(arrayList2);
        int i = 0;
        for (C0864cr c0864cr3 : arrayList2) {
            C1758hd c1758hdM8716a = C1756hb.m8715a().m8716a(true, c0864cr3, strM9657p, this.f7197j, this.f7198k, arrayList3, arrayList4, arrayList, arrayList5, arrayList6);
            if (c1758hdM8716a.f6600c) {
                this.f7201n++;
            }
            C0864cr c0864cr4 = (c0864cr == null && c1758hdM8716a.f6598a) ? c0864cr3 : c0864cr;
            if (c1758hdM8716a.f6599b) {
                this.f7195h = c0864cr3;
            }
            i = c1758hdM8716a.f6601d + i;
            c0864cr = c0864cr4;
        }
        C1736gi.m8647b(this.f7196i, arrayList5);
        C1756hb.m8715a().m8718a(strM9657p, 0, this.f7195h, c2201oM9951e);
        C1756hb.m8715a().m8723a(z, arrayList3, strM9657p);
        C2142w c2142wM9593a = C2142w.m9593a(this.f7196i, this.f7198k);
        if (c2142wM9593a != null && c2201oM9951e.f7859v != EnumC2301u.LIVE.m10212a()) {
            c2142wM9593a.mo9227a(this.f7198k, this.f7197j);
        }
        C1756hb.m8715a().m8721a(arrayList4);
        C2405b c2405b2 = new C2405b();
        c2405b2.m19139c(String.format("%04d%s", 37, "0001"));
        StringBuilder sb2 = new StringBuilder();
        for (C0867cu c0867cu : arrayList) {
            c0862cpM4114a.m4118a(c0867cu);
            sb2.append(c0867cu.m4208h()).append(", ");
        }
        if (sb2.length() > 2) {
            sb2.setLength(sb2.length() - 2);
        }
        c2405b2.m10432a(sb2.toString());
        Log.wtf("CH", c2405b2.toString());
        C1734gg.m8596a(this.f7196i, c0862cpM4114a.build(), "ForwardStoredMessageTask");
        C2417af.m10449a(this.f7187c, new C2427ap().m10517a(37).m10519a(c0862cpM4114a.build()).m10522b());
        if (this.f7191g.m9654m()) {
            new Handler().postDelayed(new RunnableC1930bc(this), 2000L);
        }
        C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7196i}));
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0861co c0861co = (C0861co) ((C2426ao) obj2).m10513c();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < c0861co.m4093i().size(); i2++) {
                sb.append("[" + i2 + "] MsgID : " + c0861co.m4085a(i2).m4208h()).append(", MsgType : " + c0861co.m4085a(i2).m4212l()).append(", Receiver : " + c0861co.m4085a(i2).m4206f()).append(", Sender : " + c0861co.m4085a(i2).m4204d());
            }
            C4904y.m18641c("[ForwardStoredMessageReply]InboxNO : " + this.f7196i + ", UID : " + C4809aa.m18104a().m18121a("uid", "") + ", ForwardStoredMessageReplyItemsCount : " + c0861co.m4094j() + sb.toString(), getClass().getSimpleName());
        } else {
            C4904y.m18641c(Config.EXTRA_ERROR, getClass().getSimpleName());
        }
        Message message = new Message();
        message.what = 36;
        C0786j c0786jM3143a = new C0786j().m3145a(true).m3144a(this.f7199l.m4034d()).m3142a(EnumC0791o.SUCCESS).m3141a(this.f7201n).m3148c(this.f7195h == null ? null : this.f7195h.m4156j()).m3146b(this.f7195h == null ? null : C2176ab.m9697g(CommonApplication.m18732r().getContentResolver(), this.f7195h.m4150d())).m3143a(this.f7195h != null ? C2204r.m10020a(this.f7195h.m4156j(), this.f7195h.m4160n().getNumber()) : null);
        if (this.f7199l.m4037g()) {
            c0786jM3143a.m3147b(this.f7199l.m4038h());
        } else {
            c0786jM3143a.m3147b(false);
        }
        message.obj = c0786jM3143a.m3140a();
        this.f7186b.sendMessage(message);
    }
}
