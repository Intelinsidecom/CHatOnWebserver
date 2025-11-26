package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.util.Iterator;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.do */
/* loaded from: classes.dex */
class HandlerC0357do extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1501a;

    HandlerC0357do(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1501a = buddyRecommendFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String str;
        C0101b c0101b = (C0101b) message.obj;
        if (this.f1501a.getActivity() != null) {
            if (this.f1501a.f1169e != null) {
                this.f1501a.f1169e.dismiss();
            }
            if (message.what == 303) {
                if (c0101b.m664a()) {
                    if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                        GetBuddyList getBuddyList = (GetBuddyList) c0101b.m671d();
                        if (getBuddyList != null) {
                            Iterator it = getBuddyList.buddy.iterator();
                            str = null;
                            while (it.hasNext()) {
                                str = ((Buddy) it.next()).name;
                            }
                        } else {
                            str = null;
                        }
                        Toast.makeText(this.f1501a.getActivity(), String.format(this.f1501a.getResources().getString(R.string.add_buddy_success_toast), str), 1).show();
                        this.f1501a.f1165a.notifyDataSetChanged();
                        return;
                    }
                    if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                        new AlertDialogBuilderC2120a(this.f1501a.getActivity()).setTitle(this.f1501a.getResources().getString(R.string.toast_error)).setMessage(String.format(this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1501a.f1174j)).setPositiveButton(this.f1501a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0358dp(this)).show();
                        return;
                    }
                    C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                    if (c0101b.m673f() == 16003) {
                        string = this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0101b.m673f() == 16004) {
                        string = this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0101b.m673f() == 16005) {
                        string = this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    new AlertDialogBuilderC2120a(this.f1501a.getActivity()).setTitle(this.f1501a.getResources().getString(R.string.toast_error)).setMessage(string).setPositiveButton(this.f1501a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0359dq(this)).show();
                    return;
                }
                new AlertDialogBuilderC2120a(this.f1501a.getActivity()).setTitle(this.f1501a.getResources().getString(R.string.toast_error)).setMessage(this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1501a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0360dr(this)).setNegativeButton(this.f1501a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                return;
            }
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1501a.getActivity(), this.f1501a.getResources().getString(R.string.done), 0).show();
            } else {
                C2153y.m7535a(this.f1501a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
        }
    }
}
