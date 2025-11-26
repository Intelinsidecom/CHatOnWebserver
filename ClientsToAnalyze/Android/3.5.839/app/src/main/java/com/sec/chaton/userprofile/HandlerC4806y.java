package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.p070c.C2442i;
import com.sec.chaton.util.C4904y;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.y */
/* loaded from: classes.dex */
class HandlerC4806y extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17538a;

    HandlerC4806y(MyInfoFragment myInfoFragment) {
        this.f17538a = myInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[CoverStory] mFileUploadHandler()", MyInfoFragment.f17144c);
        }
        if (message == null) {
            if (this.f17538a.f17153I.isShowing()) {
                this.f17538a.f17153I.dismiss();
            }
            return;
        }
        switch (message.what) {
            case 1:
                C2442i c2442i = (C2442i) message.obj;
                if (c2442i != null) {
                    int i = message.arg1;
                    int i2 = message.arg2;
                    if (C4904y.f17871a) {
                        C4904y.m18646e("mFileUploadHandler/ nResultCode: " + i + " /nFaultCode: " + i2 + " /result.getResult(): " + c2442i.m10608a(), getClass().getSimpleName());
                    }
                    if (c2442i.m10608a()) {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("mFileUploadHandler / result.getResultUrl() : " + c2442i.m10610c(), getClass().getSimpleName());
                        }
                        this.f17538a.f17159O = C4754bm.m18054b(c2442i.m10610c());
                        this.f17538a.f17152H.m9539a(this.f17538a.f17159O.f17435a, this.f17538a.f17159O.f17436b);
                        break;
                    } else {
                        if (C4904y.f17871a) {
                            C4904y.m18646e(" coverstory mFileUploadHandler Fail", MyInfoFragment.f17144c);
                        }
                        if (this.f17538a.f17153I != null && this.f17538a.f17153I.isShowing()) {
                            this.f17538a.f17153I.dismiss();
                        }
                        int iM10677a = C2471v.m10677a(this.f17538a.getActivity().getApplicationContext());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            if (C4904y.f17871a) {
                                C4904y.m18646e("coverstory mFileUploadHandler NOT_CONNECTED or NOT_AVAILABLE netState : " + iM10677a, MyInfoFragment.f17144c);
                                break;
                            }
                        } else if (C4904y.f17871a) {
                            C4904y.m18646e("coverstory mFileUploadHandler fail network unable netState : " + iM10677a, MyInfoFragment.f17144c);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
