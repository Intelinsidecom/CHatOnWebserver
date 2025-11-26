package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1702af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f6348a;

    ViewOnClickListenerC1702af(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f6348a = msgboxSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6348a.f6309l.toggle();
        if (this.f6348a.f6309l.isChecked()) {
            this.f6348a.f6311n = true;
            for (int i = 0; i < this.f6348a.f6307j.getCount(); i++) {
                this.f6348a.f6307j.setItemChecked(i, true);
            }
        } else {
            this.f6348a.f6311n = false;
            for (int i2 = 0; i2 < this.f6348a.f6307j.getCount(); i2++) {
                this.f6348a.f6307j.setItemChecked(i2, false);
            }
        }
        if (this.f6348a.f6307j.getCheckedItemIds().length > 0) {
            this.f6348a.f6293F.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(true);
        } else {
            this.f6348a.f6293F.findItem(R.id.msgbox_menu_delete_confirm).setEnabled(false);
        }
        this.f6348a.f6307j.invalidateViews();
    }
}
