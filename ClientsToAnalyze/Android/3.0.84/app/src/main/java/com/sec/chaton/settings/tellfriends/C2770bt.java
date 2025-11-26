package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.settings.tellfriends.common.AbstractC2799o;
import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import weibo4android.Weibo;
import weibo4android.http.RequestToken;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bt */
/* loaded from: classes.dex */
public class C2770bt extends AbstractC2799o {

    /* renamed from: a */
    public static final String f10194a = C2770bt.class.getSimpleName();

    /* renamed from: d */
    private static Weibo f10195d;

    /* renamed from: e */
    private static RequestToken f10196e;

    /* renamed from: f */
    private Handler f10197f;

    public C2770bt(Activity activity, InterfaceC2787c interfaceC2787c) {
        super(activity, interfaceC2787c, f10194a);
        this.f10197f = new HandlerC2771bu(this);
        if (f10195d == null) {
            f10195d = new Weibo();
            C2780cc.m9916a(f10195d, activity);
        }
    }

    /* renamed from: a */
    public void m9905a(int i) {
        if (f10195d == null) {
            f10195d = new Weibo();
            C2780cc.m9916a(f10195d, this.f10300b);
        }
        if (f10196e == null) {
            new AsyncTaskC2801q(this, 12005).execute(new C2775by(this, null));
        } else {
            m9907a(f10196e);
        }
    }

    /* renamed from: a */
    public boolean m9908a() {
        return C2780cc.m9918b(this.f10300b);
    }

    /* renamed from: b */
    public String m9909b() {
        return C2780cc.m9920c(this.f10300b);
    }

    /* renamed from: c */
    public String m9911c() {
        return C2780cc.m9923e(this.f10300b);
    }

    /* renamed from: d */
    public String m9913d() {
        return C2780cc.m9922d(this.f10300b);
    }

    /* renamed from: b */
    public void m9910b(int i) {
        new AsyncTaskC2801q(this, i).execute(new C2773bw(this, null));
    }

    /* renamed from: c */
    public void m9912c(int i) {
        new AsyncTaskC2801q(this, i).execute(new C2772bv(this, null));
    }

    /* renamed from: a */
    public void m9906a(int i, String str, String str2) {
        new AsyncTaskC2801q(this, i).execute(new C2776bz(this, str2, null));
    }

    /* renamed from: a */
    public static void m9895a(Context context) {
        C2780cc.m9914a(context);
        f10195d = null;
        f10196e = null;
    }

    /* renamed from: a */
    public void m9907a(RequestToken requestToken) {
        new DialogC2762bl(this.f10300b, f10195d, requestToken, new C2778ca(this, 12004)).show();
    }
}
