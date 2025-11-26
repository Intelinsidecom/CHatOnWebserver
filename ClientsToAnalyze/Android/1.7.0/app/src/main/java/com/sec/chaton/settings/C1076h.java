package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.sec.chaton.R;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.h */
/* loaded from: classes.dex */
class C1076h implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3720a;

    C1076h(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3720a = fragmentSkinChange2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        BaseAdapter baseAdapter = (BaseAdapter) adapterView.getAdapter();
        view.setSoundEffectsEnabled(true);
        view.playSoundEffect(0);
        view.setSoundEffectsEnabled(false);
        this.f3720a.f3547l = (String) baseAdapter.getItem(i);
        if (this.f3720a.f3550o != null) {
            this.f3720a.f3550o.setBackgroundResource(this.f3720a.m3870d(this.f3720a.f3547l));
        }
        view.findViewById(R.id.skin_bubble).setSelected(true);
        baseAdapter.notifyDataSetChanged();
    }
}
