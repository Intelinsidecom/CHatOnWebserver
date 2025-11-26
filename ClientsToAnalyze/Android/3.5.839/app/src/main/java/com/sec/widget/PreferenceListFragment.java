package com.sec.widget;

import android.preference.Preference;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import java.util.List;

/* loaded from: classes.dex */
public class PreferenceListFragment extends ListFragment {
    /* renamed from: a */
    public void m19665a(List<Preference> list) {
        m61a(new C5142ae(getActivity(), 0, list));
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        Preference preference = (Preference) m63b().getItem(i);
        if (preference.isEnabled()) {
            if ((preference.getOnPreferenceClickListener() == null || !preference.getOnPreferenceClickListener().onPreferenceClick(preference)) && !m19666a(preference) && preference.getIntent() != null) {
                getActivity().startActivity(preference.getIntent());
            }
        }
    }

    /* renamed from: a */
    protected boolean m19666a(Preference preference) {
        return false;
    }
}
