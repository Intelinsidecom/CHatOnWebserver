package com.samsung.samm.lib.engine.p004a;

import java.io.IOException;

/* renamed from: com.samsung.samm.lib.engine.a.c */
/* loaded from: classes.dex */
public class C0910c {

    /* renamed from: a */
    private C0911d f653a = null;

    /* renamed from: b */
    private String f654b = null;

    /* renamed from: c */
    private boolean f655c = false;

    /* renamed from: a */
    public void m657a(String str) {
        this.f654b = str;
    }

    /* renamed from: a */
    public void m656a() throws IllegalStateException, IllegalArgumentException {
        if (this.f653a != null) {
            try {
                this.f653a.m662b();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f653a = null;
        }
        if (this.f654b != null) {
            this.f653a = new C0911d(this.f654b);
            try {
                this.f653a.m661a();
                this.f655c = true;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m658b() throws IllegalStateException {
        if (this.f655c && this.f653a != null) {
            try {
                this.f653a.m662b();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f655c = false;
        }
    }

    /* renamed from: c */
    public boolean m659c() {
        return this.f655c;
    }
}
