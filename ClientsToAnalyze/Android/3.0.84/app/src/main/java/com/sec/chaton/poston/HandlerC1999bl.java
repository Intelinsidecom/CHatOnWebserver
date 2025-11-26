package com.sec.chaton.poston;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bl */
/* loaded from: classes.dex */
class HandlerC1999bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7714a;

    HandlerC1999bl(PostONWriteFragment postONWriteFragment) {
        this.f7714a = postONWriteFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        String str3 = null;
        if (this.f7714a.getActivity() != null && !this.f7714a.getActivity().isFinishing()) {
            switch (message.what) {
                case 902:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f7714a.f7578D != null && this.f7714a.f7578D.isShowing()) {
                        this.f7714a.f7578D.dismiss();
                    }
                    if (this.f7714a.f7577C != null && this.f7714a.f7577C.isShowing()) {
                        this.f7714a.f7577C.dismiss();
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                        C3250y.m11456e("HTTP Success", getClass().getSimpleName());
                        if (this.f7714a.f7630v.getText().toString() != null) {
                            this.f7714a.f7630v.setText((CharSequence) null);
                        }
                        if (this.f7714a.getActivity() != null && !this.f7714a.getActivity().isFinishing()) {
                            Toast.makeText(this.f7714a.getActivity(), R.string.facebook_post_completed, 0).show();
                        }
                        GetPostONList getPostONList = (GetPostONList) c0267d.m1354e();
                        if (getPostONList.postonlist.size() > 0) {
                            str2 = getPostONList.postonlist.get(0).hasmore;
                            str = getPostONList.postonlist.get(0).endtime;
                            str3 = getPostONList.postonlist.get(0).isblind;
                        } else {
                            str = null;
                            str2 = null;
                        }
                        ((InterfaceC2009bv) this.f7714a.getActivity()).mo7977a(this.f7714a.f7585K, str2, str, str3);
                        break;
                    } else if (c0267d.m1355f() == 90009) {
                        this.f7714a.f7579E = AbstractC3271a.m11494a(this.f7714a.getActivity()).mo11500a(this.f7714a.getResources().getString(R.string.poston_title)).mo11509b(this.f7714a.getResources().getString(R.string.poston_duplicated)).mo11510b(this.f7714a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2000bm(this)).mo11512b();
                        break;
                    } else if (c0267d.m1355f() == 50005) {
                        this.f7714a.f7579E = AbstractC3271a.m11494a(this.f7714a.getActivity()).mo11500a(this.f7714a.getResources().getString(R.string.poston_title)).mo11509b(this.f7714a.getResources().getString(R.string.samsung_account_mapping_not_finished)).mo11510b(this.f7714a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2001bn(this)).mo11512b();
                        break;
                    } else if (c0267d.m1355f() == 91003) {
                        Toast.makeText(this.f7714a.getActivity(), R.string.poston_not_allowed_writing, 1).show();
                        ((InterfaceC2009bv) this.f7714a.getActivity()).mo7978c();
                        break;
                    } else {
                        this.f7714a.f7579E = AbstractC3271a.m11494a(this.f7714a.getActivity()).mo11495a(R.string.poston_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2003bp(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2002bo(this)).mo11512b();
                        break;
                    }
                    break;
            }
        }
    }
}
