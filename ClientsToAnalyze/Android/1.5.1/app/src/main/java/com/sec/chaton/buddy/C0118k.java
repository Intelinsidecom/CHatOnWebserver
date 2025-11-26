package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyGroupAddTask;

/* renamed from: com.sec.chaton.buddy.k */
/* loaded from: classes.dex */
class C0118k implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f698a;

    C0118k(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f698a = buddyGroupEditActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f698a.m547a(this.f698a.f515m);
        this.f698a.f500M = this.f698a.f515m.getText().toString().trim();
        this.f698a.f500M = this.f698a.f500M.replace(",", "");
        if (this.f698a.f500M.length() > 0 && !this.f698a.f500M.equals("")) {
            NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 3, new BuddyGroupAddTask(this.f698a.f512j, this.f698a.f500M, 3));
        }
        return true;
    }
}
