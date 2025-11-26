package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ar */
/* loaded from: classes.dex */
class HandlerC1978ar extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7675a;

    HandlerC1978ar(PostONDetailFragment postONDetailFragment) {
        this.f7675a = postONDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f7675a.getActivity() != null) {
            switch (message.what) {
                case 0:
                    this.f7675a.m7932a(true);
                    this.f7675a.m7937b(true);
                    break;
                case 1:
                    this.f7675a.f7546as.setProgress(message.arg1);
                    break;
                case 2:
                    if (this.f7675a.f7546as != null && this.f7675a.f7546as.isShowing()) {
                        this.f7675a.f7546as.dismiss();
                    }
                    this.f7675a.m7932a(true);
                    this.f7675a.m7937b(true);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("FileDownloadTask.FILE_DOWNLOAD_DONE", PostONDetailFragment.f7502p);
                    }
                    CallableC1986az callableC1986az = new CallableC1986az(this.f7675a.f7513K, this.f7675a.f7505C, this.f7675a.f7514L.equals(C2013d.f7735b), CallableC1986az.f7684c, CallableC1986az.f7686e);
                    if (callableC1986az != null) {
                        this.f7675a.f7540al.m11730a(this.f7675a.f7503A, callableC1986az);
                    }
                    this.f7675a.getActivity().supportInvalidateOptionsMenu();
                    break;
                case 3:
                case 4:
                    if (this.f7675a.f7546as != null && this.f7675a.f7546as.isShowing()) {
                        this.f7675a.f7546as.dismiss();
                        break;
                    }
                    break;
            }
        }
    }
}
