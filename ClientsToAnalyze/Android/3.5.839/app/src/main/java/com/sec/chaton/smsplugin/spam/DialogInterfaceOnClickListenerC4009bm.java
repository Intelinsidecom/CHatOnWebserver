package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: SetupSpamNumberWriteForm.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4009bm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberWriteForm f14462a;

    DialogInterfaceOnClickListenerC4009bm(SetupSpamNumberWriteForm setupSpamNumberWriteForm) {
        this.f14462a = setupSpamNumberWriteForm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f14462a.f14387l = i;
        dialogInterface.dismiss();
        String[] stringArray = this.f14462a.getResources().getStringArray(R.array.pref_entries_spam_match_criteria);
        this.f14462a.f14382e = (TextView) this.f14462a.findViewById(R.id.text_sub);
        this.f14462a.f14382e.setText(stringArray[this.f14462a.f14387l]);
    }
}
