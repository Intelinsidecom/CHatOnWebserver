package com.sec.chaton.buddy.dialog;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.CallableC0698fi;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p035io.entry.FlagImageURLEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.e */
/* loaded from: classes.dex */
class HandlerC0623e extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f2843a;

    HandlerC0623e(BuddyDialog buddyDialog) {
        this.f2843a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        FlagImageURLEntry flagImageURLEntry;
        String string;
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 100:
                this.f2843a.m4186v();
                C3250y.m11450b("****** IGNORE : " + this.f2843a.f2666d, BuddyDialog.f2599a);
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f2843a.getApplicationContext(), this.f2843a.getApplicationContext().getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f2843a.f2667e), 0).show();
                    this.f2843a.setResult(-1);
                    this.f2843a.finish();
                    return;
                }
                C3641ai.m13210a(this.f2843a.getApplicationContext(), R.string.toast_network_unable, 0).show();
                return;
            case 303:
                this.f2843a.m4186v();
                if (!c0267d.m11704n()) {
                    this.f2843a.f2664ay.setVisibility(0);
                    this.f2843a.f2659at.setVisibility(8);
                    this.f2843a.f2629aB.setVisibility(8);
                    this.f2843a.f2628aA.setVisibility(8);
                    this.f2843a.f2665az.setVisibility(8);
                    this.f2843a.f2631aD.setVisibility(8);
                    this.f2843a.f2630aC.setVisibility(8);
                    this.f2843a.f2661av.setVisibility(8);
                    this.f2843a.f2660au.setVisibility(0);
                    this.f2843a.f2662aw.setVisibility(0);
                    this.f2843a.f2658as.setText(this.f2843a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed));
                    return;
                }
                C3250y.m11450b("************** RESULT CODE : " + c0267d.m1351b(), "ADD BUDDY");
                if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3641ai.m13211a(this.f2843a.getApplicationContext(), this.f2843a.getApplicationContext().getResources().getString(R.string.add_buddy_added, this.f2843a.f2667e), 0).show();
                    this.f2843a.setResult(-1);
                    this.f2843a.finish();
                    return;
                }
                C3250y.m11450b("*********** ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                C3250y.m11450b("*********** ADD BUDDY RESULT : " + c0267d.m1355f(), null);
                if (c0267d.m1355f() == 16003) {
                    string = this.f2843a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                } else if (c0267d.m1355f() == 16004) {
                    string = this.f2843a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                } else if (c0267d.m1355f() == 16005) {
                    string = this.f2843a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                } else {
                    string = String.format(this.f2843a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f2843a.f2667e);
                }
                this.f2843a.f2658as.setText(string);
                this.f2843a.f2664ay.setVisibility(0);
                this.f2843a.f2659at.setVisibility(8);
                this.f2843a.f2629aB.setVisibility(8);
                this.f2843a.f2628aA.setVisibility(8);
                this.f2843a.f2665az.setVisibility(8);
                this.f2843a.f2631aD.setVisibility(8);
                this.f2843a.f2660au.setVisibility(8);
                this.f2843a.f2662aw.setVisibility(8);
                this.f2843a.f2630aC.setVisibility(8);
                this.f2843a.f2661av.setVisibility(0);
                return;
            case 324:
                if (c0267d != null) {
                    try {
                    } catch (Exception e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                    if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0267d.m1354e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                        this.f2843a.f2642ac.m11730a(this.f2843a.f2657ar, new CallableC0698fi(flagImageURLEntry.fileurl, this.f2843a.f2673k, this.f2843a.f2674l + ".png"));
                        return;
                    }
                    return;
                }
                return;
            case 602:
                this.f2843a.m4186v();
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    if (this.f2843a.f2679q == null) {
                        this.f2843a.f2679q = new C0513c(this.f2843a.f2666d, this.f2843a.f2667e);
                    }
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2843a.f2672j, this.f2843a.f2679q, 2, false));
                    return;
                }
                C3641ai.m13211a(this.f2843a.getApplicationContext(), this.f2843a.getApplicationContext().getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            case 603:
                this.f2843a.m4186v();
                if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    C3250y.m11450b("****** UNBLOCK : " + this.f2843a.f2666d, BuddyDialog.f2599a);
                    C3641ai.m13211a(this.f2843a.getApplicationContext(), this.f2843a.getApplicationContext().getResources().getString(R.string.setting_buddy_unblocked, this.f2843a.f2667e), 0).show();
                    this.f2843a.finish();
                    return;
                }
                C3641ai.m13210a(this.f2843a.getApplicationContext(), R.string.toast_network_unable, 0).show();
                return;
            default:
                return;
        }
    }
}
