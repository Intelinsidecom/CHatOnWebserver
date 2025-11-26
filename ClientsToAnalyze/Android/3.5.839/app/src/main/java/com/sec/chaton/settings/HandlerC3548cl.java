package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.cl */
/* loaded from: classes.dex */
class HandlerC3548cl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13037a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3548cl(ActivityPasswordLockSet activityPasswordLockSet, Looper looper) {
        super(looper);
        this.f13037a = activityPasswordLockSet;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f13037a.f12611x != null && this.f13037a.f12612y != null) {
            this.f13037a.f12612y.dismiss();
        }
        if (message.what == 1) {
            Toast.makeText(this.f13037a.f12611x, R.string.popup_not_enough_memory, 0).show();
        } else if (message.what == 2) {
            Toast.makeText(this.f13037a.f12611x, R.string.toast_dereg_failed, 0).show();
        }
    }
}
