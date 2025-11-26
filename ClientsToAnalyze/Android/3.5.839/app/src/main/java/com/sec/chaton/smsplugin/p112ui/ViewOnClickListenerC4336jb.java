package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: ThreadSelectionFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.jb */
/* loaded from: classes.dex */
class ViewOnClickListenerC4336jb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ThreadSelectionFragment f15766a;

    ViewOnClickListenerC4336jb(ThreadSelectionFragment threadSelectionFragment) {
        this.f15766a = threadSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f15766a.f15208y.toggle();
        if (this.f15766a.f15208y.isChecked()) {
            this.f15766a.f15209z = true;
            for (int i = 0; i < this.f15766a.f15206w.getCount(); i++) {
                this.f15766a.f15206w.setItemChecked(i, true);
            }
        } else {
            this.f15766a.f15209z = false;
            for (int i2 = 0; i2 < this.f15766a.f15206w.getCount(); i2++) {
                this.f15766a.f15206w.setItemChecked(i2, false);
            }
        }
        if (this.f15766a.f15206w.getCheckedItemIds().length > 0) {
            this.f15766a.f15178K.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(true);
        } else {
            this.f15766a.f15178K.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(false);
        }
        this.f15766a.f15206w.invalidateViews();
    }
}
