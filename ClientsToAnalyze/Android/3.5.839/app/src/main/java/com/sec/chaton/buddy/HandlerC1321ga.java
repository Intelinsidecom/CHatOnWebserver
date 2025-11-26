package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p065io.entry.FlagImageURLEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ga */
/* loaded from: classes.dex */
class HandlerC1321ga extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4857a;

    HandlerC1321ga(BuddyProfileFragment buddyProfileFragment) {
        this.f4857a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        FlagImageURLEntry flagImageURLEntry;
        String string;
        if (this.f4857a.f3954aU != null && this.f4857a.f4011r != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 100:
                    this.f4857a.m6832j();
                    C4904y.m18639b("****** IGNORE : " + this.f4857a.f4013t, BuddyProfileFragment.f3906a);
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        C5179v.m19811a(this.f4857a.f3954aU, this.f4857a.f3954aU.getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f4857a.f4014u), 0).show();
                        this.f4857a.f3954aU.finish();
                        return;
                    } else {
                        C5179v.m19810a(this.f4857a.f3954aU, R.string.toast_network_unable, 0).show();
                        return;
                    }
                case 303:
                    this.f4857a.m6832j();
                    if (!c0778b.m18954n()) {
                        this.f4857a.f3986ba.setText(this.f4857a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed));
                        return;
                    }
                    C4904y.m18639b("************** RESULT CODE : " + c0778b.m3107b(), "ADD BUDDY");
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        C5179v.m19811a(this.f4857a.f3954aU, this.f4857a.f3954aU.getResources().getString(R.string.add_buddy_added, this.f4857a.f4014u), 0).show();
                        FragmentActivity activity = this.f4857a.getActivity();
                        this.f4857a.getActivity();
                        activity.setResult(-1);
                        this.f4857a.f3954aU.finish();
                        return;
                    }
                    C4904y.m18639b("*********** ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                    C4904y.m18639b("*********** ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                    if (c0778b.m3111f() == 16003) {
                        string = this.f4857a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                    } else if (c0778b.m3111f() == 16004) {
                        string = this.f4857a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0778b.m3111f() == 16005) {
                        string = this.f4857a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = String.format(this.f4857a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f4857a.f4014u);
                    }
                    this.f4857a.f3986ba.setText(string);
                    return;
                case 324:
                    if (c0778b != null) {
                        try {
                            try {
                            } catch (Exception e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                            }
                        } catch (OutOfMemoryError e2) {
                            e2.printStackTrace();
                        }
                        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0778b.m3110e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                            this.f4857a.f3943aJ.m19023b(this.f4857a.f3988bc, new CallableC1330gj(flagImageURLEntry.fileurl, this.f4857a.f3989bd, this.f4857a.f3990be + ".png"));
                            return;
                        }
                        return;
                    }
                    return;
                case 602:
                    this.f4857a.m6832j();
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        C5179v.m19811a(this.f4857a.f3954aU, this.f4857a.f3954aU.getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                        return;
                    }
                    if (this.f4857a.f4012s == null) {
                        this.f4857a.f4012s = new C1106c(this.f4857a.f4013t, this.f4857a.f4014u);
                    }
                    C2212z.m10068a(new C2212z(), 2, new C2246g(this.f4857a.f4001h, this.f4857a.f4012s, 2, false));
                    return;
                case 603:
                    this.f4857a.m6832j();
                    if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                        C5179v.m19810a(this.f4857a.f3954aU, R.string.toast_network_unable, 0).show();
                        return;
                    }
                    C4904y.m18639b("****** UNBLOCK : " + this.f4857a.f4013t, BuddyProfileFragment.f3906a);
                    C5179v.m19811a(this.f4857a.f3954aU, this.f4857a.f3954aU.getResources().getString(R.string.setting_buddy_unblocked, this.f4857a.f4014u), 0).show();
                    this.f4857a.f3954aU.finish();
                    return;
                case 901:
                    this.f4857a.m6832j();
                    if (this.f4857a.f3977as != null) {
                        this.f4857a.f3977as.setVisibility(8);
                    }
                    this.f4857a.m6853a(c0778b);
                    return;
                case 903:
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f4857a.m6832j();
                        if (c0778b.m3111f() == 90016) {
                            AbstractC4932a.m18733a(this.f4857a.f3954aU).mo18740a(this.f4857a.getResources().getString(R.string.poston_title)).mo18749b(this.f4857a.getResources().getString(R.string.trunk_content_deleted)).mo18755c(this.f4857a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1322gb(this)).mo18752b();
                            return;
                        } else {
                            C5179v.m19811a(this.f4857a.f3954aU, this.f4857a.getResources().getString(R.string.ams_msg_cannot_delete_file), 0).show();
                            return;
                        }
                    }
                    this.f4857a.f3940aG = true;
                    this.f4857a.m6832j();
                    this.f4857a.m6853a(c0778b);
                    C5179v.m19810a(this.f4857a.f3954aU, R.string.poston_deleted, 0).show();
                    return;
                default:
                    return;
            }
        }
    }
}
