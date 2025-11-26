package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4655cm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f16866a;

    DialogInterfaceOnClickListenerC4655cm(TrunkView trunkView) {
        this.f16866a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iOrdinal = EnumC4575b.Recent.ordinal();
        int iOrdinal2 = EnumC4575b.UnreadComment.ordinal();
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16866a.m17470a(EnumC4660cr.Nonetwork);
        } else if (i == this.f16866a.f16648t.ordinal()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Current item == Selected item", TrunkView.f16613c);
            }
            dialogInterface.dismiss();
            return;
        } else if (i == iOrdinal) {
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal)), TrunkView.f16613c);
                C4904y.m18639b(String.format("Current: %s, New: %s", this.f16866a.f16648t, EnumC4575b.Recent), TrunkView.f16613c);
            }
            this.f16866a.m17473a(true, true, EnumC4575b.Recent);
        } else if (i == iOrdinal2) {
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal2)), TrunkView.f16613c);
                C4904y.m18639b(String.format("Current: %s, New: %s", this.f16866a.f16648t, EnumC4575b.UnreadComment), TrunkView.f16613c);
            }
            this.f16866a.m17473a(true, true, EnumC4575b.UnreadComment);
        } else if (C4904y.f17874d) {
            C4904y.m18645d(String.format("Unknown ordering type. %s", Integer.valueOf(i)), TrunkView.f16613c);
        }
        dialogInterface.dismiss();
    }
}
