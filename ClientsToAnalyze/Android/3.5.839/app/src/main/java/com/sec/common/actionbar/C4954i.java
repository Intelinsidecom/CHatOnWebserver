package com.sec.common.actionbar;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ActionBarHelperHoneycomb.java */
/* renamed from: com.sec.common.actionbar.i */
/* loaded from: classes.dex */
class C4954i extends AbstractC4950e {

    /* renamed from: b */
    private C4961p f18125b;

    protected C4954i(Activity activity) {
        super(activity);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public boolean mo18851a(Menu menu) {
        return ((InterfaceC4964s) this.f18113a).onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: b */
    public boolean mo18855b(Menu menu) {
        return ((InterfaceC4964s) this.f18113a).onSupportPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public boolean mo18852a(MenuItem menuItem) {
        return ((InterfaceC4964s) this.f18113a).onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18845a() {
        super.mo18845a();
        this.f18113a.invalidateOptionsMenu();
    }

    /* renamed from: c */
    private void m18863c() {
        if (this.f18125b == null) {
            this.f18125b = new C4961p(this.f18113a);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: b */
    public AbstractC4946a mo18853b() {
        m18863c();
        return this.f18125b;
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18846a(int i) {
        this.f18113a.getWindow().setContentView(i);
        m18863c();
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18848a(View view) {
        this.f18113a.getWindow().setContentView(view);
        m18863c();
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    public void mo18849a(View view, ViewGroup.LayoutParams layoutParams) {
        this.f18113a.getWindow().setContentView(view, layoutParams);
        m18863c();
    }

    @Override // com.sec.common.actionbar.AbstractC4950e
    /* renamed from: a */
    protected void mo18850a(CharSequence charSequence, int i) {
        m18863c();
        this.f18125b.mo18823a(charSequence);
    }
}
