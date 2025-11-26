package com.sec.chaton.settings2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.hide.C1516g;
import com.sec.chaton.hide.HideListActivity;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class PrefFragmentHide extends BasePreferenceFragment {
    private C1516g impl = new C1516g();
    private MenuItem.OnMenuItemClickListener menuListener = new MenuItem.OnMenuItemClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentHide.1
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.hidelist_menu_add /* 2131166614 */:
                    Intent intent = new Intent(PrefFragmentHide.this.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE", 9);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG2", 2);
                    PrefFragmentHide.this.startActivityForResult(intent, 100);
                    break;
                case R.id.hidelist_menu_edit /* 2131166615 */:
                    Intent intent2 = new Intent(PrefFragmentHide.this.getActivity(), (Class<?>) HideListActivity.class);
                    intent2.putExtra("hide_buddy_list", PrefFragmentHide.this.impl.m6512e());
                    PrefFragmentHide.this.startActivityForResult(intent2, HttpResponseCode.f13733OK);
                    break;
            }
            return true;
        }
    };

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.impl.m6504a(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.impl.m6509b();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.impl.m6505a(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.impl.m6507a(this.menuListener);
        this.impl.m6506a(menu, menuInflater);
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        return this.impl.m6508a(menuItem);
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.impl.m6501a(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.impl.m6510c();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.impl.m6511d();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.impl.m6503a(i, i2, intent);
    }
}
