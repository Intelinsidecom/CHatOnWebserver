package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class EmptyAniconView extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    private Activity f3452a;

    /* renamed from: b */
    private View f3453b;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_empty_anicon_container, viewGroup, false);
        this.f3453b = viewInflate.findViewById(R.id.aniconDownloadButton);
        this.f3453b.setOnClickListener(this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3452a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3452a = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AniconPackageListView(), "container").commit();
        getActivity().findViewById(R.id.base_divider).setVisibility(0);
    }
}
