package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bm */
/* loaded from: classes.dex */
class HandlerC2452bm extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2452bm(ActivityPasswordLockSet activityPasswordLockSet, Looper looper) {
        super(looper);
        this.f9312a = activityPasswordLockSet;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f9312a.f9046u != null && this.f9312a.f9047v != null) {
            this.f9312a.f9047v.dismiss();
        }
        if (message.what == 1) {
            Toast.makeText(this.f9312a.f9046u, R.string.popup_not_enough_memory, 0).show();
        } else if (message.what == 2) {
            Toast.makeText(this.f9312a.f9046u, R.string.toast_dereg_failed, 0).show();
        }
    }
}
