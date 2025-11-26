package com.sec.common.actionbar;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.SpinnerAdapter;

/* compiled from: ActionBarWrapper.java */
@TargetApi(11)
/* renamed from: com.sec.common.actionbar.p */
/* loaded from: classes.dex */
class C4961p extends AbstractC4946a {

    /* renamed from: a */
    private Activity f18140a;

    /* renamed from: b */
    private ActionBar f18141b;

    public C4961p(Activity activity) {
        this.f18140a = activity;
        this.f18141b = activity.getActionBar();
        if (Build.VERSION.SDK_INT >= 14 && this.f18141b != null && (this.f18141b.getDisplayOptions() & 4) == 4) {
            this.f18141b.setHomeButtonEnabled(true);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18820a(View view) {
        if (this.f18141b != null) {
            this.f18141b.setCustomView(view);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18827b(CharSequence charSequence) {
        if (this.f18141b != null) {
            this.f18141b.setSubtitle(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18826b(int i) {
        if (this.f18141b != null) {
            this.f18141b.setTitle(i);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18823a(CharSequence charSequence) {
        if (this.f18141b != null) {
            this.f18141b.setTitle(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18819a(int i) {
        if (this.f18141b != null) {
            this.f18141b.setNavigationMode(i);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public int mo18818a() {
        return this.f18141b.getNavigationMode();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public AbstractC4948c mo18825b() {
        return new C4963r(this, this.f18141b.newTab());
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18822a(AbstractC4948c abstractC4948c, boolean z) {
        this.f18141b.addTab(((C4963r) abstractC4948c).f18145b, z);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public AbstractC4948c mo18830c(int i) {
        return new C4963r(this, this.f18141b.getTabAt(i));
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public int mo18829c() {
        return this.f18141b.getTabCount();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public void mo18832d(int i) {
        this.f18141b.setSelectedNavigationItem(i);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public boolean mo18834d() {
        return this.f18141b.isShowing();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: e */
    public void mo18835e() {
        this.f18141b.show();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: f */
    public void mo18837f() {
        this.f18141b.hide();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: e */
    public void mo18836e(int i) {
        this.f18141b.setDisplayOptions(i);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18824a(boolean z) {
        this.f18141b.setDisplayHomeAsUpEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public void mo18831c(boolean z) {
        this.f18141b.setDisplayShowTitleEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18828b(boolean z) {
        this.f18141b.setDisplayShowHomeEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public void mo18833d(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f18141b.setHomeButtonEnabled(z);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18821a(SpinnerAdapter spinnerAdapter, InterfaceC4947b interfaceC4947b) {
        this.f18141b.setListNavigationCallbacks(spinnerAdapter, new C4962q(this, interfaceC4947b));
    }
}
