package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0558bp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2517a;

    DialogInterfaceOnClickListenerC0558bp(BuddyFragment buddyFragment) {
        this.f2517a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i + 11) {
            case 11:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11847a("00030006", "00000001");
                }
                this.f2517a.f1789aa = 11;
                this.f2517a.m3228H();
                if (this.f2517a.f1790ab != this.f2517a.f1789aa) {
                    this.f2517a.m3214A();
                    break;
                }
                break;
            case 12:
            case 13:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                }
                this.f2517a.f1789aa = 13;
                this.f2517a.m3228H();
                if (this.f2517a.f1790ab != this.f2517a.f1789aa) {
                    this.f2517a.m3214A();
                    break;
                }
                break;
        }
        this.f2517a.f1808at.dismiss();
    }
}
