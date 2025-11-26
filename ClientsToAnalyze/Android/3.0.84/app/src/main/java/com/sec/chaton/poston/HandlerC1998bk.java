package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p037j.p040c.C1565k;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bk */
/* loaded from: classes.dex */
class HandlerC1998bk extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7713a;

    HandlerC1998bk(PostONWriteFragment postONWriteFragment) {
        this.f7713a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = 0;
        if (message != null && this.f7713a.getActivity() != null && !this.f7713a.getActivity().isFinishing()) {
            int i2 = message.what;
            this.f7713a.f7611c = 0;
            switch (i2) {
                case 1:
                    C1565k c1565k = (C1565k) message.obj;
                    if (this.f7713a.f7601ab) {
                        this.f7713a.f7601ab = false;
                    }
                    if (c1565k != null) {
                        int i3 = message.arg1;
                        C3250y.m11456e("mFileUploadHandler/ nResultCode: " + i3 + " /nFaultCode: " + message.arg2 + " /result.getResult(): " + c1565k.m6664a(), getClass().getSimpleName());
                        if (i3 == 8) {
                            if (c1565k.m6664a()) {
                                if (this.f7713a.f7577C != null) {
                                    if (this.f7713a.f7577C == null || this.f7713a.f7577C.isShowing()) {
                                        C3250y.m11456e("mFileUploadHandler / result.getResultUrl() : " + c1565k.m6666c(), getClass().getSimpleName());
                                        this.f7713a.f7610b++;
                                        this.f7713a.f7577C.m11483a(100);
                                        this.f7713a.f7596V = c1565k.m6666c();
                                        String[] strArrSplit = this.f7713a.f7596V.split("\n");
                                        if (strArrSplit[1] != null && !strArrSplit[1].isEmpty()) {
                                            while (true) {
                                                if (i < this.f7713a.f7591Q.size()) {
                                                    if (((PreviewData) this.f7713a.f7591Q.get(i)).m7755g() == null) {
                                                        ((PreviewData) this.f7713a.f7591Q.get(i)).m7751c(this.f7713a.f7596V.split("\n")[r3.length - 2]);
                                                        if (C3250y.f11733a) {
                                                            C3250y.m11456e("yeseul / mPreviewData.get(index).getFileName(): " + ((PreviewData) this.f7713a.f7591Q.get(i)).m7755g(), getClass().getSimpleName());
                                                        }
                                                    }
                                                    if (!((PreviewData) this.f7713a.f7591Q.get(i)).m7755g().equals(strArrSplit[1])) {
                                                        i++;
                                                    } else {
                                                        if (C3250y.f11733a) {
                                                            C3250y.m11456e("is Equal >> mPreviewData.get(index): " + ((PreviewData) this.f7713a.f7591Q.get(i)).m7755g() + " /strArray[1]:" + strArrSplit[1], getClass().getSimpleName());
                                                        }
                                                        ((PreviewData) this.f7713a.f7591Q.get(i)).m7749b(this.f7713a.f7596V);
                                                    }
                                                }
                                            }
                                        }
                                        if (this.f7713a.f7610b + this.f7713a.f7611c == this.f7713a.f7591Q.size()) {
                                            this.f7713a.m8005f();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.f7713a.f7611c++;
                                if (C3250y.f11733a) {
                                    C3250y.m11456e("numUploadFail : " + this.f7713a.f7611c, getClass().getSimpleName());
                                }
                                if (this.f7713a.f7610b + this.f7713a.f7611c == this.f7713a.f7591Q.size()) {
                                    this.f7713a.m8005f();
                                    break;
                                }
                            }
                        } else {
                            if (C3250y.f11733a) {
                                C3250y.m11456e("Failed or Canceled", getClass().getSimpleName());
                            }
                            if (this.f7713a.f7577C != null && this.f7713a.f7577C.isShowing()) {
                                this.f7713a.f7577C.dismiss();
                            }
                            C3641ai.m13210a(this.f7713a.getActivity(), R.string.toast_file_upload_fail, 0).show();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
