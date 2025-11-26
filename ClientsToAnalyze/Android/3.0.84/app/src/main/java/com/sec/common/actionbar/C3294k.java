package com.sec.common.actionbar;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.sec.common.C3310c;

/* compiled from: ActionBarImpl.java */
/* renamed from: com.sec.common.actionbar.k */
/* loaded from: classes.dex */
class C3294k extends AbstractC3284a implements InterfaceC3306w {

    /* renamed from: a */
    private Activity f11928a;

    /* renamed from: b */
    private View f11929b;

    /* renamed from: c */
    private ActionBarView f11930c;

    /* renamed from: d */
    private int f11931d;

    /* renamed from: e */
    private TabContainerView f11932e;

    /* renamed from: f */
    private C3296m f11933f;

    /* renamed from: g */
    private InterfaceC3287d f11934g = new C3295l(this);

    public C3294k(Activity activity) {
        this.f11928a = activity;
        this.f11929b = this.f11928a.findViewById(C3310c.actionbar_layout);
        this.f11930c = (ActionBarView) this.f11928a.findViewById(C3310c.actionbar_view);
        this.f11932e = (TabContainerView) this.f11928a.findViewById(C3310c.actionbar_tab_container_view);
        this.f11932e.m11572a(this);
        this.f11933f = null;
        mo11579a(0);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: g */
    public View mo11598g() {
        return this.f11930c.m11564b();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11580a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        this.f11930c.m11556a(view);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11586b(int i) {
        mo11583a(this.f11928a.getString(i));
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11583a(CharSequence charSequence) {
        this.f11930c.m11562a(charSequence);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11587b(CharSequence charSequence) {
        this.f11930c.m11566b(charSequence);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11579a(int i) {
        this.f11931d = i;
        this.f11930c.m11565b(i);
        if (i == 1) {
            this.f11932e.setVisibility(8);
        } else if (i == 0) {
            this.f11932e.setVisibility(8);
        } else if (i == 2) {
            this.f11932e.setVisibility(0);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public int mo11578a() {
        return this.f11931d;
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public AbstractC3286c mo11585b() {
        return new C3296m(this);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11582a(AbstractC3286c abstractC3286c, boolean z) {
        this.f11932e.m11571a(abstractC3286c);
    }

    /* renamed from: a */
    public void m11627a(AbstractC3286c abstractC3286c) {
        this.f11932e.m11573b(abstractC3286c.mo11602b());
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public AbstractC3286c mo11590c(int i) {
        return this.f11932e.m11574c(i);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public int mo11589c() {
        return this.f11932e.m11570a();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public void mo11592d(int i) {
        switch (this.f11931d) {
            case 1:
                this.f11930c.m11568c(i);
                return;
            case 2:
                m11627a(mo11590c(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public boolean mo11594d() {
        return this.f11929b.getVisibility() == 0;
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: e */
    public void mo11595e() {
        this.f11929b.setVisibility(0);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: f */
    public void mo11597f() {
        this.f11929b.setVisibility(8);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: e */
    public void mo11596e(int i) {
        this.f11930c.m11553a(i);
    }

    /* renamed from: a */
    public void m11626a(int i, int i2) {
        this.f11930c.m11553a((this.f11930c.m11552a() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11584a(boolean z) {
        m11626a(z ? 4 : 0, 4);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public void mo11591c(boolean z) {
        m11626a(z ? 8 : 0, 8);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11588b(boolean z) {
        m11626a(z ? 2 : 0, 2);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public void mo11593d(boolean z) {
        this.f11930c.m11563a(z);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11581a(SpinnerAdapter spinnerAdapter, InterfaceC3285b interfaceC3285b) {
        this.f11930c.m11557a(spinnerAdapter);
        this.f11930c.m11558a(interfaceC3285b);
    }

    @Override // com.sec.common.actionbar.InterfaceC3306w
    /* renamed from: b */
    public void mo11628b(AbstractC3286c abstractC3286c) {
        if (abstractC3286c != null) {
            FragmentTransaction fragmentTransactionDisallowAddToBackStack = null;
            try {
                fragmentTransactionDisallowAddToBackStack = ((FragmentActivity) this.f11928a).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            } catch (ClassCastException e) {
            }
            try {
                C3296m c3296m = (C3296m) abstractC3286c;
                if (this.f11933f == c3296m) {
                    c3296m.m11631d().mo1156c(c3296m, fragmentTransactionDisallowAddToBackStack);
                } else {
                    if (this.f11933f != null) {
                        this.f11933f.m11631d().mo1155b(c3296m, fragmentTransactionDisallowAddToBackStack);
                    }
                    c3296m.m11631d().mo1153a(c3296m, fragmentTransactionDisallowAddToBackStack);
                }
                this.f11933f = c3296m;
            } finally {
                if (fragmentTransactionDisallowAddToBackStack != null && !fragmentTransactionDisallowAddToBackStack.isEmpty()) {
                    fragmentTransactionDisallowAddToBackStack.commit();
                }
            }
        }
    }
}
