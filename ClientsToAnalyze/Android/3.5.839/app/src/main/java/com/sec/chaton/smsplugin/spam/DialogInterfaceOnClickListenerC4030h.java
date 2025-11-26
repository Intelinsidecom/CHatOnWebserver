package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;
import android.database.Cursor;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4030h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f14533a;

    /* renamed from: b */
    final /* synthetic */ Cursor f14534b;

    /* renamed from: c */
    final /* synthetic */ ManageSpamMessages f14535c;

    DialogInterfaceOnClickListenerC4030h(ManageSpamMessages manageSpamMessages, ArrayList arrayList, Cursor cursor) {
        this.f14535c = manageSpamMessages;
        this.f14533a = arrayList;
        this.f14534b = cursor;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14535c.m15303c(R.string.deleting);
        new Thread(new RunnableC4031i(this)).start();
    }
}
