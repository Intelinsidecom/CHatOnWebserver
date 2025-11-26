package com.sec.chaton.settings2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.block.MenuItemOnMenuItemClickListenerC0487m;

/* loaded from: classes.dex */
public class PrefFragmentBlock extends BasePreferenceFragment {
    private MenuItemOnMenuItemClickListenerC0487m impl = new MenuItemOnMenuItemClickListenerC0487m(this);

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.impl.m3144a(i, i2, intent);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.impl.m3145a(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.impl.m3143a();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.impl.m3146a(bundle);
    }

    @Override // android.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.impl.m3147a(menu);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.impl.m3148a(menu, menuInflater);
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.impl.m3142a(layoutInflater, viewGroup, bundle);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.impl.m3150b();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.impl.m3151c();
    }
}
