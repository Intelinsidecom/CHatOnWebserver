package com.sec.chaton.buddy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.v */
/* loaded from: classes.dex */
class HandlerC0446v extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0442r f1695a;

    HandlerC0446v(C0442r c0442r) {
        this.f1695a = c0442r;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string;
        C0101b c0101b = (C0101b) message.obj;
        if (message.what == 303) {
            if (this.f1695a.f1688w != null && this.f1695a.f1688w.isShowing()) {
                this.f1695a.f1688w.dismiss();
            }
            if (!c0101b.m664a()) {
                Toast.makeText(this.f1695a.f1671f, this.f1695a.f1671f.getString(R.string.buddy_list_dialog_addbuddy_network_failed), 1).show();
                return;
            }
            C1786r.m6061b("************** RESULT CODE : " + c0101b.m665b(), "ADD BUDDY");
            if (c0101b.m665b() == EnumC0803m.SUCCESS) {
                String str = String.format(this.f1695a.f1671f.getString(R.string.add_buddy_success_toast), this.f1695a.f1690y);
                Intent intent = new Intent(this.f1695a.f1671f, (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", this.f1695a.f1689x);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f1695a.f1690y);
                intent.setFlags(268435456);
                this.f1695a.f1671f.startActivity(intent);
                Toast.makeText(this.f1695a.f1671f, str, 1).show();
                return;
            }
            C1786r.m6061b("*********** ADD BUDDY RESULT : " + c0101b.m673f(), null);
            C1786r.m6061b("*********** ADD BUDDY RESULT : " + c0101b.m673f(), null);
            if (c0101b.m673f() == 16003) {
                string = this.f1695a.f1671f.getString(R.string.buddy_profile_dialog_addbuddy_failed_your_self);
            } else {
                string = c0101b.m673f() == 16004 ? this.f1695a.f1671f.getString(R.string.buddy_list_dialog_addbuddy_failed_already_added) : c0101b.m673f() == 16005 ? this.f1695a.f1671f.getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy) : String.format(this.f1695a.f1671f.getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f1695a.f1690y);
            }
            Toast.makeText(this.f1695a.f1671f, string, 1).show();
        }
    }
}
