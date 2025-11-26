package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p067j.p070c.C2442i;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bl */
/* loaded from: classes.dex */
class HandlerC2994bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11109a;

    HandlerC2994bl(PostONWriteFragment postONWriteFragment) {
        this.f11109a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = 0;
        if (message != null && this.f11109a.isAdded() && this.f11109a.getActivity() != null && !this.f11109a.getActivity().isFinishing()) {
            int i2 = message.what;
            this.f11109a.f11008c = 0;
            switch (i2) {
                case 1:
                    C2442i c2442i = (C2442i) message.obj;
                    if (this.f11109a.f10998ae) {
                        this.f11109a.f10998ae = false;
                    }
                    if (c2442i != null) {
                        int i3 = message.arg1;
                        C4904y.m18646e("mFileUploadHandler/ nResultCode: " + i3 + " /nFaultCode: " + message.arg2 + " /result.getResult(): " + c2442i.m10608a(), getClass().getSimpleName());
                        if (i3 == 8) {
                            if (c2442i.m10608a()) {
                                if (this.f11109a.f10973E != null) {
                                    if (this.f11109a.f10973E == null || this.f11109a.f10973E.isShowing()) {
                                        C4904y.m18646e("mFileUploadHandler / result.getResultUrl() : " + c2442i.m10610c(), getClass().getSimpleName());
                                        this.f11109a.f11007b++;
                                        this.f11109a.f10973E.m18719a(100);
                                        this.f11109a.f10992X = c2442i.m10610c();
                                        String[] strArrSplit = this.f11109a.f10992X.split("\n");
                                        if (!TextUtils.isEmpty(strArrSplit[1])) {
                                            while (true) {
                                                if (i < this.f11109a.f10987S.size()) {
                                                    if (((PreviewData) this.f11109a.f10987S.get(i)).m11985g() == null) {
                                                        ((PreviewData) this.f11109a.f10987S.get(i)).m11981c(this.f11109a.f10992X.split("\n")[r3.length - 2]);
                                                        if (C4904y.f17871a) {
                                                            C4904y.m18646e("yeseul / mPreviewData.get(index).getFileName(): " + ((PreviewData) this.f11109a.f10987S.get(i)).m11985g(), getClass().getSimpleName());
                                                        }
                                                    }
                                                    if (!((PreviewData) this.f11109a.f10987S.get(i)).m11985g().equals(strArrSplit[1])) {
                                                        i++;
                                                    } else {
                                                        if (C4904y.f17871a) {
                                                            C4904y.m18646e("is Equal >> mPreviewData.get(index): " + ((PreviewData) this.f11109a.f10987S.get(i)).m11985g() + " /strArray[1]:" + strArrSplit[1], getClass().getSimpleName());
                                                        }
                                                        ((PreviewData) this.f11109a.f10987S.get(i)).m11979b(this.f11109a.f10992X);
                                                    }
                                                }
                                            }
                                        }
                                        if (this.f11109a.f11007b + this.f11109a.f11008c == this.f11109a.f10987S.size()) {
                                            this.f11109a.m12326h();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.f11109a.f11008c++;
                                if (C4904y.f17871a) {
                                    C4904y.m18646e("numUploadFail : " + this.f11109a.f11008c, getClass().getSimpleName());
                                }
                                if (this.f11109a.f11007b + this.f11109a.f11008c == this.f11109a.f10987S.size()) {
                                    this.f11109a.m12326h();
                                    break;
                                }
                            }
                        } else {
                            if (C4904y.f17871a) {
                                C4904y.m18646e("Failed or Canceled", getClass().getSimpleName());
                            }
                            if (this.f11109a.f10973E != null && this.f11109a.f10973E.isShowing()) {
                                this.f11109a.f10973E.dismiss();
                            }
                            C5179v.m19810a(this.f11109a.getActivity(), R.string.toast_file_upload_fail, 0).show();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
