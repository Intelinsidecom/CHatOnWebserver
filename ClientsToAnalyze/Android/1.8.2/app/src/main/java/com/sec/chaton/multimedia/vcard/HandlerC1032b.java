package com.sec.chaton.multimedia.vcard;

import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.b */
/* loaded from: classes.dex */
class HandlerC1032b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ContactPicker f3830a;

    HandlerC1032b(ContactPicker contactPicker) {
        this.f3830a = contactPicker;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f3830a.f3792g.getWindow() != null) {
            this.f3830a.f3792g.dismiss();
        }
        if (message.what == -1) {
            Toast.makeText(this.f3830a.getApplicationContext(), R.string.toast_error, 1).show();
            return;
        }
        this.f3830a.f3788c.setAdapter((ListAdapter) new C1036f(this.f3830a, this.f3830a.f3789d, this.f3830a.f3787b));
        if (message.what == 0) {
            this.f3830a.f3788c.setFastScrollEnabled(true);
            this.f3830a.f3788c.setOnItemClickListener(new C1033c(this));
        }
    }
}
