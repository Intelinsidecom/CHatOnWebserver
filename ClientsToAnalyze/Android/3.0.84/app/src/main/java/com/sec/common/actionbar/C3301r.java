package com.sec.common.actionbar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/* compiled from: ActionBarWrapper.java */
/* renamed from: com.sec.common.actionbar.r */
/* loaded from: classes.dex */
class C3301r extends AbstractC3286c implements ActionBar.TabListener {

    /* renamed from: a */
    final /* synthetic */ C3299p f11946a;

    /* renamed from: b */
    private ActionBar.Tab f11947b;

    /* renamed from: c */
    private InterfaceC3287d f11948c;

    public C3301r(C3299p c3299p, ActionBar.Tab tab) {
        this.f11946a = c3299p;
        this.f11947b = tab;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public View mo11599a() {
        return this.f11947b.getCustomView();
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public AbstractC3286c mo11600a(View view) {
        this.f11947b.setCustomView(view);
        return this;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: b */
    public int mo11602b() {
        return this.f11947b.getPosition();
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: c */
    public CharSequence mo11603c() {
        return this.f11947b.getText();
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public AbstractC3286c mo11601a(InterfaceC3287d interfaceC3287d) {
        this.f11948c = interfaceC3287d;
        this.f11947b.setTabListener(this);
        return this;
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f11948c != null && (this.f11946a.f11942a instanceof FragmentActivity)) {
            android.support.v4.app.FragmentTransaction fragmentTransactionDisallowAddToBackStack = ((FragmentActivity) this.f11946a.f11942a).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            this.f11948c.mo1153a(this, fragmentTransactionDisallowAddToBackStack);
            if (fragmentTransactionDisallowAddToBackStack != null && !fragmentTransactionDisallowAddToBackStack.isEmpty()) {
                fragmentTransactionDisallowAddToBackStack.commit();
            }
        }
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f11948c != null && (this.f11946a.f11942a instanceof FragmentActivity)) {
            android.support.v4.app.FragmentTransaction fragmentTransactionDisallowAddToBackStack = ((FragmentActivity) this.f11946a.f11942a).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            this.f11948c.mo1155b(this, fragmentTransactionDisallowAddToBackStack);
            if (fragmentTransactionDisallowAddToBackStack != null && !fragmentTransactionDisallowAddToBackStack.isEmpty()) {
                fragmentTransactionDisallowAddToBackStack.commit();
            }
        }
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f11948c != null && (this.f11946a.f11942a instanceof FragmentActivity)) {
            android.support.v4.app.FragmentTransaction fragmentTransactionDisallowAddToBackStack = ((FragmentActivity) this.f11946a.f11942a).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            this.f11948c.mo1156c(this, fragmentTransactionDisallowAddToBackStack);
            if (fragmentTransactionDisallowAddToBackStack != null && !fragmentTransactionDisallowAddToBackStack.isEmpty()) {
                fragmentTransactionDisallowAddToBackStack.commit();
            }
        }
    }
}
