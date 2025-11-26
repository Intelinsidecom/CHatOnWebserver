package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.f */
/* loaded from: classes.dex */
class C0396f implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1555a;

    C0396f(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1555a = addBuddyFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() == 1 && editable.toString().trim().length() == 0) {
            editable.clear();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Menu menuM1860c;
        AddBuddyActivity addBuddyActivity = (AddBuddyActivity) this.f1555a.getActivity();
        if (addBuddyActivity != null && (menuM1860c = addBuddyActivity.m1860c()) != null) {
            boolean z = !TextUtils.isEmpty(charSequence);
            MenuItem menuItemFindItem = menuM1860c.findItem(R.id.actionbar_title_done);
            MenuItem menuItemFindItem2 = menuM1860c.findItem(R.id.actionbar_title_done_dim);
            if (z) {
                if (menuItemFindItem != null) {
                    menuItemFindItem.setVisible(true).setEnabled(true);
                }
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setVisible(false).setEnabled(false);
                    return;
                }
                return;
            }
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false).setEnabled(false);
            }
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(true).setEnabled(false);
            }
        }
    }
}
