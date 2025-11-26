package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.Iterator;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.d */
/* loaded from: classes.dex */
class HandlerC0342d extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1485a;

    HandlerC0342d(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1485a = addBuddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String str;
        C0101b c0101b = (C0101b) message.obj;
        if (this.f1485a.f863b) {
            this.f1485a.f863b = false;
            return;
        }
        if ((message.what == 303 || message.what == 307) && this.f1485a.getActivity() != null) {
            try {
                if (this.f1485a.f877p != null && this.f1485a.f877p.isShowing()) {
                    this.f1485a.f877p.dismiss();
                }
            } catch (Exception e) {
            }
            if (c0101b.m664a()) {
                if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                    this.f1485a.m1879c();
                    if (message.what == 303) {
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
                        Toast.makeText(this.f1485a.getActivity(), String.format(this.f1485a.getResources().getString(R.string.add_buddy_success_toast), str), 1).show();
                        this.f1485a.getActivity().setResult(-1);
                        this.f1485a.getActivity().finish();
                        return;
                    }
                    if (message.what == 307) {
                        this.f1485a.m1870a((GetBuddyList) c0101b.m671d());
                        return;
                    }
                    return;
                }
                if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                    new AlertDialogBuilderC2120a(this.f1485a.getActivity()).setTitle(this.f1485a.getResources().getString(R.string.ams_attention_title)).setMessage(String.format(this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1485a.f858O)).setPositiveButton(this.f1485a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), null);
                if (c0101b.m673f() == 16003) {
                    string = this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                } else if (c0101b.m673f() == 16004) {
                    string = this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0101b.m673f() == 16005) {
                    string = this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                }
                new AlertDialogBuilderC2120a(this.f1485a.getActivity()).setTitle(this.f1485a.getResources().getString(R.string.ams_attention_title)).setMessage(string).setPositiveButton(this.f1485a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                return;
            }
            new AlertDialogBuilderC2120a(this.f1485a.getActivity()).setTitle(this.f1485a.getResources().getString(R.string.ams_attention_title)).setMessage(this.f1485a.getResources().getString(R.string.dev_network_error)).setNegativeButton(this.f1485a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0369e(this)).setPositiveButton(this.f1485a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
        }
    }
}
