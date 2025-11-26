package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: SlideshowEditor.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ip */
/* loaded from: classes.dex */
public class C4323ip {

    /* renamed from: a */
    private final Context f15725a;

    /* renamed from: b */
    private final C3870p f15726b;

    public C4323ip(Context context, C3870p c3870p) {
        this.f15725a = context;
        this.f15726b = c3870p;
    }

    /* renamed from: a */
    public boolean m16491a() {
        return m16492a(this.f15726b.size());
    }

    /* renamed from: a */
    public boolean m16492a(int i) {
        int size = this.f15726b.size();
        if (size < 10) {
            C3869o c3869o = new C3869o(this.f15726b);
            c3869o.add((AbstractC3863i) new C3872r(this.f15725a, "text/plain", "text_" + size + ".txt", this.f15726b.m14913d().m14790b()));
            this.f15726b.add(i, c3869o);
            return true;
        }
        C3890m.m14997c("Mms:slideshow", "The limitation of the number of slides is reached.");
        return false;
    }

    /* renamed from: b */
    public void m16494b(int i) {
        this.f15726b.remove(i);
    }

    /* renamed from: b */
    public void m16493b() {
        while (this.f15726b.size() > 0) {
            m16494b(0);
        }
    }

    /* renamed from: c */
    public boolean m16497c(int i) {
        return this.f15726b.get(i).m14871k();
    }

    /* renamed from: d */
    public boolean m16498d(int i) {
        return this.f15726b.get(i).m14873m();
    }

    /* renamed from: e */
    public boolean m16499e(int i) {
        return this.f15726b.get(i).m14872l();
    }

    /* renamed from: a */
    public void m16490a(int i, String str) {
        if (str != null) {
            C3869o c3869o = this.f15726b.get(i);
            C3872r c3872rM14874n = c3869o.m14874n();
            if (c3872rM14874n == null) {
                C3872r c3872r = new C3872r(this.f15725a, "text/plain", "text_" + i + ".txt", this.f15726b.m14913d().m14790b());
                c3872r.m14941a((CharSequence) str);
                c3869o.add((AbstractC3863i) c3872r);
            } else if (!str.equals(c3872rM14874n.m14940a())) {
                c3872rM14874n.m14941a((CharSequence) str);
            }
        }
    }

    /* renamed from: a */
    public void m16489a(int i, Uri uri) {
        this.f15726b.get(i).add((AbstractC3863i) new C3861g(this.f15725a, uri, this.f15726b.m14913d().m14786a()));
    }

    /* renamed from: b */
    public void m16495b(int i, Uri uri) {
        C3856b c3856b = new C3856b(this.f15725a, uri);
        C3869o c3869o = this.f15726b.get(i);
        c3869o.add((AbstractC3863i) c3856b);
        c3869o.m14868h(c3856b.m14811l());
    }

    /* renamed from: c */
    public void m16496c(int i, Uri uri) {
        C3873s c3873s = new C3873s(this.f15725a, uri, this.f15726b.m14913d().m14786a());
        C3869o c3869o = this.f15726b.get(i);
        c3869o.add((AbstractC3863i) c3873s);
        c3869o.m14868h(c3873s.m14811l());
    }

    /* renamed from: f */
    public void m16500f(int i) {
        this.f15726b.add(i - 1, this.f15726b.remove(i));
    }

    /* renamed from: g */
    public void m16501g(int i) {
        this.f15726b.add(i + 1, this.f15726b.remove(i));
    }

    /* renamed from: a */
    public void m16488a(int i, int i2) {
        if (i2 >= 0) {
            this.f15726b.get(i).m14850a(i2);
        }
    }

    /* renamed from: h */
    public void m16502h(int i) {
        this.f15726b.m14913d().m14788a(i);
    }
}
