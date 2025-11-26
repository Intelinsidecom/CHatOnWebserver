package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bm */
/* loaded from: classes.dex */
class HandlerC2995bm extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11110a;

    HandlerC2995bm(PostONWriteFragment postONWriteFragment) {
        this.f11110a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        String str3 = null;
        if (this.f11110a.getActivity() != null && !this.f11110a.getActivity().isFinishing()) {
            switch (message.what) {
                case 902:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f11110a.f10974F != null && this.f11110a.f10974F.isShowing()) {
                        this.f11110a.f10974F.dismiss();
                    }
                    if (this.f11110a.f10973E != null && this.f11110a.f10973E.isShowing()) {
                        this.f11110a.f10973E.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        this.f11110a.f10996ac = false;
                        C4904y.m18646e("HTTP Success", getClass().getSimpleName());
                        if (this.f11110a.f11028w.getText().toString() != null) {
                            this.f11110a.f11028w.setText((CharSequence) null);
                        }
                        if (this.f11110a.getActivity() != null && !this.f11110a.getActivity().isFinishing()) {
                            Toast.makeText(this.f11110a.getActivity(), R.string.facebook_post_completed, 0).show();
                        }
                        GetPostONList getPostONList = (GetPostONList) c0778b.m3110e();
                        if (getPostONList.postonlist.size() > 0) {
                            str2 = getPostONList.postonlist.get(0).hasmore;
                            str = getPostONList.postonlist.get(0).endtime;
                            str3 = getPostONList.postonlist.get(0).isblind;
                        } else {
                            str = null;
                            str2 = null;
                        }
                        ((InterfaceC3005bw) this.f11110a.getActivity()).mo12287a(this.f11110a.f10981M, str2, str, str3);
                        break;
                    } else if (c0778b.m3111f() == 90009) {
                        if (this.f11110a.f10996ac) {
                            this.f11110a.f10996ac = false;
                            C4904y.m18646e("WRITE_POSTON_DUPLICATED_PREVIOUS_ONE: mResponseErr true", getClass().getSimpleName());
                            ((InterfaceC3005bw) this.f11110a.getActivity()).mo12288h();
                            break;
                        } else {
                            this.f11110a.f10996ac = false;
                            this.f11110a.f10975G = AbstractC4932a.m18733a(this.f11110a.getActivity()).mo18740a(this.f11110a.getResources().getString(R.string.poston_title)).mo18749b(this.f11110a.getResources().getString(R.string.poston_duplicated)).mo18755c(this.f11110a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2996bn(this)).mo18752b();
                            break;
                        }
                    } else if (c0778b.m3111f() == 50005) {
                        this.f11110a.f10996ac = false;
                        this.f11110a.f10975G = AbstractC4932a.m18733a(this.f11110a.getActivity()).mo18740a(this.f11110a.getResources().getString(R.string.poston_title)).mo18749b(this.f11110a.getResources().getString(R.string.samsung_account_mapping_not_finished)).mo18755c(this.f11110a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2997bo(this)).mo18752b();
                        break;
                    } else if (c0778b.m3111f() == 91003) {
                        this.f11110a.f10996ac = false;
                        Toast.makeText(this.f11110a.getActivity(), R.string.poston_not_allowed_writing, 1).show();
                        ((InterfaceC3005bw) this.f11110a.getActivity()).mo12288h();
                        break;
                    } else {
                        this.f11110a.f10996ac = true;
                        if (this.f11110a.f10975G == null || !this.f11110a.f10975G.isShowing()) {
                            this.f11110a.f10975G = AbstractC4932a.m18733a(this.f11110a.getActivity()).mo18734a(R.string.poston_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(false).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2999bq(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2998bp(this)).mo18752b();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
