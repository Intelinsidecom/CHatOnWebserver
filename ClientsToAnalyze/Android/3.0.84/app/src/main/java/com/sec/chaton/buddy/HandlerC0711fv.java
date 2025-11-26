package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fv */
/* loaded from: classes.dex */
class HandlerC0711fv extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2952a;

    HandlerC0711fv(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2952a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0267d c0267d = (C0267d) message.obj;
        if (this.f2952a.f2178J != null) {
            if (this.f2952a.f2193f != null) {
                this.f2952a.f2193f.dismiss();
            }
            if (message.what == 303) {
                if (!c0267d.m11704n()) {
                    AbstractC3271a.m11494a(this.f2952a.f2178J).mo11500a(this.f2952a.getResources().getString(R.string.toast_error)).mo11509b(this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo11510b(this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0714fy(this)).mo11501a(this.f2952a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                } else if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    GetBuddyList getBuddyList = (GetBuddyList) c0267d.m1354e();
                    if (getBuddyList != null) {
                        this.f2952a.f2199l = getBuddyList.buddy.get(0).name;
                    }
                    C3641ai.m13211a(this.f2952a.f2178J, this.f2952a.getResources().getString(R.string.add_buddy_added, this.f2952a.f2199l), 0).show();
                    this.f2952a.f2190c.notifyDataSetChanged();
                } else if (c0267d.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f2952a.f2199l = BuddyRecommendFragment.m3771a(this.f2952a.f2178J.getContentResolver(), this.f2952a.f2197j);
                    AbstractC3271a.m11494a(this.f2952a.f2178J).mo11500a(this.f2952a.getResources().getString(R.string.toast_error)).mo11509b(String.format(this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f2952a.f2199l)).mo11510b(this.f2952a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0712fw(this)).mo11512b();
                } else {
                    C3250y.m11458g("ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                    if (c0267d.m1355f() == 16003) {
                        string = this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0267d.m1355f() == 16004) {
                        string = this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0267d.m1355f() == 16005) {
                        string = this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else if (c0267d.m1355f() == 50005) {
                        string = this.f2952a.getResources().getString(R.string.samsung_account_mapping_not_finished);
                    } else {
                        string = this.f2952a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    AbstractC3271a.m11494a(this.f2952a.f2178J).mo11500a(this.f2952a.getResources().getString(R.string.toast_error)).mo11509b(string).mo11510b(this.f2952a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0713fx(this)).mo11512b();
                }
            } else if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                C3641ai.m13211a(this.f2952a.f2178J, this.f2952a.getResources().getString(R.string.done), 0).show();
            } else {
                C3641ai.m13210a(this.f2952a.f2178J, R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
            this.f2952a.f2200m = this.f2952a.m3767a();
            if (this.f2952a.f2200m > 0) {
                this.f2952a.f2191d.removeFooterView(this.f2952a.f2180L);
            } else {
                this.f2952a.f2191d.removeFooterView(this.f2952a.f2180L);
                this.f2952a.f2191d.addFooterView(this.f2952a.f2180L);
            }
        }
    }
}
