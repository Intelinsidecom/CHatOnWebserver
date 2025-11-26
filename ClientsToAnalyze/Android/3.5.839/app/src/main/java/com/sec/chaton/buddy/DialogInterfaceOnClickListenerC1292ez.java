package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ez */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1292ez implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4828a;

    DialogInterfaceOnClickListenerC1292ez(BuddyInfoFragment buddyInfoFragment) {
        this.f4828a = buddyInfoFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C2349a.m10301a("sms_feature")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("showSmsFunctionAlertDialog PREF_SETTING_USING_SMS_MMS_MODE set true", BuddyInfoFragment.f3830j);
            }
            C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
            C2654bs.m11169a().m11187a(3, (Handler) null);
            C5179v.m19811a(this.f4828a.f3845O, this.f4828a.getResources().getString(R.string.sms_function_enabled), 0).show();
            this.f4828a.m6734b();
        }
    }
}
