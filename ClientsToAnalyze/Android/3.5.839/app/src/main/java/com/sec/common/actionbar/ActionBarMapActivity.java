package com.sec.common.actionbar;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.maps.MapActivity;

/* loaded from: classes.dex */
public class ActionBarMapActivity extends MapActivity implements InterfaceC4964s {

    /* renamed from: a */
    private final AbstractC4950e f18090a = AbstractC4950e.m18843a((Activity) this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18090a.mo18847a(bundle);
    }

    protected void onPostCreate(Bundle bundle) {
        this.f18090a.mo18854b(bundle);
        super.onPostCreate(bundle);
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC4965t) {
                return this.f18090a.mo18851a(menu) | false | super.onCreateOptionsMenu(menu);
            }
            return this.f18090a.mo18851a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f18090a.mo18851a(menu);
    }

    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return false;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        return Build.VERSION.SDK_INT < 11 ? false | super.onPrepareOptionsMenu(menu) | this.f18090a.mo18855b(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return false;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f18090a.mo18852a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    public void setContentView(int i) {
        this.f18090a.mo18846a(i);
    }

    public void setContentView(View view) {
        this.f18090a.mo18848a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f18090a.mo18849a(view, layoutParams);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f18090a.mo18850a(charSequence, i);
    }

    public MenuInflater getMenuInflater() {
        return this.f18090a.mo18844a(super.getMenuInflater());
    }
}
