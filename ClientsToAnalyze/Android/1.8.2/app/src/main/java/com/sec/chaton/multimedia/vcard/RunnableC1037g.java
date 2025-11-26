package com.sec.chaton.multimedia.vcard;

import android.os.Message;

/* compiled from: ContactPicker.java */
/* renamed from: com.sec.chaton.multimedia.vcard.g */
/* loaded from: classes.dex */
class RunnableC1037g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ContactPicker f3842a;

    RunnableC1037g(ContactPicker contactPicker) {
        this.f3842a = contactPicker;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageObtainMessage = this.f3842a.f3791f.obtainMessage();
        try {
            if (this.f3842a.f3790e.equals("")) {
                this.f3842a.f3787b = this.f3842a.m3998a((String) null);
                messageObtainMessage.what = 0;
            } else {
                this.f3842a.f3787b = this.f3842a.m3998a(this.f3842a.f3790e);
                messageObtainMessage.what = 1;
            }
        } catch (NullPointerException e) {
            messageObtainMessage.what = -1;
        } catch (OutOfMemoryError e2) {
            messageObtainMessage.what = -1;
        }
        this.f3842a.f3791f.sendMessage(messageObtainMessage);
    }
}
