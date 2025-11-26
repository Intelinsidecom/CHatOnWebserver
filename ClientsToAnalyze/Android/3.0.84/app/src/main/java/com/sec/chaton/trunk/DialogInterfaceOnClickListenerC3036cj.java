package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3036cj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f10917a;

    DialogInterfaceOnClickListenerC3036cj(TrunkView trunkView) {
        this.f10917a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iOrdinal = EnumC2959b.Recent.ordinal();
        int iOrdinal2 = EnumC2959b.UnreadComment.ordinal();
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10917a.m10372a(EnumC3040cn.Nonetwork);
        } else if (i == this.f10917a.f10703t.ordinal()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Current item == Selected item", TrunkView.f10665c);
            }
            dialogInterface.dismiss();
            return;
        } else if (i == iOrdinal) {
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal)), TrunkView.f10665c);
                C3250y.m11450b(String.format("Current: %s, New: %s", this.f10917a.f10703t, EnumC2959b.Recent), TrunkView.f10665c);
            }
            this.f10917a.m10375a(true, true, EnumC2959b.Recent);
        } else if (i == iOrdinal2) {
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal2)), TrunkView.f10665c);
                C3250y.m11450b(String.format("Current: %s, New: %s", this.f10917a.f10703t, EnumC2959b.UnreadComment), TrunkView.f10665c);
            }
            this.f10917a.m10375a(true, true, EnumC2959b.UnreadComment);
        } else if (C3250y.f11736d) {
            C3250y.m11455d(String.format("Unknown ordering type. %s", Integer.valueOf(i)), TrunkView.f10665c);
        }
        dialogInterface.dismiss();
    }
}
