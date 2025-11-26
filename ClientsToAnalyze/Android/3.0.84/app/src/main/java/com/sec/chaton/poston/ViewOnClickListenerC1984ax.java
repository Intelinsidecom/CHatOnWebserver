package com.sec.chaton.poston;

import android.view.View;
import android.widget.CheckedTextView;

/* compiled from: PostONHideListFragment.java */
/* renamed from: com.sec.chaton.poston.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC1984ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONHideListFragment f7680a;

    ViewOnClickListenerC1984ax(PostONHideListFragment postONHideListFragment) {
        this.f7680a = postONHideListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((CheckedTextView) view).isChecked()) {
            this.f7680a.f7569i.setChecked(false);
            this.f7680a.f7571k.setEnabled(false);
            for (int i = 0; i < this.f7680a.f7563c.getCount(); i++) {
                this.f7680a.f7563c.setItemChecked(i, false);
            }
        } else {
            this.f7680a.f7569i.setChecked(true);
            this.f7680a.f7571k.setEnabled(true);
            for (int i2 = 0; i2 < this.f7680a.f7563c.getCount(); i2++) {
                this.f7680a.f7563c.setItemChecked(i2, true);
            }
        }
        this.f7680a.f7563c.invalidateViews();
    }
}
