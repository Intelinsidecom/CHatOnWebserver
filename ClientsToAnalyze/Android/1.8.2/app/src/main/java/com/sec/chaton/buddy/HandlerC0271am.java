package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.am */
/* loaded from: classes.dex */
class HandlerC0271am extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1366a;

    HandlerC0271am(BuddyFragment buddyFragment) {
        this.f1366a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 602) {
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1366a.f1005g, this.f1366a.f978ao, 2, false));
                if (BuddyFragment.f912bc.keySet().contains(this.f1366a.f978ao.m2318a())) {
                    this.f1366a.getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyBuddyFragment(), "container").commitAllowingStateLoss();
                    return;
                }
                return;
            }
            if (this.f1366a.getActivity() != null) {
                if (this.f1366a.f989az != null && this.f1366a.f989az.isShowing()) {
                    this.f1366a.f989az.dismiss();
                }
                Toast.makeText(this.f1366a.f1018t, this.f1366a.getResources().getString(R.string.buddy_list_block_toast_failed), 0).show();
                return;
            }
            return;
        }
        if (message.what == 303) {
            if (this.f1366a.getActivity() != null) {
                this.f1366a.m1917J();
                if (this.f1366a.f989az != null && this.f1366a.f989az.isShowing()) {
                    this.f1366a.f989az.dismiss();
                }
                if (c0101b.m664a()) {
                    if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                        Toast.makeText(this.f1366a.f1018t, String.format(this.f1366a.getResources().getString(R.string.add_buddy_success_toast), this.f1366a.f978ao.m2324b()), 1).show();
                        return;
                    }
                    if (c0101b.m665b() == EnumC0803m.NO_CONTENT) {
                        new AlertDialogBuilderC2120a(this.f1366a.f1018t).setTitle(this.f1366a.getResources().getString(R.string.pop_up_attention)).setMessage(String.format(this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1366a.f978ao.m2318a())).setPositiveButton(this.f1366a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    C1786r.m6067f("ADD BUDDY RESULT : " + c0101b.m673f(), BuddyFragment.f908a);
                    if (c0101b.m673f() == 16003) {
                        string = this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0101b.m673f() == 16004) {
                        string = this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0101b.m673f() == 16005) {
                        string = this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    new AlertDialogBuilderC2120a(this.f1366a.f1018t).setTitle(this.f1366a.getResources().getString(R.string.pop_up_attention)).setMessage(string).setPositiveButton(this.f1366a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                new AlertDialogBuilderC2120a(this.f1366a.f1018t).setTitle(this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setNegativeButton(this.f1366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0272an(this)).setPositiveButton(this.f1366a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                return;
            }
            return;
        }
        if (message.what == 906) {
            if (this.f1366a.getActivity() != null) {
                C0101b c0101b2 = (C0101b) message.obj;
                if (!c0101b2.m664a() || c0101b2.m665b() == EnumC0803m.ERROR) {
                    if (this.f1366a.f989az != null && this.f1366a.f989az.isShowing()) {
                        this.f1366a.f989az.dismiss();
                    }
                    Toast.makeText(this.f1366a.getActivity(), this.f1366a.getResources().getString(R.string.dev_network_error), 0).show();
                    return;
                }
                Toast.makeText(this.f1366a.getActivity(), this.f1366a.getResources().getString(R.string.toast_save_media), 0).show();
                this.f1366a.m1921L();
                if (this.f1366a.f989az != null && this.f1366a.f989az.isShowing()) {
                    this.f1366a.f989az.dismiss();
                    return;
                }
                return;
            }
            return;
        }
        if (message.what == 605) {
            if (this.f1366a.f989az != null && this.f1366a.f989az.isShowing()) {
                this.f1366a.f989az.dismiss();
            }
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                Toast.makeText(this.f1366a.getActivity(), this.f1366a.getResources().getString(R.string.setting_buddylist_blocked, this.f1366a.f949aK.size() + ""), 0).show();
                this.f1366a.f949aK.clear();
                this.f1366a.getActivity().finish();
            } else {
                Toast.makeText(this.f1366a.getActivity(), R.string.dev_network_error, 0).show();
                this.f1366a.getActivity().finish();
            }
        }
    }
}
