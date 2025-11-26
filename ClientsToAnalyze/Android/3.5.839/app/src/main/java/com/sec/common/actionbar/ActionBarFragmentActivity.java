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
public class ActionBarFragmentActivity extends ActionBarHookActivity implements InterfaceC4964s {

    /* renamed from: n */
    private final AbstractC4950e f18088n = AbstractC4950e.m18843a(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18088n.mo18847a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.f18088n.mo18854b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC4965t) {
                return super.onCreateOptionsMenu(menu) | false | this.f18088n.mo18851a(menu);
            }
            return this.f18088n.mo18851a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f18088n.mo18851a(menu);
    }

    @Override // android.support.v4.app.FragmentActivity
    /* renamed from: u_ */
    public void mo51u_() {
        this.f18088n.mo18845a();
    }

    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return false | super.onPrepareOptionsMenu(menu) | this.f18088n.mo18855b(menu);
    }

    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f18088n.mo18852a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        this.f18088n.mo18846a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        this.f18088n.mo18848a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f18088n.mo18849a(view, layoutParams);
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f18088n.mo18850a(charSequence, i);
    }

    /* renamed from: t */
    public AbstractC4946a m18784t() {
        return this.f18088n.mo18853b();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.f18088n.mo18844a(super.getMenuInflater());
    }
}
