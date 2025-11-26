package com.sec.chaton.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1346u;
import com.sec.widget.C1619g;
import java.io.IOException;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.i */
/* loaded from: classes.dex */
class C1077i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f3721a;

    C1077i(FragmentSkinChange2 fragmentSkinChange2) {
        this.f3721a = fragmentSkinChange2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws IOException {
        BaseAdapter baseAdapter = (BaseAdapter) adapterView.getAdapter();
        view.setSoundEffectsEnabled(true);
        view.playSoundEffect(0);
        view.setSoundEffectsEnabled(false);
        switch (i) {
            case 0:
                if (!C1346u.m4676a()) {
                    if (!C1327bw.m4595a() || this.f3721a.f3556u == null) {
                        if (this.f3721a.f3533O == null) {
                            this.f3721a.f3533O = C1619g.m5889a(this.f3721a.getActivity(), this.f3721a.getString(R.string.toast_sdcard_amount), 1);
                        }
                        this.f3721a.f3533O.show();
                        break;
                    } else {
                        this.f3721a.m3861a(this.f3721a.f3556u);
                        break;
                    }
                } else {
                    return;
                }
            default:
                this.f3721a.f3545j = (String) baseAdapter.getItem(i);
                if (this.f3721a.f3545j.equals("skin_myskin.png_")) {
                    this.f3721a.f3548m.setImageResource(android.R.color.transparent);
                    this.f3721a.m3865b();
                } else {
                    this.f3721a.f3548m.setImageResource(android.R.color.transparent);
                    this.f3721a.f3548m.setBackgroundDrawable(this.f3721a.m3855a(this.f3721a.f3545j));
                }
                view.findViewById(R.id.skin_bg).setSelected(true);
                break;
        }
        baseAdapter.notifyDataSetChanged();
    }
}
