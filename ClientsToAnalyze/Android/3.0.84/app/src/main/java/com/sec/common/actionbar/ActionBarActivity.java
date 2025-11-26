package com.sec.common.actionbar;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarActivity extends Activity implements InterfaceC3302s {

    /* renamed from: a */
    private final AbstractC3288e f11888a = AbstractC3288e.m11604a(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11888a.mo11608a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.f11888a.mo11615b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC3303t) {
                return super.onCreateOptionsMenu(menu) | false | this.f11888a.mo11612a(menu);
            }
            return this.f11888a.mo11612a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f11888a.mo11612a(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return false | super.onPrepareOptionsMenu(menu) | this.f11888a.mo11616b(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f11888a.mo11613a(menuItem);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.f11888a.mo11607a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.f11888a.mo11609a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f11888a.mo11610a(view, layoutParams);
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f11888a.mo11611a(charSequence, i);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.f11888a.mo11605a(super.getMenuInflater());
    }
}
