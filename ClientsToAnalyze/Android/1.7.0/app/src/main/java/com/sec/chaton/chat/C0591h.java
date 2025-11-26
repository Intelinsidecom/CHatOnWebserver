package com.sec.chaton.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;
import com.sec.chaton.util.C1341p;
import java.util.HashMap;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.h */
/* loaded from: classes.dex */
public class C0591h implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    C0594k f2025a;

    /* renamed from: b */
    private final FragmentActivity f2026b;

    /* renamed from: c */
    private final TabHost f2027c;

    /* renamed from: d */
    private final int f2028d;

    /* renamed from: e */
    private final HashMap f2029e = new HashMap();

    public C0591h(FragmentActivity fragmentActivity, TabHost tabHost, int i) {
        this.f2026b = fragmentActivity;
        this.f2027c = tabHost;
        this.f2028d = i;
        this.f2027c.setOnTabChangedListener(this);
    }

    /* renamed from: a */
    public void m2776a(TabHost.TabSpec tabSpec, Class cls, Bundle bundle) {
        tabSpec.setContent(new C0551b(this.f2026b));
        String tag = tabSpec.getTag();
        C0594k c0594k = new C0594k(tag, cls, bundle);
        c0594k.f2036d = this.f2026b.getSupportFragmentManager().findFragmentByTag(tag);
        if (c0594k.f2036d != null && !c0594k.f2036d.isDetached()) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f2026b.getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.detach(c0594k.f2036d);
            fragmentTransactionBeginTransaction.commit();
        }
        this.f2029e.put(tag, c0594k);
        this.f2027c.addTab(tabSpec);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        C1341p.m4660c("onTabChanged", getClass().getSimpleName());
        C0594k c0594k = (C0594k) this.f2029e.get(str);
        if (this.f2025a != c0594k) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f2026b.getSupportFragmentManager().beginTransaction();
            if (this.f2025a != null && this.f2025a.f2036d != null) {
                fragmentTransactionBeginTransaction.detach(this.f2025a.f2036d);
            }
            if (c0594k != null) {
                if (c0594k.f2036d == null) {
                    c0594k.f2036d = Fragment.instantiate(this.f2026b, c0594k.f2034b.getName(), c0594k.f2035c);
                    fragmentTransactionBeginTransaction.add(this.f2028d, c0594k.f2036d, c0594k.f2033a);
                } else {
                    fragmentTransactionBeginTransaction.attach(c0594k.f2036d);
                }
            }
            this.f2025a = c0594k;
            fragmentTransactionBeginTransaction.commit();
            this.f2026b.getSupportFragmentManager().executePendingTransactions();
            if (str == "chatroom") {
                InterfaceC0531ag unused = ChatActivity.f1700x = (ChatFragment) c0594k.f2036d;
            } else {
                InterfaceC0531ag unused2 = ChatActivity.f1700x = null;
            }
        }
    }
}
