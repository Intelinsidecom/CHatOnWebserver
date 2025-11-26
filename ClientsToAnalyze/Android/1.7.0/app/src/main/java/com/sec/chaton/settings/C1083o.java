package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.o */
/* loaded from: classes.dex */
class C1083o implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3727a;

    C1083o(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3727a = fragmentSkinChange2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        view.findViewById(R.id.skin_bg).setSelected(true);
    }
}
