package com.sec.common.p063a;

import android.os.Message;
import android.view.View;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC3276f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3275e f11871a;

    ViewOnClickListenerC3276f(DialogC3275e dialogC3275e) {
        this.f11871a = dialogC3275e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message messageObtain = null;
        if (view != this.f11871a.f11837L || this.f11871a.f11870z == null) {
            if (view != this.f11871a.f11838M || this.f11871a.f11828C == null) {
                if (view == this.f11871a.f11839N && this.f11871a.f11831F != null) {
                    messageObtain = Message.obtain(this.f11871a.f11831F);
                }
            } else {
                messageObtain = Message.obtain(this.f11871a.f11828C);
            }
        } else {
            messageObtain = Message.obtain(this.f11871a.f11870z);
        }
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        this.f11871a.f11843R.obtainMessage(1, this.f11871a).sendToTarget();
    }
}
