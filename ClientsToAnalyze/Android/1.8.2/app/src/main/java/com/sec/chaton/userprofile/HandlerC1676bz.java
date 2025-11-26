package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0105f;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1789u;
import com.sec.widget.AlertDialogBuilderC2120a;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.bz */
/* loaded from: classes.dex */
class HandlerC1676bz extends Handler {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6173a;

    HandlerC1676bz(UserProfileDetail userProfileDetail) {
        this.f6173a = userProfileDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f6173a.isFinishing()) {
            if (!this.f6173a.isFinishing() && this.f6173a.f6022E != null && this.f6173a.f6022E.isShowing() && !this.f6173a.f6072s) {
                this.f6173a.f6022E.dismiss();
                this.f6173a.f6029L = true;
            }
            switch (message.what) {
                case HttpResponseCode.NOT_MODIFIED /* 304 */:
                    C1789u.m6076a("show_phone_number_to_all", Boolean.valueOf(this.f6173a.f6037T.isChecked()));
                    break;
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m665b() == EnumC0803m.ERROR || !c0101b.m664a()) {
                        if (this.f6173a.f6022E.isShowing()) {
                            this.f6173a.f6022E.dismiss();
                        }
                        if (!this.f6173a.f6071r) {
                            this.f6173a.f6071r = true;
                        }
                        new AlertDialogBuilderC2120a(this.f6173a).setMessage(this.f6173a.getResources().getString(R.string.setting_profile_update_status_failed)).setNegativeButton(this.f6173a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1679cb(this)).setPositiveButton(this.f6173a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1678ca(this)).show();
                        break;
                    } else {
                        this.f6173a.m5751l();
                        if (!this.f6173a.isFinishing() && this.f6173a.f6022E != null && this.f6173a.f6022E.isShowing()) {
                            this.f6173a.f6022E.dismiss();
                        }
                        this.f6173a.finish();
                        break;
                    }
                    break;
                case 402:
                    if (((C0105f) message.obj).f333a) {
                        this.f6173a.m5759p();
                        break;
                    } else {
                        Toast.makeText(this.f6173a.f6028K, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                case HttpResponseCode.FORBIDDEN /* 403 */:
                    C0101b c0101b2 = (C0101b) message.obj;
                    if (!c0101b2.m664a() || !c0101b2.m664a()) {
                        Toast.makeText(this.f6173a.f6028K, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    } else {
                        this.f6173a.m5762r();
                        break;
                    }
                    break;
            }
            this.f6173a.invalidateOptionsMenu();
        }
    }
}
