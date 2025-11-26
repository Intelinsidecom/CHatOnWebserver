package com.sec.chaton.p025d;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.chaton.p035io.entry.GetSnsFriendsList;
import com.sec.chaton.p035io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p035io.entry.inner.GetSnsFriends;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.tellfriends.AbstractC2724aa;
import com.sec.chaton.settings.tellfriends.C2723a;
import com.sec.chaton.settings.tellfriends.C2733aj;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;
import com.sec.chaton.settings.tellfriends.C2831y;
import com.sec.chaton.settings.tellfriends.InterfaceC2726ac;
import com.sec.chaton.settings.tellfriends.InterfaceC2727ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.au */
/* loaded from: classes.dex */
public class C1308au<T extends AbstractC2724aa> implements Handler.Callback {

    /* renamed from: a */
    C1330h f4942a;

    /* renamed from: b */
    C1303ap f4943b;

    /* renamed from: c */
    C1345w f4944c;

    /* renamed from: d */
    InterfaceC1316bb f4945d;

    /* renamed from: e */
    private final Class<T> f4946e;

    /* renamed from: f */
    private Activity f4947f;

    /* renamed from: h */
    private final Handler f4949h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: i */
    private ArrayList<C2723a> f4950i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<String> f4951j = new ArrayList<>();

    /* renamed from: l */
    private long[] f4953l = null;

    /* renamed from: m */
    private InterfaceC2727ad f4954m = new C1310aw(this);

    /* renamed from: n */
    private InterfaceC2726ac f4955n = new C1311ax(this);

    /* renamed from: g */
    private AbstractC2724aa f4948g = m5631d();

    /* renamed from: k */
    private String f4952k = m5637f();

    public C1308au(Activity activity, Class<T> cls) {
        this.f4947f = activity;
        this.f4946e = cls;
        EnumC1313az.m5660a(EnumC1313az.STARTING);
    }

    /* renamed from: a */
    public void m5650a(InterfaceC1316bb interfaceC1316bb) {
        this.f4945d = interfaceC1316bb;
    }

    /* renamed from: d */
    private T m5631d() {
        if (this.f4946e.equals(C2733aj.class)) {
            return new C2733aj(this.f4947f);
        }
        if (this.f4946e.equals(C2737an.class)) {
            return new C2737an(this.f4947f);
        }
        if (this.f4946e.equals(C2739ap.class)) {
            return new C2739ap(this.f4947f);
        }
        if (this.f4946e.equals(C2735al.class)) {
            return new C2735al(this.f4947f);
        }
        return null;
    }

    /* renamed from: e */
    private EnumC1315ba m5634e() {
        if (this.f4948g instanceof C2733aj) {
            return EnumC1315ba.FACEBOOK_TYPE;
        }
        if (this.f4948g instanceof C2737an) {
            return EnumC1315ba.TWITTER_TYPE;
        }
        if (this.f4948g instanceof C2739ap) {
            return EnumC1315ba.WEIBO_TYPE;
        }
        if (this.f4948g instanceof C2735al) {
            return EnumC1315ba.RENREN_TYPE;
        }
        return EnumC1315ba.NONE_TYPE;
    }

    /* renamed from: f */
    private String m5637f() {
        if (this.f4948g instanceof C2733aj) {
            return C2831y.f10362a;
        }
        if (this.f4948g instanceof C2737an) {
            return C2831y.f10363b;
        }
        if (this.f4948g instanceof C2739ap) {
            return C2831y.f10364c;
        }
        if (this.f4948g instanceof C2735al) {
            return C2831y.f10365d;
        }
        return "";
    }

    /* renamed from: a */
    public void m5648a() {
        m5639g();
    }

    /* renamed from: g */
    private void m5639g() {
        if (!this.f4948g.mo9774d()) {
            EnumC1313az.m5660a(EnumC1313az.SKIPING_SMS);
            this.f4948g.mo9771a(new C1309av(this));
        }
    }

    /* renamed from: b */
    public void m5651b() {
        switch (C1312ay.f4959a[EnumC1313az.m5659a().ordinal()]) {
            case 1:
                m5648a();
                break;
            case 2:
                m5639g();
                break;
            case 3:
                m5645l();
                break;
            case 4:
                m5652c();
                break;
            case 5:
                m5644k();
                break;
            case 6:
                m5646m();
                break;
        }
    }

