package com.sec.chaton.p055d;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0790n;
import com.sec.chaton.p065io.entry.GetSnsFriendsList;
import com.sec.chaton.p065io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p065io.entry.inner.GetSnsFriends;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4364a;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.C4380af;
import com.sec.chaton.sns.p114b.C4382ah;
import com.sec.chaton.sns.p114b.C4384aj;
import com.sec.chaton.sns.p114b.C4386al;
import com.sec.chaton.sns.p114b.C4388an;
import com.sec.chaton.sns.p114b.C4392ar;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.sns.p114b.InterfaceC4441y;
import com.sec.chaton.sns.p114b.InterfaceC4442z;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.bk */
/* loaded from: classes.dex */
public class C2105bk<T extends AbstractC4439w> implements Handler.Callback {

    /* renamed from: a */
    C2128i f7637a;

    /* renamed from: b */
    C2095ba f7638b;

    /* renamed from: c */
    C2075ah f7639c;

    /* renamed from: d */
    InterfaceC2113bs f7640d;

    /* renamed from: e */
    ArrayList<ContentProviderOperation> f7641e;

    /* renamed from: f */
    private final Class<T> f7642f;

    /* renamed from: g */
    private Context f7643g;

    /* renamed from: h */
    private AbstractC4439w f7644h;

    /* renamed from: i */
    private final Handler f7645i;

    /* renamed from: j */
    private ArrayList<C4364a> f7646j;

    /* renamed from: k */
    private ArrayList<String> f7647k;

    /* renamed from: l */
    private String f7648l;

    /* renamed from: m */
    private boolean f7649m;

    /* renamed from: n */
    private long[] f7650n;

    /* renamed from: o */
    private boolean f7651o;

    /* renamed from: p */
    private InterfaceC4442z f7652p;

    /* renamed from: q */
    private InterfaceC4441y f7653q;

    public C2105bk(Context context, Class<T> cls) {
        this.f7646j = new ArrayList<>();
        this.f7647k = new ArrayList<>();
        this.f7650n = null;
        this.f7651o = false;
        this.f7641e = new ArrayList<>();
        this.f7652p = new C2107bm(this);
        this.f7653q = new C2108bn(this);
        this.f7643g = context;
        this.f7642f = cls;
        this.f7649m = false;
        this.f7644h = m9397a(true);
        this.f7648l = m9424a();
        this.f7645i = new Handler(Looper.getMainLooper(), this);
        EnumC2111bq.m9446a(EnumC2111bq.STARTING);
    }

    public C2105bk(Activity activity, Class<T> cls, boolean z) {
        this.f7646j = new ArrayList<>();
        this.f7647k = new ArrayList<>();
        this.f7650n = null;
        this.f7651o = false;
        this.f7641e = new ArrayList<>();
        this.f7652p = new C2107bm(this);
        this.f7653q = new C2108bn(this);
        this.f7643g = activity;
        this.f7642f = cls;
        this.f7649m = z;
        this.f7644h = m9397a(true);
        this.f7648l = m9424a();
        this.f7645i = new Handler(Looper.getMainLooper(), this);
        EnumC2111bq.m9446a(EnumC2111bq.STARTING);
    }

    public C2105bk(Context context, Class<T> cls, boolean z, Looper looper, boolean z2) {
        this.f7646j = new ArrayList<>();
        this.f7647k = new ArrayList<>();
        this.f7650n = null;
        this.f7651o = false;
        this.f7641e = new ArrayList<>();
        this.f7652p = new C2107bm(this);
        this.f7653q = new C2108bn(this);
        this.f7643g = context;
        this.f7642f = cls;
        if (looper != null) {
            this.f7645i = new Handler(looper, this);
        } else {
            this.f7645i = new Handler(Looper.getMainLooper(), this);
        }
        this.f7649m = true;
        this.f7651o = z2;
        this.f7644h = m9397a(z ? false : true);
        this.f7648l = m9424a();
        EnumC2111bq.m9446a(EnumC2111bq.STARTING);
    }

