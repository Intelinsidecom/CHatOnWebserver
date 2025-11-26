package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyGroupDeleteTask;

/* renamed from: com.sec.chaton.buddy.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0115h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f660a;

    DialogInterfaceOnClickListenerC0115h(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f660a = buddyGroupEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 4, new BuddyGroupDeleteTask(this.f660a.f512j, this.f660a.f509g.m663a()));
    }
}
