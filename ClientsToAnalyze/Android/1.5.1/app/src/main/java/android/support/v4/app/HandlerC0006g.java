package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.v4.app.g */
/* loaded from: classes.dex */
class HandlerC0006g extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentActivity f45a;

    HandlerC0006g(FragmentActivity fragmentActivity) {
        this.f45a = fragmentActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f45a.mStopped) {
                    this.f45a.doReallyStop(false);
                    break;
                }
                break;
            case 2:
                this.f45a.mFragments.m113l();
                this.f45a.mFragments.m103d();
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }
}