    /* renamed from: a */
    public void m9426a(InterfaceC2113bs interfaceC2113bs) {
        this.f7640d = interfaceC2113bs;
    }

    /* renamed from: a */
    private T m9397a(boolean z) {
        if (this.f7642f.equals(C4380af.class)) {
            return new C4380af(this.f7643g, z);
        }
        if (this.f7642f.equals(C4386al.class)) {
            return new C4386al(this.f7643g);
        }
        if (this.f7642f.equals(C4392ar.class)) {
            return new C4392ar(this.f7643g);
        }
        if (this.f7642f.equals(C4382ah.class)) {
            return new C4382ah(this.f7643g, z);
        }
        if (this.f7642f.equals(C4384aj.class)) {
            return new C4384aj(this.f7643g);
        }
        if (this.f7642f.equals(C4388an.class)) {
            return new C4388an(this.f7643g, z);
        }
        return null;
    }

    /* renamed from: i */
    private EnumC2112br m9414i() {
        if (this.f7644h instanceof C4380af) {
            return EnumC2112br.FACEBOOK_TYPE;
        }
        if (this.f7644h instanceof C4386al) {
            return EnumC2112br.TWITTER_TYPE;
        }
        if (this.f7644h instanceof C4392ar) {
            return EnumC2112br.WEIBO_TYPE;
        }
        if (this.f7644h instanceof C4382ah) {
            return EnumC2112br.ODNOKLASSNIKI_TYPE;
        }
        if (this.f7644h instanceof C4384aj) {
            return EnumC2112br.RENREN_TYPE;
        }
        if (this.f7644h instanceof C4388an) {
            return EnumC2112br.VKONTAKTE_TYPE;
        }
        return EnumC2112br.NONE_TYPE;
    }

    /* renamed from: a */
    public String m9424a() {
        if (this.f7644h instanceof C4380af) {
            return C4368e.f15815a;
        }
        if (this.f7644h instanceof C4386al) {
            return C4368e.f15816b;
        }
        if (this.f7644h instanceof C4392ar) {
            return C4368e.f15817c;
        }
        if (this.f7644h instanceof C4382ah) {
            return C4368e.f15818d;
        }
        if (this.f7644h instanceof C4384aj) {
            return C4368e.f15819e;
        }
        if (this.f7644h instanceof C4388an) {
            return C4368e.f15820f;
        }
        return "";
    }

    /* renamed from: b */
    public String m9427b() {
        return this.f7644h.mo16648c();
    }

    /* renamed from: c */
    public String m9428c() {
        return this.f7644h.mo16647b();
    }

    /* renamed from: d */
    public String m9429d() {
        return this.f7644h.mo16649d();
    }

    /* renamed from: e */
    public void m9430e() {
        m9415j();
    }

    /* renamed from: f */
    public void m9431f() {
        if (this.f7644h.mo16650e()) {
            this.f7644h.mo16642a((InterfaceC4377ac) null);
        }
    }

    /* renamed from: j */
    private void m9415j() {
        if (!this.f7644h.mo16650e()) {
            EnumC2111bq.m9446a(EnumC2111bq.SKIPING_SMS);
            this.f7644h.mo16641a(new C2106bl(this));
        } else {
            EnumC2111bq.m9446a(EnumC2111bq.FINISH_SIGN_IN);
            m9398a(1304);
            m9432g();
        }
    }

    /* renamed from: g */
    public void m9432g() {
        switch (C2109bo.f7657a[EnumC2111bq.m9445a().ordinal()]) {
            case 1:
                m9430e();
                break;
            case 2:
                m9415j();
                break;
            case 3:
                m9421p();
                break;
            case 4:
                m9418m();
                break;
            case 5:
                m9433h();
                break;
            case 6:
                m9420o();
                break;
            case 7:
                m9422q();
                break;
        }
    }

