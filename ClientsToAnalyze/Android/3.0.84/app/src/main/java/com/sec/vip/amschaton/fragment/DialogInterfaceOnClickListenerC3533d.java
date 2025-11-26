package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C3425b;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3533d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12953a;

    /* renamed from: b */
    final /* synthetic */ int f12954b;

    /* renamed from: c */
    final /* synthetic */ AMSBgSelectionFragment f12955c;

    DialogInterfaceOnClickListenerC3533d(AMSBgSelectionFragment aMSBgSelectionFragment, int i, int i2) {
        this.f12955c = aMSBgSelectionFragment;
        this.f12953a = i;
        this.f12954b = i2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f12953a) {
            case 1002:
                C3425b.m12268a().m12285b(this.f12955c.getActivity(), this.f12954b);
                this.f12955c.m12393g(this.f12954b + 10000);
                break;
            case 1003:
                this.f12955c.m12393g(this.f12954b);
                break;
        }
        this.f12955c.m12524a(R.string.ams_msg_deleted);
        this.f12955c.m12396h();
    }
}
