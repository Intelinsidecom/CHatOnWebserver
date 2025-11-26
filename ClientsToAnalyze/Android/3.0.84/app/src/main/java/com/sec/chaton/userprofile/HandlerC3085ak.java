package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.p040c.C1565k;
import com.sec.chaton.util.C3250y;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ak */
/* loaded from: classes.dex */
class HandlerC3085ak extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11297a;

    HandlerC3085ak(MyPageFragment myPageFragment) {
        this.f11297a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[CoverStory] mFileUploadHandler()", MyPageFragment.f11095a);
        }
        if (message == null) {
            if (this.f11297a.f11179k.isShowing()) {
                this.f11297a.f11179k.dismiss();
            }
            return;
        }
        switch (message.what) {
            case 1:
                C1565k c1565k = (C1565k) message.obj;
                if (c1565k != null) {
                    int i = message.arg1;
                    int i2 = message.arg2;
                    if (C3250y.f11733a) {
                        C3250y.m11456e("mFileUploadHandler/ nResultCode: " + i + " /nFaultCode: " + i2 + " /result.getResult(): " + c1565k.m6664a(), getClass().getSimpleName());
                    }
                    if (c1565k.m6664a()) {
                        if (C3250y.f11733a) {
                            C3250y.m11456e("mFileUploadHandler / result.getResultUrl() : " + c1565k.m6666c(), getClass().getSimpleName());
                        }
                        this.f11297a.f11131aI = this.f11297a.m10735g(c1565k.m6666c());
                        this.f11297a.f11182n.m5759a(this.f11297a.f11131aI.f11324a, this.f11297a.f11131aI.f11325b);
                        break;
                    } else {
                        if (C3250y.f11733a) {
                            C3250y.m11456e(" coverstory mFileUploadHandler Fail", MyPageFragment.f11095a);
                        }
                        if (this.f11297a.f11179k != null && this.f11297a.f11179k.isShowing()) {
                            this.f11297a.f11179k.dismiss();
                        }
                        int iM6733a = C1594v.m6733a(this.f11297a.getActivity().getApplicationContext());
                        if (-3 == iM6733a || -2 == iM6733a) {
                            if (C3250y.f11733a) {
                                C3250y.m11456e("coverstory mFileUploadHandler NOT_CONNECTED or NOT_AVAILABLE netState : " + iM6733a, MyPageFragment.f11095a);
                                break;
                            }
                        } else if (C3250y.f11733a) {
                            C3250y.m11456e("coverstory mFileUploadHandler fail network unable netState : " + iM6733a, MyPageFragment.f11095a);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
