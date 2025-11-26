package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import java.util.ArrayList;

/* compiled from: TellFriendsPreferenceAct.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1398bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f5259a;

    /* renamed from: b */
    final /* synthetic */ String f5260b;

    /* renamed from: c */
    final /* synthetic */ TellFriendsPreferenceAct f5261c;

    DialogInterfaceOnClickListenerC1398bz(TellFriendsPreferenceAct tellFriendsPreferenceAct, ArrayList arrayList, String str) {
        this.f5261c = tellFriendsPreferenceAct;
        this.f5259a = arrayList;
        this.f5260b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5261c.m4934a((String) this.f5259a.get(i), this.f5260b);
    }
}
