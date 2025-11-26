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
class C3299p extends AbstractC3284a {

    /* renamed from: a */
    private Activity f11942a;

    /* renamed from: b */
    private ActionBar f11943b;

    public C3299p(Activity activity) {
        this.f11942a = activity;
        this.f11943b = activity.getActionBar();
        if (Build.VERSION.SDK_INT >= 14 && this.f11943b != null && (this.f11943b.getDisplayOptions() & 4) == 4) {
            this.f11943b.setHomeButtonEnabled(true);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: g */
    public View mo11598g() {
        if (this.f11943b != null) {
            return this.f11943b.getCustomView();
        }
        return null;
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11580a(View view) {
        if (this.f11943b != null) {
            this.f11943b.setCustomView(view);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11587b(CharSequence charSequence) {
        if (this.f11943b != null) {
            this.f11943b.setSubtitle(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11586b(int i) {
        if (this.f11943b != null) {
            this.f11943b.setTitle(i);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11583a(CharSequence charSequence) {
        if (this.f11943b != null) {
            this.f11943b.setTitle(charSequence);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11579a(int i) {
        if (this.f11943b != null) {
            this.f11943b.setNavigationMode(i);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public int mo11578a() {
        return this.f11943b.getNavigationMode();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public AbstractC3286c mo11585b() {
        return new C3301r(this, this.f11943b.newTab());
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11582a(AbstractC3286c abstractC3286c, boolean z) {
        this.f11943b.addTab(((C3301r) abstractC3286c).f11947b, z);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public AbstractC3286c mo11590c(int i) {
        return new C3301r(this, this.f11943b.getTabAt(i));
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public int mo11589c() {
        return this.f11943b.getTabCount();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public void mo11592d(int i) {
        this.f11943b.setSelectedNavigationItem(i);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public boolean mo11594d() {
        return this.f11943b.isShowing();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: e */
    public void mo11595e() {
        this.f11943b.show();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: f */
    public void mo11597f() {
        this.f11943b.hide();
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: e */
    public void mo11596e(int i) {
        this.f11943b.setDisplayOptions(i);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11584a(boolean z) {
        this.f11943b.setDisplayHomeAsUpEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: c */
    public void mo11591c(boolean z) {
        this.f11943b.setDisplayShowTitleEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: b */
    public void mo11588b(boolean z) {
        this.f11943b.setDisplayShowHomeEnabled(z);
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: d */
    public void mo11593d(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f11943b.setHomeButtonEnabled(z);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC3284a
    /* renamed from: a */
    public void mo11581a(SpinnerAdapter spinnerAdapter, InterfaceC3285b interfaceC3285b) {
        this.f11943b.setListNavigationCallbacks(spinnerAdapter, new C3300q(this, interfaceC3285b));
    }
}
