package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0105f;
import com.sec.chaton.userprofile.UserProfileImageView;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.co */
/* loaded from: classes.dex */
class HandlerC1692co extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f6189a;

    HandlerC1692co(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f6189a = userProfileImageViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f6189a.getActivity() != null) {
            if (this.f6189a.f6096n.isShowing()) {
                this.f6189a.f6096n.dismiss();
            }
            switch (message.what) {
                case 402:
                    if (((C0105f) message.obj).f333a) {
                        this.f6189a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f6189a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        this.f6189a.getActivity().finish();
                        break;
                    }
                case HttpResponseCode.FORBIDDEN /* 403 */:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m664a() && c0101b.m664a()) {
                        this.f6189a.f6089g.setImageResource(R.drawable.mypage_noimage);
                        this.f6189a.getActivity().finish();
                        break;
                    } else {
                        Toast.makeText(this.f6189a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        this.f6189a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