    /* renamed from: c */
    public void m5652c() {
        EnumC1313az.m5660a(EnumC1313az.SYNCING_FRIENDS);
        switch (C1312ay.f4960b[m5634e().ordinal()]) {
            case 1:
            case 2:
                this.f4948g.mo9770a(this.f4954m);
                break;
            case 3:
            case 4:
                this.f4948g.mo9769a(this.f4955n);
                break;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 204:
                return m5635e((C0267d) message.obj);
            case 311:
                return m5628b((C0267d) message.obj);
            case 313:
                return m5633d((C0267d) message.obj);
            case 314:
                return m5630c((C0267d) message.obj);
            case 402:
                return m5625a((C0274k) message.obj);
            case HttpResponseCode.NOT_FOUND /* 404 */:
                return m5624a((C0267d) message.obj);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private boolean m5624a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            m5652c();
            return true;
        }
        m5652c();
        return true;
    }

    /* renamed from: a */
    private boolean m5625a(C0274k c0274k) {
        if (c0274k.f858a) {
            m5642i();
            return true;
        }
        m5652c();
        return true;
    }

    /* renamed from: b */
    private boolean m5628b(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            m5622a(1301);
            return true;
        }
        m5622a(1302);
        return true;
    }

    /* renamed from: c */
    private boolean m5630c(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m1351b() != EnumC1587o.NO_CONTENT) {
                ArrayList<GetSnsFriends> arrayList = ((GetSnsFriendsList) c0267d.m1354e()).sns;
                if (arrayList.size() > 0) {
                    this.f4951j.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            this.f4951j.add(arrayList.get(i2).userid);
                            i = i2 + 1;
                        } else {
                            m5646m();
                            return true;
                        }
                    }
                } else {
                    m5622a(1301);
                    return true;
                }
            } else {
                m5622a(1301);
                return true;
            }
        } else {
            m5622a(1302);
            return true;
        }
    }

    /* renamed from: d */
    private boolean m5633d(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            C2831y.m10064a(CommonApplication.m11493l()).m10066a(this.f4952k, true);
            m5644k();
        } else {
            m5622a(1302);
        }
        return true;
    }

    /* renamed from: e */
    private boolean m5635e(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0267d.m1354e();
            if (TextUtils.isEmpty(skipSMSVerifyServer.uid) || TextUtils.isEmpty(skipSMSVerifyServer.chatonid)) {
                m5622a(1303);
                if (C3250y.f11737e) {
                    C3250y.m11442a("Uid " + skipSMSVerifyServer.uid + " ChatONID " + skipSMSVerifyServer.chatonid, getClass().getSimpleName());
                    return true;
                }
                return true;
            }
            m5641h();
            return true;
        }
        m5622a(1302);
        return true;
    }

    /* renamed from: h */
    private void m5641h() {
        if (this.f4944c == null) {
            this.f4944c = new C1345w(this.f4949h);
        }
        EnumC1313az.m5660a(EnumC1313az.PROFILE_UPLOADING);
        this.f4944c.m5933b(this.f4948g.mo9766a(true));
    }

    /* renamed from: i */
    private void m5642i() {
        if (this.f4944c == null) {
            this.f4944c = new C1345w(this.f4949h);
        }
        this.f4944c.m5935c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5643j() {
        if (this.f4942a == null) {
            this.f4942a = new C1330h(this.f4949h);
        }
        this.f4942a.m5724a(this.f4952k, this.f4948g.mo9773c());
    }

    /* renamed from: k */
    private void m5644k() {
        if (this.f4942a == null) {
            this.f4942a = new C1330h(this.f4949h);
        }
        EnumC1313az.m5660a(EnumC1313az.RETRIEVING_FRIENDS);
        this.f4942a.m5725a(this.f4952k, this.f4953l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5645l() {
        if (this.f4943b == null) {
            this.f4943b = new C1303ap(this.f4949h);
        }
        EnumC1313az.m5660a(EnumC1313az.SKIPING_SMS);
        this.f4943b.m5598a(this.f4948g.mo9772b());
    }

    /* renamed from: m */
    private void m5646m() {
        if (this.f4942a == null) {
            this.f4942a = new C1330h(this.f4949h);
        }
        EnumC1313az.m5660a(EnumC1313az.ADDING_BUDDIES);
        this.f4942a.m5726a(this.f4951j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5622a(int i) {
        if (this.f4945d != null) {
            this.f4945d.mo5670a(i, EnumC1313az.m5659a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public long[] m5647n() {
        long[] jArr = new long[this.f4950i.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4950i.size()) {
                jArr[i2] = Long.parseLong(this.f4950i.get(i2).m9764a());
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* renamed from: a */
    public void m5649a(int i, int i2, Intent intent) {
        switch (i) {
            case 32665:
                this.f4948g.mo9768a(i, i2, intent);
                m5645l();
                break;
        }
    }
}
