package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bi */
/* loaded from: classes.dex */
class HandlerC0401bi extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1375a;

    HandlerC0401bi(BuddyProfileActivity buddyProfileActivity) {
        this.f1375a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (message.what == 306) {
            C1341p.m4658b("check buddy isConnectionSuccess()=" + c0259g.m927a() + ", result=" + c0259g.m928b() + ", fault=" + c0259g.m934f(), "BUDDY PROFILE");
            if (c0259g.m927a() && c0259g.m928b() == EnumC0518y.ERROR && c0259g.m934f() == 15007) {
                this.f1375a.f1206H.setVisibility(0);
                this.f1375a.f1209K.setVisibility(8);
                this.f1375a.f1207I.setVisibility(8);
                this.f1375a.f1208J.setVisibility(0);
                this.f1375a.f1210L.setVisibility(0);
                this.f1375a.f1211M.setText(this.f1375a.getResources().getString(R.string.new_buddy_information_unblock, this.f1375a.f1246q.getText().toString()));
            } else if (!c0259g.m927a() || c0259g.m928b() != EnumC0518y.ERROR || c0259g.m934f() != 15009) {
                this.f1375a.f1206H.setVisibility(0);
                this.f1375a.f1209K.setVisibility(0);
                this.f1375a.f1207I.setVisibility(0);
                this.f1375a.f1208J.setVisibility(8);
                this.f1375a.f1210L.setVisibility(8);
                this.f1375a.f1211M.setText(this.f1375a.getResources().getString(R.string.new_buddy_information, this.f1375a.f1246q.getText().toString()));
            } else {
                this.f1375a.f1206H.setVisibility(8);
                this.f1375a.f1211M.setText(this.f1375a.getResources().getString(R.string.toast_deleted_account, this.f1375a.f1246q.getText().toString()));
            }
        }
        this.f1375a.m2272g();
    }
}
