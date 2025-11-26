package com.sec.chaton.msgbox;

import android.app.AlertDialog;
import android.text.InputFilter;
import android.view.MenuItem;
import android.widget.EditText;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.msgbox.k */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0261k implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2002a;

    MenuItemOnMenuItemClickListenerC0261k(MsgboxFragment msgboxFragment) {
        this.f2002a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        EditText editText = new EditText(this.f2002a.getActivity());
        editText.setWidth(AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        if (this.f2002a.f1984w.length() >= 30) {
            this.f2002a.f1984w = this.f2002a.f1984w.substring(0, 30);
        }
        editText.addTextChangedListener(new C0258h(this));
        editText.setSingleLine();
        editText.setText(this.f2002a.f1984w);
        editText.setSelection(this.f2002a.f1984w.length());
        editText.setImeOptions(6);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        AlertDialog.Builder builderM2413a = this.f2002a.m2413a(editText);
        builderM2413a.setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0259i(this, editText));
        builderM2413a.setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0257g(this));
        AlertDialog alertDialogCreate = builderM2413a.create();
        alertDialogCreate.getWindow().setSoftInputMode(4);
        alertDialogCreate.show();
        return true;
    }
}
