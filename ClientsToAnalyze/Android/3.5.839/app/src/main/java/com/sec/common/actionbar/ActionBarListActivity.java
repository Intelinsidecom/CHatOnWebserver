package com.sec.common.actionbar;

import android.app.ListActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ActionBarListActivity extends ListActivity implements InterfaceC4964s {

    /* renamed from: a */
    private final AbstractC4950e f18089a = AbstractC4950e.m18843a(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18089a.mo18847a(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        this.f18089a.mo18854b(bundle);
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        this.f18089a.mo18846a(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        this.f18089a.mo18848a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f18089a.mo18849a(view, layoutParams);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        if (Build.VERSION.SDK_INT < 11) {
            if (menu instanceof MenuC4965t) {
                return this.f18089a.mo18851a(menu) | false | super.onCreateOptionsMenu(menu);
            }
            return this.f18089a.mo18851a(menu);
        }
        return super.onCreateOptionsMenu(menu) | false | this.f18089a.mo18851a(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return Build.VERSION.SDK_INT < 11 ? false | super.onPrepareOptionsMenu(menu) | this.f18089a.mo18855b(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return false | super.onOptionsItemSelected(menuItem) | this.f18089a.mo18852a(menuItem);
    }

    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        return true;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.f18089a.mo18844a(super.getMenuInflater());
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f18089a.mo18850a(charSequence, i);
    }

    /* renamed from: a */
    public AbstractC4946a m18785a() {
        return this.f18089a.mo18853b();
    }
}
