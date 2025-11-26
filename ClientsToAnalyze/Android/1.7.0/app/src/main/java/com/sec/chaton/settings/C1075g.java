package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.sec.chaton.R;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.g */
/* loaded from: classes.dex */
class C1075g implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3719a;

    C1075g(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3719a = fragmentSkinChange2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        BaseAdapter baseAdapter = (BaseAdapter) adapterView.getAdapter();
        view.setSoundEffectsEnabled(true);
        view.playSoundEffect(0);
        view.setSoundEffectsEnabled(false);
        this.f3719a.f3546k = (String) baseAdapter.getItem(i);
        if (this.f3719a.f3549n != null) {
            this.f3719a.f3549n.setBackgroundResource(this.f3719a.m3866c(this.f3719a.f3546k));
        }
        view.findViewById(R.id.skin_bubble).setSelected(true);
        baseAdapter.notifyDataSetChanged();
    }
}
