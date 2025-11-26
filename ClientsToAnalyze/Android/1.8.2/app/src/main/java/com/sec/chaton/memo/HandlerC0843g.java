package com.sec.chaton.memo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.g */
/* loaded from: classes.dex */
class HandlerC0843g extends Handler {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f3094a;

    HandlerC0843g(WriteMemoActivity writeMemoActivity) {
        this.f3094a = writeMemoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f3094a.isFinishing()) {
            if (this.f3094a.f3073k.isShowing()) {
                this.f3094a.f3073k.dismiss();
            }
            switch (message.what) {
                case 903:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                        this.f3094a.setResult(-1);
                        this.f3094a.finish();
                        break;
                    } else {
                        new AlertDialog.Builder(this.f3094a).setMessage(this.f3094a.getResources().getString(R.string.setting_profile_update_status_failed)).setPositiveButton(this.f3094a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).setNegativeButton(this.f3094a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0844h(this)).show();
                        break;
                    }
                    break;
            }
        }
    }
}
