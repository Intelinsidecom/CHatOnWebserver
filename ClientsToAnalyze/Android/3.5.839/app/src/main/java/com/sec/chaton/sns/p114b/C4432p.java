package com.sec.chaton.sns.p114b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.renren.android.Renren;
import com.sec.chaton.sns.C4373b;
import com.sec.chaton.sns.p113a.AbstractC4369f;
import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.sns.p115ui.C4503p;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.p */
/* loaded from: classes.dex */
public class C4432p extends AbstractC4369f {

    /* renamed from: c */
    public static final String f16000c = C4432p.class.getSimpleName();

    /* renamed from: d */
    private static Renren f16001d;

    /* renamed from: e */
    private Context f16002e;

    public C4432p(Context context, InterfaceC4367d interfaceC4367d) {
        super(context, interfaceC4367d, f16000c);
        this.f16002e = context;
        if (f16001d == null) {
            f16001d = new Renren("44c448753f244b1891445c240f8fa1e3", "5ae8c090db1f4a13bdf1211251f404f0", "233775", context);
        }
    }

    /* renamed from: a */
    public void m16807a(int i) {
        f16001d.m2255a((Activity) this.f16002e, new String[]{"publish_feed", "create_album", "photo_upload", "read_user_album", "status_update"}, new C4433q(this, i));
    }

    /* renamed from: b */
    public boolean m16810b() {
        return f16001d.m2258a();
    }

    /* renamed from: c */
    public String m16811c() {
        return C4373b.m16581a(this.f16002e);
    }

    /* renamed from: d */
    public String m16812d() {
        return C4373b.m16585c(this.f16002e);
    }

    /* renamed from: e */
    public String m16813e() {
        return C4373b.m16583b(this.f16002e);
    }

    /* renamed from: b */
    public void m16809b(int i) {
        new AsyncTaskC4371h(this, i).execute(new C4435s(this));
    }

    /* renamed from: a */
    public void m16808a(int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            new AsyncTaskC4371h(this, i).execute(new C4437u(this, str2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("to", str);
            new C4503p(this.f16002e, f16001d, bundle).m17006a(new C4434r(this, i)).mo17005a().show();
        }
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4369f
    /* renamed from: a */
    public void mo16569a() {
        super.mo16569a();
    }
}
