package com.sec.chaton.multimedia.vcard;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.d */
/* loaded from: classes.dex */
class C1034d implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ContactPicker f3832a;

    C1034d(ContactPicker contactPicker) {
        this.f3832a = contactPicker;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strTrim = charSequence.toString().trim();
        if (charSequence.length() >= 512) {
            Toast.makeText(this.f3832a, R.string.toast_text_max_Length, 0).show();
        }
        if (strTrim.length() != 0) {
            this.f3832a.f3790e = "display_name like '%" + strTrim + "%'";
        } else {
            this.f3832a.f3790e = "";
        }
        this.f3832a.f3792g.show();
        Thread thread = new Thread(new RunnableC1037g(this.f3832a));
        thread.setDaemon(true);
        thread.start();
    }
}
