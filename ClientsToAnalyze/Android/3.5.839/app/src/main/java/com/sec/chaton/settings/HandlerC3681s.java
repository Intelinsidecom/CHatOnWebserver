package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.s */
/* loaded from: classes.dex */
class HandlerC3681s extends Handler {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13281a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3681s(AccountFragment accountFragment, Looper looper) {
        super(looper);
        this.f13281a = accountFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f13281a.f12487n != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 335:
                    this.f13281a.m13331a((C0778b) message.obj);
                    break;
                case 411:
                    if (this.f13281a.f12488o != null && this.f13281a.f12488o.isShowing()) {
                        this.f13281a.f12488o.dismiss();
                    }
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        Toast.makeText(this.f13281a.f12487n, R.string.toast_network_unable, 0).show();
                        break;
                    } else if (((BuddyProfile) c0778b.m3110e()) != null && this.f13281a.f12485k != null) {
                        this.f13281a.f12485k.notifyDataSetChanged();
                        if (this.f13281a.f12484j != null) {
                            this.f13281a.f12484j.setAdapter((ListAdapter) this.f13281a.f12485k);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
