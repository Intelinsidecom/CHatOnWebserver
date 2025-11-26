package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0643f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.h */
/* loaded from: classes.dex */
class HandlerC0443h extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1435a;

    HandlerC0443h(BuddyFragment buddyFragment) {
        this.f1435a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 602) {
            if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1435a.f1148f, this.f1435a.f1112V, 2, false));
                return;
            } else {
                if (this.f1435a.getActivity() != null) {
                    this.f1435a.m2088E();
                    C1619g.m5889a(this.f1435a.f1153k, this.f1435a.getResources().getString(R.string.buddy_list_block_toast_failed), 0).show();
                    return;
                }
                return;
            }
        }
        if (message.what == 303) {
            if (this.f1435a.getActivity() != null) {
                this.f1435a.m2181u();
                this.f1435a.m2088E();
                if (c0259g.m927a()) {
                    if (c0259g.m928b() != EnumC0518y.SUCCESS) {
                        if (c0259g.m928b() == EnumC0518y.NO_CONTENT) {
                            new AlertDialogBuilderC1625m(this.f1435a.f1153k).setTitle(String.format(this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f1435a.f1112V.m2308a())).setPositiveButton(this.f1435a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                        C1341p.m4663f("ADD BUDDY RESULT : " + c0259g.m934f(), BuddyFragment.f1090a);
                        if (c0259g.m934f() == 16003) {
                            string = this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                        } else if (c0259g.m934f() == 16004) {
                            string = this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                        } else if (c0259g.m934f() == 16005) {
                            string = this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                        } else {
                            string = this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                        }
                        new AlertDialogBuilderC1625m(this.f1435a.f1153k).setTitle(string).setPositiveButton(this.f1435a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    return;
                }
                new AlertDialogBuilderC1625m(this.f1435a.f1153k).setTitle(this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f1435a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0371af(this)).setNegativeButton(this.f1435a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                return;
            }
            return;
        }
        if (message.what == 906 && this.f1435a.getActivity() != null) {
            C0259g c0259g2 = (C0259g) message.obj;
            if (c0259g2.m927a() && c0259g2.m928b() != EnumC0518y.ERROR) {
                C1619g.m5889a(this.f1435a.getActivity(), this.f1435a.getResources().getString(R.string.toast_save_media), 0).show();
            } else {
                C1619g.m5889a(this.f1435a.getActivity(), this.f1435a.getResources().getString(R.string.dev_network_error), 0).show();
            }
            this.f1435a.m2088E();
        }
    }
}
