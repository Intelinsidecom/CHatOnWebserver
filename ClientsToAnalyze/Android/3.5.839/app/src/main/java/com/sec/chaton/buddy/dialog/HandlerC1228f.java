package com.sec.chaton.buddy.dialog;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;
import com.sec.chaton.buddy.CallableC1330gj;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p065io.entry.FlagImageURLEntry;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.f */
/* loaded from: classes.dex */
class HandlerC1228f extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4728a;

    HandlerC1228f(BuddyDialog buddyDialog) {
        this.f4728a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, UnsupportedEncodingException {
        FlagImageURLEntry flagImageURLEntry;
        String string;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 100:
                this.f4728a.m7136A();
                C4904y.m18639b("****** IGNORE : " + this.f4728a.f4509d, BuddyDialog.f4430a);
                if (c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    if (this.f4728a.m7233n()) {
                        C5179v.m19810a(this.f4728a.getApplicationContext(), R.string.toast_network_unable, 0).show();
                    }
                    this.f4728a.m7245t();
                    return;
                } else {
                    C5179v.m19811a(this.f4728a.getApplicationContext(), this.f4728a.getApplicationContext().getResources().getString(R.string.buddy_suggestion_popup_ignored, this.f4728a.f4510e), 0).show();
                    this.f4728a.setResult(-1);
                    this.f4728a.finish();
                    return;
                }
            case 303:
                this.f4728a.m7136A();
                if (!c0778b.m18954n()) {
                    this.f4728a.f4464aF.setVisibility(0);
                    this.f4728a.f4506ax.setVisibility(8);
                    this.f4728a.f4467aI.setVisibility(8);
                    this.f4728a.f4466aH.setVisibility(8);
                    this.f4728a.f4465aG.setVisibility(8);
                    this.f4728a.f4469aK.setVisibility(8);
                    this.f4728a.f4468aJ.setVisibility(8);
                    this.f4728a.f4508az.setVisibility(8);
                    this.f4728a.f4507ay.setVisibility(0);
                    this.f4728a.f4459aA.setVisibility(0);
                    this.f4728a.f4505aw.setText(this.f4728a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed));
                    return;
                }
                C4904y.m18639b("************** RESULT CODE : " + c0778b.m3107b(), "ADD BUDDY");
                if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    C5179v.m19811a(this.f4728a.getApplicationContext(), this.f4728a.getApplicationContext().getResources().getString(R.string.add_buddy_added, this.f4728a.f4510e), 0).show();
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.ADDED, this.f4728a.f4509d));
                    this.f4728a.setResult(-1);
                    this.f4728a.finish();
                    return;
                }
                C4904y.m18639b("*********** ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                C4904y.m18639b("*********** ADD BUDDY RESULT : " + c0778b.m3111f(), null);
                if (c0778b.m3111f() == 16003) {
                    string = this.f4728a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
                } else if (c0778b.m3111f() == 16004) {
                    string = this.f4728a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    new C2128i(null).m9504a(false);
                } else if (c0778b.m3111f() != 16005) {
                    if (this.f4728a.f4462aD && TextUtils.isEmpty(this.f4728a.f4510e)) {
                        this.f4728a.f4510e = this.f4728a.f4509d;
                    }
                    string = String.format(this.f4728a.getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f4728a.f4510e);
                } else {
                    string = this.f4728a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                }
                this.f4728a.f4505aw.setText(string);
                this.f4728a.f4464aF.setVisibility(0);
                this.f4728a.f4506ax.setVisibility(8);
                this.f4728a.f4467aI.setVisibility(8);
                this.f4728a.f4466aH.setVisibility(8);
                this.f4728a.f4465aG.setVisibility(8);
                this.f4728a.f4469aK.setVisibility(8);
                this.f4728a.f4507ay.setVisibility(8);
                this.f4728a.f4459aA.setVisibility(8);
                this.f4728a.f4468aJ.setVisibility(8);
                this.f4728a.f4508az.setVisibility(0);
                return;
            case 324:
                if (c0778b != null) {
                    try {
                    } catch (Exception e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS && (flagImageURLEntry = (FlagImageURLEntry) c0778b.m3110e()) != null && !TextUtils.isEmpty(flagImageURLEntry.fileurl)) {
                        this.f4728a.f4491ai.m19023b(this.f4728a.f4504av, new CallableC1330gj(flagImageURLEntry.fileurl, this.f4728a.f4519n, this.f4728a.f4520o + ".png"));
                        return;
                    }
                    return;
                }
                return;
            case 602:
                this.f4728a.m7136A();
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    if (this.f4728a.f4524s == null) {
                        this.f4728a.f4524s = new C1106c(this.f4728a.f4509d, this.f4728a.f4510e);
                    }
                    C2212z.m10068a(C2212z.m10066a(), 2, new C2246g(this.f4728a.f4517l, this.f4728a.f4524s, 2, false));
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.BLOCKED, this.f4728a.f4509d));
                    return;
                }
                C5179v.m19811a(this.f4728a.getApplicationContext(), this.f4728a.getApplicationContext().getResources().getString(R.string.buddy_profile_block_toast_failed), 0).show();
                return;
            case 603:
                this.f4728a.m7136A();
                if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                    if (this.f4728a.m7233n()) {
                        C5179v.m19810a(this.f4728a.getApplicationContext(), R.string.toast_network_unable, 0).show();
                        return;
                    }
                    return;
                } else {
                    C4904y.m18639b("****** UNBLOCK : " + this.f4728a.f4509d, BuddyDialog.f4430a);
                    C5179v.m19811a(this.f4728a.getApplicationContext(), this.f4728a.getApplicationContext().getResources().getString(R.string.setting_buddy_unblocked, this.f4728a.f4510e), 0).show();
                    this.f4728a.finish();
                    return;
                }
            default:
                return;
        }
    }
}
