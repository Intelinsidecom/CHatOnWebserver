package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* compiled from: FragmentActivity.java */
/* renamed from: android.support.v4.app.r */
/* loaded from: classes.dex */
class HandlerC0064r extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentActivity f199a;

    HandlerC0064r(FragmentActivity fragmentActivity) {
        this.f199a = fragmentActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f199a.f49f) {
                    this.f199a.m46a(false);
                    break;
                }
                break;
            case 2:
                this.f199a.m48a_();
                this.f199a.f45b.m228f();
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }
}
