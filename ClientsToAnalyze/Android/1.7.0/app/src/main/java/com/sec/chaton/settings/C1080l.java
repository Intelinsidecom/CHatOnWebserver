package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.sec.chaton.R;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.l */
/* loaded from: classes.dex */
class C1080l implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3724a;

    C1080l(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3724a = fragmentSkinChange2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        view.findViewById(R.id.skin_bubble).setSelected(true);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
        ((BaseAdapter) adapterView.getAdapter()).notifyDataSetChanged();
    }
}
