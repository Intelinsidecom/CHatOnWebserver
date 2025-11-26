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
public class ActionBarMapActivity extends MapActivity implements InterfaceC3302s {

    /* renamed from: a */
    private final AbstractC3288e f11891a = AbstractC3288e.m11604a((Activity) this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11891a.mo11608a(bundle);
    }

    protected void onPostCreate(Bundle bundle) {
        this.f11891a.mo11615b(bundle);
        super.onPostCreate(bundle);
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC3303t) {
                return this.f11891a.mo11612a(menu) | false | super.onCreateOptionsMenu(menu);
            }
            return this.f11891a.mo11612a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f11891a.mo11612a(menu);
    }

    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return false;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        return Build.VERSION.SDK_INT < 11 ? false | super.onPrepareOptionsMenu(menu) | this.f11891a.mo11616b(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return false;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f11891a.mo11613a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    public void setContentView(int i) {
        this.f11891a.mo11607a(i);
    }

    public void setContentView(View view) {
        this.f11891a.mo11609a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f11891a.mo11610a(view, layoutParams);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f11891a.mo11611a(charSequence, i);
    }

    public MenuInflater getMenuInflater() {
        return this.f11891a.mo11605a(super.getMenuInflater());
    }
}
