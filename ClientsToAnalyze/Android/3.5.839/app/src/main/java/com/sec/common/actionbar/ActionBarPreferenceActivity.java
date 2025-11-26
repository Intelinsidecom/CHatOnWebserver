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
public class ActionBarPreferenceActivity extends PreferenceActivity implements InterfaceC4964s {
    private final AbstractC4950e mActionBarHelper = AbstractC4950e.m18843a(this);

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBarHelper.mo18847a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.mActionBarHelper.mo18854b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC4965t) {
                return this.mActionBarHelper.mo18851a(menu) | false | super.onCreateOptionsMenu(menu);
            }
            return this.mActionBarHelper.mo18851a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.mActionBarHelper.mo18851a(menu);
    }

    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return Build.VERSION.SDK_INT < 11 ? false | super.onPrepareOptionsMenu(menu) | this.mActionBarHelper.mo18855b(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.mActionBarHelper.mo18852a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.mActionBarHelper.mo18846a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.mActionBarHelper.mo18848a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActionBarHelper.mo18849a(view, layoutParams);
    }

    public AbstractC4946a getSupportActionBar() {
        return this.mActionBarHelper.mo18853b();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mActionBarHelper.mo18844a(super.getMenuInflater());
    }
}
