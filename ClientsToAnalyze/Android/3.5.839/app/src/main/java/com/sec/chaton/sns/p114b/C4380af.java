package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.sns.b.af */
/* loaded from: classes.dex */
public class C4380af extends AbstractC4439w {

    /* renamed from: a */
    private static final String f15857a = C4380af.class.getSimpleName();

    /* renamed from: b */
    private C4374a f15858b;

    /* renamed from: c */
    private boolean f15859c;

    /* renamed from: d */
    private InterfaceC4367d f15860d = new C4381ag(this);

    /* renamed from: e */
    private InterfaceC4442z f15861e;

    /* renamed from: f */
    private InterfaceC4378ad f15862f;

    /* renamed from: g */
    private InterfaceC4377ac f15863g;

    /* renamed from: h */
    private InterfaceC4376ab f15864h;

    public C4380af(Context context) {
        this.f15858b = new C4374a(context, this.f15860d);
    }

    public C4380af(Context context, boolean z) {
        this.f15859c = z;
        this.f15858b = new C4374a(context, this.f15860d);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16639a() {
        this.f15858b.m16617g();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16644a(InterfaceC4442z interfaceC4442z) {
        if (interfaceC4442z != null) {
            this.f15861e = interfaceC4442z;
        }
        this.f15858b.m16610a(this.f15859c);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16643a(InterfaceC4441y interfaceC4441y) {
    }

    /* renamed from: a */
    public void m16646a(String str, InterfaceC4378ad interfaceC4378ad, String str2) {
        if (interfaceC4378ad != null) {
            this.f15862f = interfaceC4378ad;
        }
        this.f15858b.m16608a(1, str, str2);
    }

    /* renamed from: a */
    public void m16645a(String str, InterfaceC4378ad interfaceC4378ad) {
        if (interfaceC4378ad != null) {
            this.f15862f = interfaceC4378ad;
        }
        this.f15858b.m16607a(1, str);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16642a(InterfaceC4377ac interfaceC4377ac) {
        if (interfaceC4377ac != null) {
            this.f15863g = interfaceC4377ac;
        }
        this.f15858b.m16612b(2);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16641a(InterfaceC4376ab interfaceC4376ab) {
        if (interfaceC4376ab != null) {
            this.f15864h = interfaceC4376ab;
        }
        this.f15858b.m16605a(3);
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: e */
    public boolean mo16650e() {
        return this.f15858b.m16616f() && C4368e.m16564a(GlobalApplication.m18732r()).m16566a(C4368e.f15815a);
    }

    /* renamed from: f */
    public String m16651f() {
        return this.f15858b.m16613c();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: b */
    public String mo16647b() {
        return this.f15858b.m16604a();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: c */
    public String mo16648c() {
        return this.f15858b.m16611b();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public String mo16638a(boolean z) {
        return z ? m16637a(600, 600) : this.f15858b.m16614d();
    }

    /* renamed from: a */
    public String m16637a(int i, int i2) {
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        Uri.Builder builderEncodedPath = new Uri.Builder().encodedPath(this.f15858b.m16614d());
        builderEncodedPath.appendQueryParameter("width", String.valueOf(iMax));
        builderEncodedPath.appendQueryParameter("height", String.valueOf(iMax2));
        builderEncodedPath.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return builderEncodedPath.toString();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: d */
    public String mo16649d() {
        return this.f15858b.m16615e();
    }

    @Override // com.sec.chaton.sns.p114b.AbstractC4439w
    /* renamed from: a */
    public void mo16640a(int i, int i2, Intent intent) {
        this.f15858b.m16606a(i, i2, intent);
    }
}
