package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.widget.C2153y;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.g */
/* loaded from: classes.dex */
class C0416g implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1577a;

    C0416g(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1577a = addBuddyFragment;
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
        AddBuddyActivity addBuddyActivity = (AddBuddyActivity) this.f1577a.getActivity();
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
                }
            } else {
                if (menuItemFindItem != null) {
                    menuItemFindItem.setVisible(false).setEnabled(false);
                }
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setVisible(true).setEnabled(false);
                }
            }
        }
        if (charSequence.length() == 20) {
            C2153y.m7535a(this.f1577a.getActivity(), R.string.toast_text_max_Length, 0).show();
        }
    }
}
