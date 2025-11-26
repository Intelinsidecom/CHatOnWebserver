package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.os.Bundle;
import com.renren.android.Renren;
import com.sec.chaton.settings.tellfriends.common.AbstractC2799o;
import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.m */
/* loaded from: classes.dex */
public class C2819m extends AbstractC2799o {

    /* renamed from: a */
    public static final String f10343a = C2819m.class.getSimpleName();

    /* renamed from: d */
    private static Renren f10344d;

    /* renamed from: e */
    private Activity f10345e;

    public C2819m(Activity activity, InterfaceC2787c interfaceC2787c) {
        super(activity, interfaceC2787c, f10343a);
        this.f10345e = activity;
        if (f10344d == null) {
            f10344d = new Renren("44c448753f244b1891445c240f8fa1e3", "5ae8c090db1f4a13bdf1211251f404f0", "233775", activity);
        }
    }

    /* renamed from: a */
    public void m10049a(int i) {
        f10344d.m523a(this.f10345e, new String[]{"publish_feed", "create_album", "photo_upload", "read_user_album", "status_update"}, new C2820n(this, i));
    }

    /* renamed from: a */
    public boolean m10051a() {
        return f10344d.m526a();
    }

    /* renamed from: b */
    public String m10052b() {
        return C2827u.m10058a(this.f10345e);
    }

    /* renamed from: c */
    public String m10054c() {
        return C2827u.m10062c(this.f10345e);
    }

    /* renamed from: d */
    public String m10055d() {
        return C2827u.m10060b(this.f10345e);
    }

    /* renamed from: b */
    public void m10053b(int i) {
        new AsyncTaskC2801q(this, i).execute(new C2822p(this));
    }

    /* renamed from: a */
    public void m10050a(int i, String str, String str2) {
        if (str == null || str.isEmpty()) {
            new AsyncTaskC2801q(this, i).execute(new C2824r(this, str2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("to", str);
            new C2818l(this.f10345e, f10344d, bundle).m10036a(new C2821o(this, i)).mo10035a().show();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2799o
    /* renamed from: e */
    public void mo10016e() {
        super.mo10016e();
    }
}
