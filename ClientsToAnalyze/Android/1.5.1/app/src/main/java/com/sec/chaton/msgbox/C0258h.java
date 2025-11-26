package com.sec.chaton.msgbox;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.msgbox.h */
/* loaded from: classes.dex */
class C0258h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0261k f1998a;

    C0258h(MenuItemOnMenuItemClickListenerC0261k menuItemOnMenuItemClickListenerC0261k) {
        this.f1998a = menuItemOnMenuItemClickListenerC0261k;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 30) {
            Toast.makeText(this.f1998a.f2002a.getActivity(), C0062R.string.toast_text_max_Length, 0).show();
        }
    }
}
