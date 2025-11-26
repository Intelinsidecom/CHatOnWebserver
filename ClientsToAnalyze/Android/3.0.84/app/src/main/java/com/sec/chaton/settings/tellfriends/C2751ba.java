package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.AbstractC2799o;
import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ba */
/* loaded from: classes.dex */
public class C2751ba extends AbstractC2799o {

    /* renamed from: a */
    public static final String f10148a = C2751ba.class.getSimpleName();

    /* renamed from: d */
    private static final String f10149d = C0817b.f3141m + "?oauth_token=";

    /* renamed from: e */
    private static Twitter f10150e;

    /* renamed from: f */
    private static RequestToken f10151f;

    /* renamed from: g */
    private C2754bd f10152g;

    /* renamed from: h */
    private Handler f10153h;

    public C2751ba(Activity activity, InterfaceC2787c interfaceC2787c) {
        super(activity, interfaceC2787c, f10148a);
        this.f10153h = new HandlerC2752bb(this);
        if (f10150e == null) {
            f10150e = new TwitterFactory().getInstance();
            C2760bj.m9868a(f10150e, activity);
        }
    }

    /* renamed from: a */
    public void m9852a(int i) {
        if (f10150e == null) {
            f10150e = new TwitterFactory().getInstance();
            C2760bj.m9868a(f10150e, this.f10300b);
        }
        if (f10151f == null) {
            new AsyncTaskC2801q(this, 12005).execute(new C2756bf(this, null));
        } else {
            m9854a(f10151f.getToken());
        }
    }

    /* renamed from: a */
    public static void m9842a(Context context) {
        C2760bj.m9866a(context);
        f10150e = null;
        f10151f = null;
    }

    /* renamed from: a */
    public boolean m9855a() {
        return C2760bj.m9870b(this.f10300b);
    }

    /* renamed from: a */
    public void m9854a(String str) {
        new DialogC2741ar(this.f10300b, f10150e, f10149d + str, new C2757bg(this, 12004)).show();
    }

    /* renamed from: b */
    public String m9856b() {
        return C2760bj.m9872c(this.f10300b);
    }

    /* renamed from: c */
    public String m9858c() {
        return C2760bj.m9875e(this.f10300b);
    }

    /* renamed from: d */
    public String m9860d() {
        return C2760bj.m9874d(this.f10300b);
    }

    /* renamed from: b */
    public void m9857b(int i) {
        if (this.f10152g == null) {
            this.f10152g = new C2754bd(this, null);
        }
        if (this.f10152g.m9865b()) {
            new AsyncTaskC2801q(this, i).execute(this.f10152g);
        }
    }

    /* renamed from: c */
    public void m9859c(int i) {
        new AsyncTaskC2801q(this, i).execute(new C2753bc(this, null));
    }

    /* renamed from: a */
    public void m9853a(int i, String str, String str2) {
        new AsyncTaskC2801q(this, i).execute(new C2758bh(this, str2, null));
    }

    /* renamed from: f */
    public boolean m9861f() {
        return this.f10152g != null && this.f10152g.m9865b();
    }
}
