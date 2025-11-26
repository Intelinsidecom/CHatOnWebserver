package com.sec.common.actionbar;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarPreferenceActivity extends PreferenceActivity implements InterfaceC3302s {
    private final AbstractC3288e mActionBarHelper = AbstractC3288e.m11604a(this);

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBarHelper.mo11608a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.mActionBarHelper.mo11615b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC3303t) {
                return this.mActionBarHelper.mo11612a(menu) | false | super.onCreateOptionsMenu(menu);
            }
            return this.mActionBarHelper.mo11612a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.mActionBarHelper.mo11612a(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return Build.VERSION.SDK_INT < 11 ? false | super.onPrepareOptionsMenu(menu) | this.mActionBarHelper.mo11616b(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.mActionBarHelper.mo11613a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.mActionBarHelper.mo11607a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.mActionBarHelper.mo11609a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActionBarHelper.mo11610a(view, layoutParams);
    }

    public AbstractC3284a getSupportActionBar() {
        return this.mActionBarHelper.mo11614b();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mActionBarHelper.mo11605a(super.getMenuInflater());
    }
}
