package com.sec.widget;

import android.preference.Preference;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import java.util.List;

/* loaded from: classes.dex */
public class PreferenceListFragment extends ListFragment {
    /* renamed from: a */
    public void m5872a(List list) {
        setListAdapter(new C1613aj(getActivity(), 0, list));
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        Preference preference = (Preference) getListAdapter().getItem(i);
        if (preference.isEnabled()) {
            if ((preference.getOnPreferenceClickListener() == null || !preference.getOnPreferenceClickListener().onPreferenceClick(preference)) && !m5873a(preference) && preference.getIntent() != null) {
                getActivity().startActivity(preference.getIntent());
            }
        }
    }

    /* renamed from: a */
    protected boolean m5873a(Preference preference) {
        return false;
    }
}