    /* renamed from: h */
    public void m9433h() {
        C4904y.m18639b("syncSnsFriendsWithChatON() for SNS -> " + m9414i().toString(), "SnsAccountControl");
        EnumC2111bq.m9446a(EnumC2111bq.SYNCING_FRIENDS);
        switch (C2109bo.f7658b[m9414i().ordinal()]) {
            case 1:
            case 2:
                this.f7644h.mo16644a(this.f7652p);
                break;
            case 3:
            case 4:
                this.f7644h.mo16643a(this.f7653q);
                break;
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b("Sync Friends: Sync Sns friends with chaton", "SnsAccountControl");
                }
                this.f7644h.mo16644a(this.f7652p);
                break;
            case 6:
                if (C4904y.f17872b) {
                    C4904y.m18639b("Sync Friends: Sync Sns vk friends with chaton", "SnsAccountControl");
                }
                this.f7644h.mo16644a(this.f7652p);
                break;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        C4904y.m18639b("handle message msg: " + message.what, getClass().getSimpleName());
        switch (message.what) {
            case 208:
                return m9410e((C0778b) message.obj);
            case 311:
                return m9405b((C0778b) message.obj);
            case 313:
                return m9409d((C0778b) message.obj);
            case 314:
                return m9407c((C0778b) message.obj);
            case 402:
                return m9402a((C0790n) message.obj);
            case 404:
                return m9401a((C0778b) message.obj);
            default:
                m9398a(1302);
                return false;
        }
    }

