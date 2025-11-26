package com.sec.chaton.specialbuddy;

import android.content.DialogInterface;
import com.sec.chaton.util.C4822an;

/* compiled from: AbstractChatONLiveFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4541f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractChatONLiveFragment f16401a;

    DialogInterfaceOnClickListenerC4541f(AbstractChatONLiveFragment abstractChatONLiveFragment) {
        this.f16401a = abstractChatONLiveFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                if (!C4822an.m18251s()) {
                    this.f16401a.m17120f();
                    break;
                } else {
                    this.f16401a.m17121g();
                    break;
                }
            case 1:
                this.f16401a.m17120f();
                break;
        }
    }
}
