package com.sec.chaton.updates;

import android.view.View;
import android.widget.CheckedTextView;

/* compiled from: UpdatesSelectionFragment.java */
/* renamed from: com.sec.chaton.updates.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC4712s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpdatesSelectionFragment f17072a;

    ViewOnClickListenerC4712s(UpdatesSelectionFragment updatesSelectionFragment) {
        this.f17072a = updatesSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((CheckedTextView) view).isChecked()) {
            this.f17072a.f16990k.setChecked(false);
            this.f17072a.f17000u.setEnabled(false);
            for (int i = 0; i < this.f17072a.f16991l.getCount(); i++) {
                this.f17072a.f16991l.setItemChecked(i, false);
            }
        } else {
            this.f17072a.f16990k.setChecked(true);
            this.f17072a.f17000u.setEnabled(true);
            for (int i2 = 0; i2 < this.f17072a.f16991l.getCount(); i2++) {
                this.f17072a.f16991l.setItemChecked(i2, true);
            }
        }
        this.f17072a.f16991l.invalidateViews();
    }
}
