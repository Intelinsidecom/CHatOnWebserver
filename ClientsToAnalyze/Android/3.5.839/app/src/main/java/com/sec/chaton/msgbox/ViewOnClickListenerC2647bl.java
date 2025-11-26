package com.sec.chaton.msgbox;

import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC2647bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f9505a;

    ViewOnClickListenerC2647bl(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f9505a = msgboxSelectionFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuItem menuItemFindItem;
        this.f9505a.f9412x.toggle();
        if (this.f9505a.f9412x.isChecked()) {
            this.f9505a.f9413y = true;
            for (int i = 0; i < this.f9505a.f9410v.getCount(); i++) {
                this.f9505a.f9410v.setItemChecked(i, true);
            }
        } else {
            this.f9505a.f9413y = false;
            for (int i2 = 0; i2 < this.f9505a.f9410v.getCount(); i2++) {
                this.f9505a.f9410v.setItemChecked(i2, false);
            }
        }
        if (this.f9505a.f9383K != null && (menuItemFindItem = this.f9505a.f9383K.findItem(R.id.msgbox_menu_delete_confirm)) != null) {
            if (this.f9505a.f9410v.getCheckedItemIds().length > 0) {
                menuItemFindItem.setEnabled(true);
            } else {
                menuItemFindItem.setEnabled(false);
            }
        }
        this.f9505a.f9410v.invalidateViews();
    }
}
