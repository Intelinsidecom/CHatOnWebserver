package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1230h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4730a;

    DialogInterfaceOnClickListenerC1230h(BuddyDialog buddyDialog) {
        this.f4730a = buddyDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C2349a.m10301a("sms_feature")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("showSmsFunctionAlertDialog PREF_SETTING_USING_SMS_MMS_MODE set true", BuddyDialog.f4430a);
            }
            C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
            C2654bs.m11169a().m11187a(3, (Handler) null);
            C5179v.m19811a(this.f4730a.f4531z, this.f4730a.getResources().getString(R.string.sms_function_enabled), 0).show();
            this.f4730a.m7266e();
        }
    }
}
