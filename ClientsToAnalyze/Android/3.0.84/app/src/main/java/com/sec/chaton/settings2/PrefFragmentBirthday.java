package com.sec.chaton.settings2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.userprofile.C3137f;

/* loaded from: classes.dex */
public class PrefFragmentBirthday extends BasePreferenceFragment {
    private C3137f impl = new C3137f();

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        this.impl.m10921a(bundle);
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        this.impl.m10920a(activity);
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        this.impl.m10918a();
        super.onDetach();
        setHasOptionsMenu(false);
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewM10917a = this.impl.m10917a(layoutInflater, viewGroup, bundle);
        setHasOptionsMenu(true);
        return viewM10917a;
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.impl.m10922a(menu, menuInflater);
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.impl.m10924a(menuItem);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.impl.m10928e();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        this.impl.m10929f();
        super.onDestroy();
    }
}
