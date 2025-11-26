package com.sec.chaton.memo;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.d */
/* loaded from: classes.dex */
class HandlerC0731d extends Handler {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f2474a;

    HandlerC0731d(WriteMemoActivity writeMemoActivity) {
        this.f2474a = writeMemoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f2474a.isFinishing()) {
            if (this.f2474a.f2463f.isShowing()) {
                this.f2474a.f2463f.dismiss();
            }
            switch (message.what) {
                case 903:
                    C0259g c0259g = (C0259g) message.obj;
                    if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                        this.f2474a.setResult(-1);
                        this.f2474a.finish();
                        break;
                    } else {
                        new AlertDialogBuilderC1625m(this.f2474a).setMessage(this.f2474a.getResources().getString(R.string.setting_profile_update_status_failed)).setPositiveButton(this.f2474a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0728a(this)).setNegativeButton(this.f2474a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                        break;
                    }
                    break;
            }
        }
    }
}