    /* renamed from: a */
    private boolean m9401a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            m9433h();
            return true;
        }
        m9433h();
        return true;
    }

    /* renamed from: a */
    private boolean m9402a(C0790n c0790n) {
        m9400a(this.f7644h.mo16638a(true));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public Timestamp m9416k() {
        return new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    /* renamed from: b */
    private boolean m9405b(C0778b c0778b) {
        C4904y.m18639b("completeAddBuddies() for sns type :" + m9424a(), getClass().getSimpleName());
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            m9398a(1301);
            return true;
        }
        m9398a(1302);
        return true;
    }

    /* renamed from: c */
    private boolean m9407c(C0778b c0778b) {
        C4904y.m18639b("completedRetrieveFriends for sns " + m9424a(), getClass().getSimpleName());
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (c0778b.m3107b() != EnumC2464o.NO_CONTENT) {
                ArrayList<GetSnsFriends> arrayList = ((GetSnsFriendsList) c0778b.m3110e()).sns;
                if (arrayList.size() > 0) {
                    this.f7647k.clear();
                    if (this.f7649m) {
                        new AsyncTaskC2110bp(this, null).execute(arrayList);
                    } else {
                        for (int i = 0; i < arrayList.size(); i++) {
                            this.f7647k.add(arrayList.get(i).userid);
                        }
                        m9422q();
                    }
                } else {
                    m9398a(1301);
                }
            } else {
                m9398a(1301);
            }
        } else {
            m9398a(1302);
        }
        return true;
    }

    /* renamed from: l */
    private void m9417l() {
        if (this.f7650n != null && this.f7650n.length == 0) {
            m9398a(1301);
        } else {
            m9420o();
        }
    }

    /* renamed from: d */
    private boolean m9409d(C0778b c0778b) {
        C4904y.m18639b("completedSetSnsId for sns " + m9424a(), getClass().getSimpleName());
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4368e.m16564a(CommonApplication.m18732r()).m16565a(this.f7648l, true);
            m9417l();
        } else {
            m9398a(1302);
        }
        return true;
    }

    /* renamed from: e */
    private boolean m9410e(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            SkipSMSVerifyServer skipSMSVerifyServer = (SkipSMSVerifyServer) c0778b.m3110e();
            if (TextUtils.isEmpty(skipSMSVerifyServer.uid) || TextUtils.isEmpty(skipSMSVerifyServer.chatonid)) {
                m9398a(1303);
                if (C4904y.f17875e) {
                    C4904y.m18634a("Uid " + skipSMSVerifyServer.uid + " ChatONID " + skipSMSVerifyServer.chatonid, getClass().getSimpleName());
                    return true;
                }
                return true;
            }
            m9418m();
            return true;
        }
        m9398a(1302);
        return true;
    }

    /* renamed from: m */
    private void m9418m() {
        if (this.f7639c == null) {
            this.f7639c = new C2075ah(this.f7645i);
        }
        EnumC2111bq.m9446a(EnumC2111bq.PROFILE_UPLOADING);
        this.f7639c.m9309b(this.f7644h.mo16638a(true));
    }

    /* renamed from: a */
    private void m9400a(String str) {
        if (this.f7639c == null) {
            this.f7639c = new C2075ah(this.f7645i);
        }
        if (str != null) {
            this.f7639c.m9316e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m9419n() {
        if (!this.f7651o) {
            C4904y.m18639b("calling setSNSApi upload : sns type -- " + this.f7648l, "SnsAccountControl");
            if (this.f7637a == null) {
                this.f7637a = new C2128i(this.f7645i);
            }
            this.f7637a.m9500a(this.f7648l, this.f7644h.mo16648c());
            return;
        }
        C4904y.m18639b("for buddySync -- skipping setSNSApi and processing buddies sns type -- " + this.f7648l, "SnsAccountControl");
        m9417l();
    }

    /* renamed from: o */
    private void m9420o() {
        C4904y.m18639b("retrieveFriendsFromChatON for sns " + m9424a(), getClass().getSimpleName());
        if (this.f7637a == null) {
            this.f7637a = new C2128i(this.f7645i);
        }
        EnumC2111bq.m9446a(EnumC2111bq.RETRIEVING_FRIENDS);
        this.f7637a.m9502a(this.f7648l, this.f7650n);
    }

    /* renamed from: p */
    private void m9421p() {
        if (this.f7638b == null) {
            this.f7638b = new C2095ba(this.f7645i);
        }
        EnumC2111bq.m9446a(EnumC2111bq.SKIPING_SMS);
        this.f7638b.m9357b(this);
    }

    /* renamed from: q */
    private void m9422q() {
        if (this.f7637a == null) {
            this.f7637a = new C2128i(this.f7645i);
        }
        EnumC2111bq.m9446a(EnumC2111bq.ADDING_BUDDIES);
        this.f7637a.m9503a(this.f7647k, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9398a(int i) {
        C4904y.m18639b("updateUI() for sns type :" + m9424a() + " value: " + i, getClass().getSimpleName());
        if (this.f7640d != null) {
            this.f7640d.mo9385a(i, EnumC2111bq.m9445a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public long[] m9423r() {
        long[] jArr = new long[this.f7646j.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7646j.size()) {
                jArr[i2] = Long.parseLong(this.f7646j.get(i2).m16561a());
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* renamed from: a */
    public void m9425a(int i, int i2, Intent intent) {
        switch (i) {
            case 32665:
                this.f7644h.mo16640a(i, i2, intent);
                m9421p();
                break;
        }
    }

    /* renamed from: a */
    public static C2105bk<? extends AbstractC4439w> m9396a(String str, boolean z, Looper looper, boolean z2) {
        if (str.equals(C4368e.f15815a)) {
            return new C2105bk<>(GlobalApplication.m18732r(), C4380af.class, z, looper, z2);
        }
        if (str.equals(C4368e.f15818d)) {
            return new C2105bk<>(GlobalApplication.m18732r(), C4382ah.class, z, looper, z2);
        }
        if (!str.equals(C4368e.f15820f)) {
            return null;
        }
        return new C2105bk<>(GlobalApplication.m18732r(), C4388an.class, z, looper, z2);
    }
}
