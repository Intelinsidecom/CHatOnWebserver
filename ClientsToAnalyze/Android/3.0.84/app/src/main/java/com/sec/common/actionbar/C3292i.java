package com.sec.common.actionbar;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ActionBarHelperHoneycomb.java */
/* renamed from: com.sec.common.actionbar.i */
/* loaded from: classes.dex */
class C3292i extends AbstractC3288e {

    /* renamed from: b */
    private C3299p f11927b;

    protected C3292i(Activity activity) {
        super(activity);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public boolean mo11612a(Menu menu) {
        return ((InterfaceC3302s) this.f11915a).onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: b */
    public boolean mo11616b(Menu menu) {
        return ((InterfaceC3302s) this.f11915a).onSupportPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public boolean mo11613a(MenuItem menuItem) {
        return ((InterfaceC3302s) this.f11915a).onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11606a() {
        super.mo11606a();
        this.f11915a.invalidateOptionsMenu();
    }

    /* renamed from: c */
    private void m11624c() {
        if (this.f11927b == null) {
            this.f11927b = new C3299p(this.f11915a);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: b */
    public AbstractC3284a mo11614b() {
        m11624c();
        return this.f11927b;
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11607a(int i) {
        this.f11915a.getWindow().setContentView(i);
        m11624c();
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11609a(View view) {
        this.f11915a.getWindow().setContentView(view);
        m11624c();
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    public void mo11610a(View view, ViewGroup.LayoutParams layoutParams) {
        this.f11915a.getWindow().setContentView(view, layoutParams);
        m11624c();
    }

    @Override // com.sec.common.actionbar.AbstractC3288e
    /* renamed from: a */
    protected void mo11611a(CharSequence charSequence, int i) {
        m11624c();
        this.f11927b.mo11583a(charSequence);
    }
}
