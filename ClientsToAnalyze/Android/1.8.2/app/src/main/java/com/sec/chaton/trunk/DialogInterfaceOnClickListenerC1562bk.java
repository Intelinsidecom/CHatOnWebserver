package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.trunk.p048b.EnumC1551b;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.bk */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1562bk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f5639a;

    DialogInterfaceOnClickListenerC1562bk(TrunkView trunkView) {
        this.f5639a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iOrdinal = EnumC1551b.Recent.ordinal();
        int iOrdinal2 = EnumC1551b.UnreadComment.ordinal();
        if (i == this.f5639a.f5529q.ordinal()) {
            if (C1786r.f6452b) {
                C1786r.m6061b("Current item == Selected item", TrunkView.f5509c);
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
                return;
            }
            return;
        }
        if (i == iOrdinal) {
            if (C1786r.f6452b) {
                C1786r.m6061b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal)), TrunkView.f5509c);
                C1786r.m6061b(String.format("Current: %s, New: %s", this.f5639a.f5529q, EnumC1551b.Recent), TrunkView.f5509c);
            }
            this.f5639a.m5326a(true, true, EnumC1551b.Recent);
        } else if (i == iOrdinal2) {
            if (C1786r.f6452b) {
                C1786r.m6061b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal2)), TrunkView.f5509c);
                C1786r.m6061b(String.format("Current: %s, New: %s", this.f5639a.f5529q, EnumC1551b.UnreadComment), TrunkView.f5509c);
            }
            this.f5639a.m5326a(true, true, EnumC1551b.UnreadComment);
        } else if (C1786r.f6454d) {
            C1786r.m6065d(String.format("Unknown ordering type. %s", Integer.valueOf(i)), TrunkView.f5509c);
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
