package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0105f;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.ae */
/* loaded from: classes.dex */
class HandlerC1628ae extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6115a;

    HandlerC1628ae(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6115a = myPageFragmentTablet;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 402:
                if (this.f6115a.f5899v != null) {
                    this.f6115a.f5899v.dismiss();
                }
                if (((C0105f) message.obj).f333a) {
                    this.f6115a.m5635i();
                    break;
                } else {
                    Toast.makeText(this.f6115a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                }
            case HttpResponseCode.FORBIDDEN /* 403 */:
                if (this.f6115a.f5899v != null) {
                    this.f6115a.f5899v.dismiss();
                }
                C0101b c0101b = (C0101b) message.obj;
                if (c0101b.m664a() && c0101b.m664a()) {
                    this.f6115a.f5893p.setImageResource(R.drawable.msg_list_id_default);
                    break;
                } else {
                    Toast.makeText(this.f6115a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                }
                break;
        }
    }
}
