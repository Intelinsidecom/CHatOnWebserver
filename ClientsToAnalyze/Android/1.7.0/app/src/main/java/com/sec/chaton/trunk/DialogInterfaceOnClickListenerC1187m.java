package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.trunk.p043c.EnumC1152a;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1187m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f4056a;

    DialogInterfaceOnClickListenerC1187m(TrunkView trunkView) {
        this.f4056a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iOrdinal = EnumC1152a.Recent.ordinal();
        int iOrdinal2 = EnumC1152a.UnreadComment.ordinal();
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f4056a.m4065b();
        } else if (i == this.f4056a.f3848q.ordinal()) {
            if (C1341p.f4578b) {
                C1341p.m4658b("Current item == Selected item", TrunkView.f3825b);
            }
            dialogInterface.dismiss();
            return;
        } else if (i == iOrdinal) {
            if (C1341p.f4578b) {
                C1341p.m4658b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal)), TrunkView.f3825b);
                C1341p.m4658b(String.format("Current: %s, New: %s", this.f4056a.f3848q, EnumC1152a.Recent), TrunkView.f3825b);
            }
            this.f4056a.m4062a(true, true, EnumC1152a.Recent);
        } else if (i == iOrdinal2) {
            if (C1341p.f4578b) {
                C1341p.m4658b(String.format("Which: %s, New: %s", Integer.valueOf(i), Integer.valueOf(iOrdinal2)), TrunkView.f3825b);
                C1341p.m4658b(String.format("Current: %s, New: %s", this.f4056a.f3848q, EnumC1152a.UnreadComment), TrunkView.f3825b);
            }
            this.f4056a.m4062a(true, true, EnumC1152a.UnreadComment);
        } else if (C1341p.f4580d) {
            C1341p.m4661d(String.format("Unknown ordering type. %s", Integer.valueOf(i)), TrunkView.f3825b);
        }
        ((ChatActivity) this.f4056a.getActivity()).m2600d(this.f4056a.f3839h);
        dialogInterface.dismiss();
    }
}
