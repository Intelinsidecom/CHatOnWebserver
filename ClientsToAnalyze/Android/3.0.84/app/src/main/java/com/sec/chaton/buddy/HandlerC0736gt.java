package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gt */
/* loaded from: classes.dex */
class HandlerC0736gt extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2990a;

    HandlerC0736gt(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2990a = buddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String string2;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f2990a.getActivity() != null) {
            if (this.f2990a.f2220f != null) {
                this.f2990a.f2220f.dismiss();
            }
            if (message.what == 103) {
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    this.f2990a.f2227m.setVisibility(8);
                    if (this.f2990a.getActivity() != null) {
                        C3641ai.m13211a(this.f2990a.getActivity(), this.f2990a.getResources().getString(R.string.done), 0).show();
                    }
                    this.f2990a.getActivity().finish();
                    return;
                }
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a || -2 == iM6733a) {
                    string2 = this.f2990a.getResources().getString(R.string.popup_no_network_connection);
                } else if (c0267d.m1355f() == 16003) {
                    string2 = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0267d.m1355f() == 16004) {
                    string2 = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0267d.m1355f() == 16005) {
                    string2 = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else if (c0267d.m1355f() == 50005) {
                    string2 = this.f2990a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                } else {
                    string2 = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                C3641ai.m13211a(this.f2990a.getActivity(), string2, 0).show();
                return;
            }
            if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                int iM6733a2 = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a2 || -2 == iM6733a2) {
                    string = this.f2990a.getResources().getString(R.string.popup_no_network_connection);
                } else if (c0267d.m1355f() == 16003) {
                    string = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0267d.m1355f() == 16004) {
                    string = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0267d.m1355f() == 16005) {
                    string = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else if (c0267d.m1355f() == 50005) {
                    string = this.f2990a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                } else {
                    string = this.f2990a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                C3641ai.m13211a(this.f2990a.getActivity(), string, 0).show();
                return;
            }
            C3641ai.m13211a(this.f2990a.getActivity(), this.f2990a.getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f2990a.f2226l), 0).show();
        }
    }
}
