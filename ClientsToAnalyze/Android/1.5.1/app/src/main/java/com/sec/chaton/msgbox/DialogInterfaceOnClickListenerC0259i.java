package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.msgbox.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0259i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f1999a;

    /* renamed from: b */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0261k f2000b;

    DialogInterfaceOnClickListenerC0259i(MenuItemOnMenuItemClickListenerC0261k menuItemOnMenuItemClickListenerC0261k, EditText editText) {
        this.f2000b = menuItemOnMenuItemClickListenerC0261k;
        this.f1999a = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f1999a.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() != 0) {
            this.f2000b.f2002a.m2449a(this.f1999a.getText().toString(), this.f2000b.f2002a.f1982u);
        } else {
            Toast.makeText(this.f2000b.f2002a.getActivity(), C0062R.string.chatlist_title_update_fail, 0).show();
        }
    }
}
