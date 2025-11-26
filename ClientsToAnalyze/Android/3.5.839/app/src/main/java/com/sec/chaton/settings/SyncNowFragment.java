package com.sec.chaton.settings;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class SyncNowFragment extends Fragment {
    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4904y.m18646e("onConfigurationChagne", getClass().getSimpleName());
        getFragmentManager().mo183a().mo101b(R.id.fragment_container, new SyncNowFragment(), "containter").mo99b();
    }
}
