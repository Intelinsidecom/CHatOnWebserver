package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0254b;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.widget.C1619g;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.v */
/* loaded from: classes.dex */
class HandlerC1272v extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f4373a;

    HandlerC1272v(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f4373a = userProfileImageViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4373a.getActivity() != null) {
            if (this.f4373a.f4267j.isShowing()) {
                this.f4373a.f4267j.dismiss();
            }
            switch (message.what) {
                case 402:
                    if (((C0254b) message.obj).f604a) {
                        this.f4373a.getActivity().finish();
                        break;
                    } else {
                        C1619g.m5888a(this.f4373a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        this.f4373a.getActivity().finish();
                        break;
                    }
                case 403:
                    C0259g c0259g = (C0259g) message.obj;
                    if (c0259g.m927a() && c0259g.m927a()) {
                        this.f4373a.f4261d.setImageResource(R.drawable.propile_default_image);
                        this.f4373a.getActivity().finish();
                        break;
                    } else {
                        C1619g.m5888a(this.f4373a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        this.f4373a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
