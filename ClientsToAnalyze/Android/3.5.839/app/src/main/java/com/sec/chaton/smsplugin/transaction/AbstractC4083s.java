package com.sec.chaton.smsplugin.transaction;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Observable.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.s */
/* loaded from: classes.dex */
public abstract class AbstractC4083s {

    /* renamed from: a */
    private final ArrayList<InterfaceC4084t> f14703a = new ArrayList<>();

    /* renamed from: b */
    private Iterator<InterfaceC4084t> f14704b;

    /* renamed from: a */
    public void m15695a(InterfaceC4084t interfaceC4084t) {
        this.f14703a.add(interfaceC4084t);
    }

    /* renamed from: b */
    public void m15696b(InterfaceC4084t interfaceC4084t) {
        if (this.f14704b != null) {
            this.f14704b.remove();
        } else {
            this.f14703a.remove(interfaceC4084t);
        }
    }

    /* renamed from: d */
    public void m15697d() {
        this.f14704b = this.f14703a.iterator();
        while (this.f14704b.hasNext()) {
            try {
                this.f14704b.next().mo15595a(this);
            } finally {
                this.f14704b = null;
            }
        }
    }
}
