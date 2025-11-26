package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.df */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1196df implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f4425a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4426b;

    DialogInterfaceOnClickListenerC1196df(BuddyFragment buddyFragment, boolean z) {
        this.f4426b = buddyFragment;
        this.f4425a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (C2349a.m10301a("sms_feature")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("showSmsFunctionAlertDialog PREF_SETTING_USING_SMS_MMS_MODE set true", BuddyFragment.f3576a);
            }
            C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
            C2654bs.m11169a().m11187a(3, (Handler) null);
            C5179v.m19811a(this.f4426b.getActivity(), this.f4426b.getResources().getString(R.string.sms_function_enabled), 0).show();
            this.f4426b.m6598c(this.f4425a);
        }
    }
}
