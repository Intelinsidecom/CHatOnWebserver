package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.av */
/* loaded from: classes.dex */
class HandlerC2977av extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11074a;

    HandlerC2977av(PostONDetailFragment postONDetailFragment) {
        this.f11074a = postONDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11074a.getActivity() != null && !this.f11074a.getActivity().isFinishing()) {
            switch (message.what) {
                case 0:
                    this.f11074a.m12223a(true);
                    this.f11074a.m12229b(true);
                    break;
                case 1:
                    this.f11074a.f10942ay.m18719a(message.arg1);
                    break;
                case 2:
                    if (this.f11074a.f10942ay != null && this.f11074a.f10942ay.isShowing()) {
                        this.f11074a.f10942ay.dismiss();
                    }
                    this.f11074a.m12223a(true);
                    this.f11074a.m12229b(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("FileDownloadTask.FILE_DOWNLOAD_DONE", PostONDetailFragment.f10885r);
                    }
                    this.f11074a.f10930al.m19023b(this.f11074a.f10888C, new CallableC2983ba(this.f11074a.f10897L, this.f11074a.f10890E, this.f11074a.f10898M.equals(C3009d.f11131b), CallableC2983ba.f11083c, CallableC2983ba.f11085e));
                    this.f11074a.getActivity().mo51u_();
                    break;
                case 3:
                case 4:
                    Toast.makeText(this.f11074a.getActivity(), R.string.media_download_fail, 0).show();
                    if (this.f11074a.f10942ay != null && this.f11074a.f10942ay.isShowing()) {
                        this.f11074a.f10942ay.dismiss();
                        break;
                    }
                    break;
            }
        }
    }
}
