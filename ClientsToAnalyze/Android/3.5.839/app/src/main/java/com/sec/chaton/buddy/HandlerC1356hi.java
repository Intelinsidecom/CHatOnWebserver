package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hi */
/* loaded from: classes.dex */
class HandlerC1356hi extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4935a;

    HandlerC1356hi(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4935a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String string2;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4935a.f4066A != null) {
            this.f4935a.m6932d();
            if (message.what == 103) {
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    this.f4935a.f4093u.setVisibility(8);
                    if (this.f4935a.getActivity() != null) {
                        C5179v.m19811a(this.f4935a.getActivity(), this.f4935a.getResources().getString(R.string.done), 0).show();
                        return;
                    }
                    return;
                }
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    string2 = this.f4935a.getResources().getString(R.string.popup_no_network_connection);
                } else if (c0778b.m3111f() == 16003) {
                    string2 = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0778b.m3111f() == 16004) {
                    string2 = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0778b.m3111f() == 16005) {
                    string2 = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else if (c0778b.m3111f() == 50005) {
                    string2 = this.f4935a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                } else {
                    string2 = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                C5179v.m19811a(this.f4935a.getActivity(), string2, 0).show();
                return;
            }
            if (c0778b.m3107b() != EnumC2464o.SUCCESS) {
                int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a2 || -2 == iM10677a2) {
                    string = this.f4935a.getResources().getString(R.string.popup_no_network_connection);
                } else if (c0778b.m3111f() == 16003) {
                    string = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0778b.m3111f() == 16004) {
                    string = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0778b.m3111f() == 16005) {
                    string = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else if (c0778b.m3111f() == 50005) {
                    string = this.f4935a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                } else {
                    string = this.f4935a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                C5179v.m19811a(this.f4935a.getActivity(), string, 0).show();
                return;
            }
            C5179v.m19811a(this.f4935a.getActivity(), this.f4935a.getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f4935a.f4085m), 0).show();
        }
    }
}
