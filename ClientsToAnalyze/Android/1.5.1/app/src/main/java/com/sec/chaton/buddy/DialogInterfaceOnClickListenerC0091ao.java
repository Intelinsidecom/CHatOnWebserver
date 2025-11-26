package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyGroupDeleteTask;

/* renamed from: com.sec.chaton.buddy.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0091ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0107bd f630a;

    DialogInterfaceOnClickListenerC0091ao(MenuItemOnMenuItemClickListenerC0107bd menuItemOnMenuItemClickListenerC0107bd) {
        this.f630a = menuItemOnMenuItemClickListenerC0107bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 4, new BuddyGroupDeleteTask(this.f630a.f650a.f449e, Integer.parseInt(this.f630a.f650a.f428S.m668a())));
    }
}
