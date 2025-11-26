package com.sec.common.p123a;

import android.os.Message;
import android.view.View;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC4938g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC4937f f18070a;

    ViewOnClickListenerC4938g(DialogC4937f dialogC4937f) {
        this.f18070a = dialogC4937f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message messageObtain = null;
        if (view != this.f18070a.f18036L || this.f18070a.f18069z == null) {
            if (view != this.f18070a.f18037M || this.f18070a.f18027C == null) {
                if (view == this.f18070a.f18038N && this.f18070a.f18030F != null) {
                    messageObtain = Message.obtain(this.f18070a.f18030F);
                }
            } else {
                messageObtain = Message.obtain(this.f18070a.f18027C);
            }
        } else {
            messageObtain = Message.obtain(this.f18070a.f18069z);
        }
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        this.f18070a.f18042R.obtainMessage(1, this.f18070a).sendToTarget();
    }
}
