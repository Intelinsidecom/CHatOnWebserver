package com.sec.common.actionbar;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarHookActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarFragmentActivity extends ActionBarHookActivity implements InterfaceC3302s {

    /* renamed from: a */
    private final AbstractC3288e f11889a = AbstractC3288e.m11604a(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11889a.mo11608a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.f11889a.mo11615b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC3303t) {
                return super.onCreateOptionsMenu(menu) | false | this.f11889a.mo11612a(menu);
            }
            return this.f11889a.mo11612a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f11889a.mo11612a(menu);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        this.f11889a.mo11606a();
    }

    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return false | super.onPrepareOptionsMenu(menu) | this.f11889a.mo11616b(menu);
    }

    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f11889a.mo11613a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.f11889a.mo11607a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.f11889a.mo11609a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f11889a.mo11610a(view, layoutParams);
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f11889a.mo11611a(charSequence, i);
    }

    /* renamed from: k */
    public AbstractC3284a m11543k() {
        return this.f11889a.mo11614b();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.f11889a.mo11605a(super.getMenuInflater());
    }
}
