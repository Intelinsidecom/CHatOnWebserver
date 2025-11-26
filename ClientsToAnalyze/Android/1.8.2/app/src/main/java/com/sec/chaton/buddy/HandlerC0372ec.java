package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.ec */
/* loaded from: classes.dex */
class HandlerC0372ec extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1523a;

    HandlerC0372ec(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1523a = buddyRecommendListFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (this.f1523a.getActivity() != null) {
            if (this.f1523a.f1186d != null) {
                this.f1523a.f1186d.dismiss();
            }
            if (message.what == 303) {
                if (c0101b.m664a()) {
                    if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                        C2153y.m7536a(this.f1523a.getActivity(), "'" + this.f1523a.f1192j + "' " + this.f1523a.getResources().getString(R.string.buddy_suggestion_added_to_list), 0).show();
                        this.f1523a.f1183a.notifyDataSetChanged();
                        if (this.f1523a.f1184b != null) {
                            this.f1523a.f1184b.setEmptyView(this.f1523a.f1185c);
                            return;
                        }
                        return;
                    }
                    if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                        new AlertDialogBuilderC2120a(this.f1523a.getActivity()).setTitle(this.f1523a.getResources().getString(R.string.toast_error)).setMessage(String.format(this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1523a.f1192j)).setPositiveButton(this.f1523a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0373ed(this)).show();
                        return;
                    }
                    C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                    if (c0101b.m673f() == 16003) {
                        string = this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0101b.m673f() == 16004) {
                        string = this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0101b.m673f() == 16005) {
                        string = this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    new AlertDialogBuilderC2120a(this.f1523a.getActivity()).setTitle(this.f1523a.getResources().getString(R.string.toast_error)).setMessage(string).setPositiveButton(this.f1523a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0374ee(this)).show();
                    return;
                }
                return;
            }
            if (message.what == 311) {
                if (c0101b.m664a()) {
                    if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                        this.f1523a.f1193k.setVisibility(8);
                        if (this.f1523a.getActivity() != null) {
                            C2153y.m7536a(this.f1523a.getActivity(), this.f1523a.getResources().getString(R.string.done), 0).show();
                        }
                        this.f1523a.getActivity().finish();
                        return;
                    }
                    C2153y.m7535a(this.f1523a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
                    return;
                }
                new AlertDialogBuilderC2120a(this.f1523a.getActivity()).setTitle(this.f1523a.getResources().getString(R.string.toast_error)).setMessage(this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1523a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0375ef(this)).setNegativeButton(this.f1523a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                return;
            }
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                C2153y.m7536a(this.f1523a.getActivity(), this.f1523a.getResources().getString(R.string.done), 0).show();
            } else {
                C2153y.m7535a(this.f1523a.getActivity(), R.string.buddy_list_dialog_addbuddy_network_failed, 0).show();
            }
        }
    }
}
