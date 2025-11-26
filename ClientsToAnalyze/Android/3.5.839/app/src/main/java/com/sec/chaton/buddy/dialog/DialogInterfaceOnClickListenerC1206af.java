package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.util.C4904y;
import java.util.HashMap;

/* compiled from: PhoneNumberSelectorDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1206af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberSelectorDialog f4701a;

    DialogInterfaceOnClickListenerC1206af(PhoneNumberSelectorDialog phoneNumberSelectorDialog) {
        this.f4701a = phoneNumberSelectorDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        try {
            if (this.f4701a.f4643d != 1) {
                if (this.f4701a.f4643d != 2) {
                    if (this.f4701a.f4643d != 3) {
                        if (this.f4701a.f4643d == 4) {
                            Intent intent = new Intent();
                            HashMap map = new HashMap();
                            String string = this.f4701a.f4642c.get(i).toString();
                            if (this.f4701a.f4649j != null) {
                                map.putAll(this.f4701a.f4649j);
                            }
                            map.put(string, this.f4701a.f4644e);
                            intent.putExtra("KEY_SELECTED_RESULT_FOR_COMPOSER", map);
                            this.f4701a.setResult(-1, intent);
                        }
                    } else {
                        this.f4701a.m7343b(this.f4701a.f4642c.get(i).toString());
                    }
                } else {
                    this.f4701a.m7340d(this.f4701a.f4642c.get(i).toString());
                }
            } else {
                this.f4701a.m7342a(this.f4701a.f4642c.get(i).toString());
            }
            this.f4701a.finish();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
