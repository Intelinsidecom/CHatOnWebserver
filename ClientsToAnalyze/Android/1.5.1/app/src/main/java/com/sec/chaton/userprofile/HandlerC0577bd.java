package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.userprofile.bd */
/* loaded from: classes.dex */
class HandlerC0577bd extends Handler {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyActivity f3559a;

    HandlerC0577bd(PhoneNumberPrivacyActivity phoneNumberPrivacyActivity) {
        this.f3559a = phoneNumberPrivacyActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f3559a.dismissDialog(0);
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            this.f3559a.f3341c.setChecked(ChatONPref.m3519a().getBoolean("show_phone_number_to_all", false));
            Toast.makeText(this.f3559a, this.f3559a.getResources().getString(C0062R.string.dev_network_error), 0).show();
        } else {
            ChatONPref.m3520a("show_phone_number_to_all", Boolean.valueOf(this.f3559a.f3341c.isChecked()));
            this.f3559a.finish();
        }
    }
}
