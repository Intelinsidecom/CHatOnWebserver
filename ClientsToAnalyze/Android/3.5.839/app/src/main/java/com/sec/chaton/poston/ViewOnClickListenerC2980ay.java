package com.sec.chaton.poston;

import android.view.View;
import android.widget.CheckedTextView;

/* compiled from: PostONHideListFragment.java */
/* renamed from: com.sec.chaton.poston.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC2980ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONHideListFragment f11076a;

    ViewOnClickListenerC2980ay(PostONHideListFragment postONHideListFragment) {
        this.f11076a = postONHideListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((CheckedTextView) view).isChecked()) {
            this.f11076a.f10960q.setChecked(false);
            this.f11076a.f10962s.setEnabled(false);
            for (int i = 0; i < this.f11076a.f10954k.getCount(); i++) {
                this.f11076a.f10954k.setItemChecked(i, false);
            }
        } else {
            this.f11076a.f10960q.setChecked(true);
            this.f11076a.f10962s.setEnabled(true);
            for (int i2 = 0; i2 < this.f11076a.f10954k.getCount(); i2++) {
                this.f11076a.f10954k.setItemChecked(i2, true);
            }
        }
        this.f11076a.f10954k.invalidateViews();
    }
}
